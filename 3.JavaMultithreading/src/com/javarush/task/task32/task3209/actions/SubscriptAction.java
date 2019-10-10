package com.javarush.task.task32.task3209.actions;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

//  Класс SubscriptAction, который отвечает за стиль текста "Подстрочный знак".

public class SubscriptAction extends StyledEditorKit.StyledTextAction {

    public SubscriptAction() {
        super( StyleConstants.Subscript.toString() );
    }

    public void actionPerformed(ActionEvent e) {

        JEditorPane editorPane = getEditor( e );

        if (editorPane != null){
            MutableAttributeSet mutableAttributeSet = getStyledEditorKit( editorPane ).getInputAttributes();
            SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet(  );
            StyleConstants.setSubscript( simpleAttributeSet, !StyleConstants.isSubscript( mutableAttributeSet ) );
            setCharacterAttributes( editorPane, simpleAttributeSet, false );
        }
    }
}
