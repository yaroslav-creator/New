package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

/* Этот класс будет работать аналогично классу UndoMenuListener только для других пунктов меню.
Пункты меню, отвечающие за стиль, шрифт, цвет и т.д. должны быть доступны только тогда,
когда в нашем редакторе выбрана первая вкладка. */

public class TextEditMenuListener implements MenuListener {

    private View view;

    public TextEditMenuListener(View view) {
        this.view = view;
    }

    // Метод menuSelected() должен устанавливать доступность пунктов меню стиль, выравнивание, цвет и шрифт
    // в зависимости от выбранной вкладки. Из переданного параметра получать объект, над которым было
    // совершено действие. В нашем случае это будет объект с типом JMenu.

    @Override
    public void menuSelected(MenuEvent e) {
        JMenu menu = (JMenu) e.getSource();
        //У полученного меню получать список компонентов (пунктов меню).
        Component[] components = menu.getMenuComponents();

        //Для каждого пункта меню вызывать метод setEnabled, передав в качестве параметра
        // результат вызова метода isHtmlTabSelected() из представления.
        for (Component component : components)
            component.setEnabled( view.isHtmlTabSelected() );
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }

}
/* Запусти приложение и убедись, что пункты меню стиль, выравнивание, цвет и шрифт доступны
только, когда активна закладка HTML и не доступны для закладки Текст.*/