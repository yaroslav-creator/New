package com.javarush.games.racer;

import com.javarush.engine.cell.*;
import com.javarush.games.racer.road.RoadManager;

public class RacerGame extends Game {

    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int CENTER_X = WIDTH / 2;
    public static final int ROADSIDE_WIDTH = 14;
    private static final int RACE_GOAL_CARS_COUNT = 40;

    private RoadMarking roadMarking;
    private PlayerCar player;
    private RoadManager roadManager;
    private boolean isGameStopped;
    private FinishLine finishLine;
    private ProgressBar progressBar;
    private int score;

    // Тут выполняем все действия по инициализации игры и ее объектов
    @Override
    public void initialize() {
        showGrid( false );
        setScreenSize( WIDTH, HEIGHT );
        createGame();
    }

    // Переопределяем метод, чтобы вызов родительского метода происходил только
    //с координатами, лежащими на игровом поле.
    @Override
    public void setCellColor(int x, int y, Color color) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT)
            super.setCellColor( x, y, color );
    }

    //  Старт новой игры.
    private void createGame() {
        isGameStopped = false;
        roadMarking = new RoadMarking();
        player = new PlayerCar();
        roadManager = new RoadManager();
        finishLine = new FinishLine();
        progressBar = new ProgressBar( RACE_GOAL_CARS_COUNT );
        setTurnTimer( 40 );
        score = 3500;
        drawScene();
    }

    // Игра окончена.
    private void gameOver() {
        isGameStopped = true;
        showMessageDialog( Color.RED, "GAME OVER", Color.BLACK, 50 );
        stopTurnTimer();
        player.stop();
    }

    //Это победа.
    private void win() {
        isGameStopped = true;
        showMessageDialog( Color.BLUE, "VICTORY", Color.YELLOW, 50 );
        stopTurnTimer();

    }

    //Отрисовка всех игровых объектов.
    private void drawScene() {
        drawField();
        roadMarking.draw( this );
        player.draw( this );
        roadManager.draw( this );
        finishLine.draw( this );
        progressBar.draw( this );
    }

    //Метод будет перемещать все подвижные игровые объекты.
    private void moveAll() {
        roadMarking.move( player.speed );
        player.move();
        roadManager.move( player.speed );
        finishLine.move( player.speed );
        progressBar.move( roadManager.getPassedCarsCount() );

    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    // Метод выбора старт или стоп игры
    @Override
    public void onTurn(int step) {
        if (roadManager.getPassedCarsCount() >= RACE_GOAL_CARS_COUNT) {
            finishLine.show();
        }

        if (roadManager.checkCrush( player )) {
            gameOver();

        }
        score = score - 5;
        setScore( score );

        if (finishLine.isCrossed( player )) {
            win();

        } else {
            moveAll();
            roadManager.generateNewRoadObjects( this );
        }
        drawScene();
    }

    // Отрисовка фона игрового поля.
    private void drawField() {

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                if (x == CENTER_X)
                    setCellColor( CENTER_X, y, Color.WHITE );
                else if (x >= ROADSIDE_WIDTH && x < (WIDTH - ROADSIDE_WIDTH))
                    setCellColor( x, y, Color.DIMGRAY );
                else
                    setCellColor( x, y, Color.GREEN );
            }
        }
    }

    // Метод, реализации нажатия клавиш
    @Override
    public void onKeyPress(Key key) {
        if (key.equals( Key.RIGHT ))
            player.setDirection( Direction.RIGHT );
        if (key.equals( Key.LEFT ))
            player.setDirection( Direction.LEFT );
        if (key.equals( Key.SPACE ) && (this.isGameStopped))
            createGame();
        if (key.equals( Key.UP ))
            player.setSpeed( 2 );
    }
    // Можно и так
    //@Override
    //    public void onKeyPress(Key key) {
    //        switch (key){
    //            case LEFT: {
    //                player.setDirection(Direction.LEFT);
    //                break;
    //            }
    //            case RIGHT: {
    //                player.setDirection(Direction.RIGHT);
    //                break;
    //            }
    //            case SPACE: {
    //                if (isGameStopped) createGame();
    //                break;
    //            }
    //            case UP: {
    //                player.setSpeed(player.speed * 2);
    //                break;
    //            }
    //            default: {
    //                player.setDirection(Direction.NONE);
    //            }
    //        }
    //    }

    // Метод, реализации отпускания клавиш
    @Override
    public void onKeyReleased(Key key) {

        if (key.equals( Key.RIGHT ) && player.getDirection().equals( Direction.RIGHT )) {
            player.setDirection( Direction.NONE );
        }
        if (key.equals( Key.LEFT ) && player.getDirection().equals( Direction.LEFT )) {
            player.setDirection( Direction.NONE );
        }
        if (key.equals( Key.UP )) {
            player.setSpeed( 1 );
        }
    }
}
