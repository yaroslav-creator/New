package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score;
    int maxTile;

    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();

    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (!emptyTiles.isEmpty() & emptyTiles.size() != 0)
            emptyTiles.get( (int) (emptyTiles.size() * Math.random()) ).value = Math.random() < 0.9 ? 2 : 4;
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();
        for (Tile[] gameTile : gameTiles) {
            for (int j = 0; j < gameTiles.length; j++) {
                if (gameTile[j].isEmpty()) {
                    emptyTiles.add( gameTile[j] );
                }
            }
        }
        return emptyTiles;
    }

    void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    //  Сжатие плиток, таким образом, чтобы все пустые плитки были справа, т.е. ряд {4, 2, 0, 4}
// становится рядом {4, 2, 4, 0}
    private boolean compressTiles(Tile[] tiles) {
        boolean isChange = false;

        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (tiles[i].value == 0) {
                for (int j = i + 1; j < FIELD_WIDTH; j++) {
                    if (tiles[j].value != 0) {
                        tiles[i].value = tiles[j].value;
                        tiles[j].value = 0;
                        isChange = true;
                        break;
                    }
                }
            }
        }
        return isChange;
    }

    // Слияние плиток одного номинала, т.е. ряд {4, 4, 2, 0} становится рядом {8, 2, 0, 0}.
//Обрати внимание, что ряд {4, 4, 4, 4} превратится в {8, 8, 0, 0}, а {4, 4, 4, 0} в {8, 4, 0, 0}.
    private boolean mergeTiles(Tile[] tiles) {
        boolean isChange = false;

        for (int i = 0; i < tiles.length - 1; i++) {
            // проверить здесь &  или &&
            if ((!tiles[i].isEmpty()) && (tiles[i].value == tiles[i + 1].value)) {
                tiles[i].value += tiles[i].value;
                tiles[i + 1].value = 0;
                score += tiles[i].value;
                isChange = true;

                if (tiles[i].value > maxTile) maxTile = tiles[i].value;
                compressTiles( tiles );

            }
        }
        return isChange;
    }

    public boolean canMove() {
        for (Tile[] gameTile : gameTiles) {
            if (compressTiles( gameTile )) return true;
            if (mergeTiles( gameTile )) return true;
        }

        Tile[] tiles = new Tile[gameTiles.length];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                if (gameTiles[j][i].isEmpty()) return true;
                tiles[j] = gameTiles[j][i];
            }
            if (compressTiles( tiles )) return true;
            if (mergeTiles( tiles )) return true;
        }
        return false;
    }

    //Поворот направо (по часовой стрелке)
    public void turn() {
        Tile[][] newArray = new Tile[gameTiles.length][gameTiles.length];

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = gameTiles.length - 1; j >= 0; j--) {
                newArray[i][gameTiles.length - 1 - j] = gameTiles[j][i];
            }
        }
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray.length; j++) {
                gameTiles[i][j] = newArray[i][j];
            }
        }
    }

    public void left() {

        if (isSaveNeeded)
            saveState( gameTiles );

        for (int i = 0; i < gameTiles.length; i++) {
            boolean compress = compressTiles( gameTiles[i] );
            boolean merge = mergeTiles( gameTiles[i] );
            if (compress | merge) {
                addTile();
                isSaveNeeded = true;
            }
        }
    }

    public void right() {
        saveState( gameTiles );
        turn();
        turn();
        left();
        turn();
        turn();
    }

    public void up() {
        saveState( gameTiles );
        turn();
        turn();
        turn();
        left();
        turn();
    }

    public void down() {
        saveState( gameTiles );
        turn();
        left();
        turn();
        turn();
        turn();
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] tilesCopy = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tilesCopy[i][j] = new Tile();
            }
        }

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tilesCopy[i][j].value = tiles[i][j].value;
            }
        }
        previousStates.push( tilesCopy );
        previousScores.push( score );
        this.isSaveNeeded = false;
    }

    public void rollback() {
        if (previousScores.isEmpty() | previousStates.isEmpty()) return;
        score = previousScores.pop();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j].value = previousStates.peek()[i][j].value;
            }
        }
        gameTiles = previousStates.pop();
    }

    public void randomMove() {
        int randomInt = ((int) (Math.random() * 100)) % 4;

        switch (randomInt) {
            case (0):
                left();
                break;
            case (1):
                right();
                break;
            case (2):
                up();
                break;
            case (3):
                down();
                break;
        }
    }

    public boolean hasBoardChanged() {
        int sum1 = 0;
        int sum2 = 0;
        if (!previousStates.isEmpty()) {
            Tile[][] prevGameTiles = previousStates.peek();
            for (int i = 0; i < FIELD_WIDTH; i++) {
                for (int j = 0; j < FIELD_WIDTH; j++) {
                    sum1 += gameTiles[i][j].value;
                    sum2 += prevGameTiles[i][j].value;
                }
            }
        }
        return sum1 != sum2;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        move.move();
        MoveEfficiency moveEfficiency = hasBoardChanged() ?
                new MoveEfficiency( getEmptyTiles().size(), score, move ) :
                new MoveEfficiency( -1, 0, move );
        rollback();
        return moveEfficiency;
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> moveEfficiencies = new PriorityQueue<>( 4, Collections.reverseOrder() );

        moveEfficiencies.offer( getMoveEfficiency( this::left ) );
        moveEfficiencies.offer( getMoveEfficiency( this::up ) );
        moveEfficiencies.offer( getMoveEfficiency( this::right ) );
        moveEfficiencies.offer( getMoveEfficiency( this::down ) );

        if (moveEfficiencies.peek() != null) {
            moveEfficiencies.peek().getMove().move();
        }
    }
}