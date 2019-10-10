package com.javarush.games.racer;

import com.javarush.games.racer.road.RoadManager;

public class PlayerCar extends GameObject {

    //поле, отвечающее за скорость
    public  int speed = 1;
    //поле, хранящее направление движения
    private Direction direction;

    private static int playerCarHeight = ShapeMatrix.PLAYER.length;

    public PlayerCar() {
        super( RacerGame.WIDTH / 2 + 2,
                RacerGame.HEIGHT - playerCarHeight - 1,
                ShapeMatrix.PLAYER );
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move() {
        if(this.direction == Direction.LEFT){
            x--;
        }
        if(this.direction == Direction.RIGHT){
            x++;
        }
        if (x < RoadManager.LEFT_BORDER) {
            x = RoadManager.LEFT_BORDER;
        }
        if (x > RoadManager.RIGHT_BORDER) {
            x = RoadManager.RIGHT_BORDER;
        }
    }

    public void stop() {
         matrix = ShapeMatrix.PLAYER_DEAD;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
