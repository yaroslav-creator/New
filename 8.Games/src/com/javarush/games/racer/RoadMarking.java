package com.javarush.games.racer;

import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

//  Дополнительная дорожная разметка
public class RoadMarking {

    private List<GameObject> roadMarking = new ArrayList<>();

    public RoadMarking() {
        for (int i = -4; i <= RacerGame.HEIGHT + 4; i += 8) {
            roadMarking.add(new GameObject(RacerGame.CENTER_X - 9, i, ShapeMatrix.ROAD_MARKING));
            roadMarking.add(new GameObject(RacerGame.CENTER_X + 9, i, ShapeMatrix.ROAD_MARKING));
        }
    }

    //- отвечает за передвижение
    public void move(int boost) {
        for (GameObject item : roadMarking) {
            if (item.y >= RacerGame.HEIGHT - 1) {
                item.y = item.y - RacerGame.HEIGHT - 8 + boost;
            } else {
                item.y += boost;
            }
        }
    }

    //- отвечает за отрисовку объекта.
    //В качестве аргумента метод draw(Game) принимает объект, на котором должен
    // отрисоваться. В нашем случае это текущий экземпляр класса RacerGame (this).
    public void draw(Game game) {
        for (GameObject item : roadMarking) {
            item.draw(game);
        }
    }
}
