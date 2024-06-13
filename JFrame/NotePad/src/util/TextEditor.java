package util;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;

public class TextEditor {
    private NotepadMainFrame mainFrame;

    public TextEditor(NotepadMainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void cut() {
        String selectedText = mainFrame.getTextArea().getSelectedText();
        StringSelection stringSelection = new StringSelection(selectedText);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        mainFrame.getTextArea().replaceRange("", mainFrame.getTextArea().getSelectionStart(), mainFrame.getTextArea().getSelectionEnd());
    }

    public void copy() {
        String selectedText = mainFrame.getTextArea().getSelectedText();
        StringSelection stringSelection = new StringSelection(selectedText);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    public void paste() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        try {
            String pastedText = (String) clipboard.getData(DataFlavor.stringFlavor);
            mainFrame.getTextArea().insert(pastedText, mainFrame.getTextArea().getCaretPosition());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
