package com.javarush.games.racer;

public class FinishLine extends GameObject {

    private boolean isVisible = false;

    public FinishLine() {
        super( RacerGame.ROADSIDE_WIDTH, -1 * ShapeMatrix.FINISH_LINE.length, ShapeMatrix.FINISH_LINE );
    }

    public void show() {
        isVisible = true;
    }

    // Метод move(int) не должен ничего делать, если финишная линия не видна (isVisible равно false).
    // Метод move(int boost) должен увеличивать координату y финишной линии на значение boost.
    public void move(int boost) {
        if (isVisible) {
            this.y = y + boost;
        }
    }

    public boolean isCrossed(PlayerCar playerCar) {
        if (playerCar.y < this.y ) {
            return true;
        }
        return false;
    }
}
