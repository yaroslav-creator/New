package com.javarush.games.racer.road;

import com.javarush.engine.cell.Game;
import com.javarush.games.racer.PlayerCar;
import com.javarush.games.racer.RacerGame;

import java.util.ArrayList;
import java.util.List;

//он управляет всеми препятствиями на дороге
public class RoadManager {

    public static final int LEFT_BORDER = RacerGame.ROADSIDE_WIDTH;
    public static final int RIGHT_BORDER = RacerGame.WIDTH - LEFT_BORDER;

    //крайняя левая позиция координат x матриц объектов-препятствий на проезжей части
    private static final int FIRST_LANE_POSITION = 16;
    //крайняя правая позиции координат x матриц объектов-препятствий на проезжей части
    private static final int FOURTH_LANE_POSITION = 44;

    //расстояние между машинами
    private static final int PLAYER_CAR_DISTANCE = 12;

    //Подсчет реального количества машин, с которыми разминулся игрок.
    //Значение этого поля должно увеличиваться на единицу после прохождения каждой
    // машины-препятствия (удаления машины из списка items).
    private int passedCarsCount = 0;

    //список всех объектов-препятствий.
    private List<RoadObject> items = new ArrayList<>();

    //который возвращает значение поля passedCarsCount
    public int getPassedCarsCount() {
        return passedCarsCount;
    }

    //Проверка условия: столкнулась ли машина с преградой.
    public boolean checkCrush(PlayerCar playerCar) {
        for (RoadObject object : items) {
            if (object.isCollision( playerCar )) return true;
        }
        return false;
    }

    // Проверка условия: На трассе должно быть не больше одного объекта Thorn одновременно.
    private boolean isThornExists() {
        for (RoadObject object : items) {
            if (object.type.equals( RoadObjectType.THORN )) return true;
        }
        return false;
    }

    // Проверка условия: достаточно ли места на дороге для размещения новой машины
    private boolean isRoadSpaceFree(RoadObject object) {
//        for (RoadObject roadObject : items) {
//            roadObject.isCollisionWithDistance( object, PLAYER_CAR_DISTANCE );
//        }
//        return true;
//        int count = 0;
//        for (RoadObject roadObject : items){
//            if (roadObject.isCollisionWithDistance(object, PLAYER_CAR_DISTANCE)){
//                count ++;
//            }
//        }
//        return count == items.size() || count == 0;

        int count = 0;
        for (RoadObject roadObject : items) {
            if (roadObject.isCollisionWithDistance( object, PLAYER_CAR_DISTANCE )) count++;
        }
        return count <= 0;
    }

    //Проверка условия: чтобы на трассе одновременно была только одна машина с пьяным водителем.
    private boolean isMovingCarExists() {
        for (RoadObject object : items) {
            if (object.type.equals( RoadObjectType.DRUNK_CAR ))
                return true;
        }
        return false;
    }

    // Метод генерации шипов — генерировать новые с вероятностью 10%.
    private void generateThorn(Game game) {
        if (game.getRandomNumber( 100 ) < 10 && !isThornExists())
            addRoadObject( RoadObjectType.THORN, game );
    }

    //Метод генерации всех препятствий.
    public void generateNewRoadObjects(Game game) {
        generateThorn( game );
        generateRegularCar( game );
        generateMovingCar( game );
    }

    //Чтобы генерировались новые шипы, старые нужно удалять из списка items после того,
    // как они вышли за пределы экрана.
    private void deletePassedItems() {
        List<RoadObject> itemX = new ArrayList<>( items );
        for (RoadObject object : itemX) {
            if (object.y >= RacerGame.HEIGHT) {
                items.remove( object );
                if (object.type != RoadObjectType.THORN) {
                    passedCarsCount++;
                }
            }
        }
    }

    //Метод, который создает все дорожные объекты
    private RoadObject createRoadObject(RoadObjectType type, int x, int y) {
        if (type == RoadObjectType.THORN)
            return new Thorn( x, y );

        if (type == RoadObjectType.DRUNK_CAR)
            return new MovingCar( x, y );

        else return new Car( type, x, y );
    }

    //Метод для генерации новых машин.
    private void generateRegularCar(Game game) {
        int carTypeNumber = game.getRandomNumber( 4 );
        if (game.getRandomNumber( 100 ) < 30) {
            addRoadObject( RoadObjectType.values()[carTypeNumber], game );
        }
    }

    //Метод для генерации новых машин с пьяным водителем.
    private void generateMovingCar(Game game) {
        if (game.getRandomNumber( 100 ) < 10 && !isMovingCarExists()) {
            addRoadObject( RoadObjectType.DRUNK_CAR, game );
        }
    }

    //будет генерировать позицию нового препятствия и добавлять его в список всех объектов-препятствий.
    private void addRoadObject(RoadObjectType type, Game game) {

        //случайное число в пределах проезжей части
        int x = game.getRandomNumber( FIRST_LANE_POSITION, FOURTH_LANE_POSITION );
        //изначально объект располагается за пределами игрового поля, чтобы появиться плавно.
        int y = -1 * RoadObject.getHeight( type );

        RoadObject roadObject = createRoadObject( type, x, y );
        if (isRoadSpaceFree( roadObject )) {
            items.add( roadObject );
        }
    }

    public void draw(Game game) {
        for (RoadObject object : items) {
            object.draw( game );
        }
    }

    public void move(int boost) {
        for (RoadObject object : items) {
            object.move( boost + object.speed, items );
        }
        deletePassedItems();
    }
}
