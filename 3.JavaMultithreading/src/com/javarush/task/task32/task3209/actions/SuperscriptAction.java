package com.javarush.task.task32.task3209.actions;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

//  Класс SuperscriptAction. Он будет отвечать за стиль "Надстрочный знак".

public class SuperscriptAction extends StyledEditorKit.StyledTextAction{

    public SuperscriptAction() {
        super( StyleConstants.Superscript.toString() );
    }


    public void actionPerformed(ActionEvent e) {

        JEditorPane editorPane = getEditor( e );
        MutableAttributeSet mutableAttributeSet = getStyledEditorKit( editorPane ).getInputAttributes();
        SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet(  );
        StyleConstants.setSuperscript( simpleAttributeSet, !StyleConstants.isSuperscript( mutableAttributeSet ) );
        setCharacterAttributes( editorPane, simpleAttributeSet, false );
    }
}
