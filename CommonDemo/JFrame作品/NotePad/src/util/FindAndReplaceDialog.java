package util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindAndReplaceDialog extends JDialog {
    private JTextArea textArea;
    private JTextField findTextField;
    private JTextField replaceTextField;
    private JButton findButton;
    private JButton replaceButton;
    private JButton replaceAllButton;
    private int lastIndex;

    public FindAndReplaceDialog(JFrame owner, JTextArea textArea) {
        super(owner, "查找和替换", false);
        this.textArea = textArea;

        setLayout(new GridLayout(3, 1));
        add(createFindPanel());
        add(createReplacePanel());
        add(createButtonsPanel());

        pack();
        setLocationRelativeTo(owner);
    }

    private JPanel createFindPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("查找内容:"));
        findTextField = new JTextField(20);
        panel.add(findTextField);
        return panel;
    }

    private JPanel createReplacePanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("替换为:"));
        replaceTextField = new JTextField(20);
        panel.add(replaceTextField);
        return panel;
    }

    private JPanel createButtonsPanel() {
        JPanel panel = new JPanel(new FlowLayout());

        findButton = new JButton("查找下一个");
        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findNext();
            }
        });
        panel.add(findButton);

        replaceButton = new JButton("替换");
        replaceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                replace();
            }
        });
        panel.add(replaceButton);

        replaceAllButton = new JButton("替换全部");
        replaceAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                replaceAll();
            }
        });
        panel.add(replaceAllButton);

        return panel;
    }

    private void findNext() {
        String find = findTextField.getText();
        if (find != null && !find.isEmpty()) {
            String text = textArea.getText();
            lastIndex = text.indexOf(find, lastIndex);
            if (lastIndex != -1) {
                textArea.setSelectionStart(lastIndex);
                textArea.setSelectionEnd(lastIndex + find.length());
                lastIndex += find.length();
            } else {
                JOptionPane.showMessageDialog(this, "无法找到指定的文本！", "查找", JOptionPane.INFORMATION_MESSAGE);
                lastIndex = 0;
            }
        }
    }

    private void replace() {
        String find = findTextField.getText();
        String replace = replaceTextField.getText();
        if (find != null && !find.isEmpty()) {
            String text = textArea.getText();
            lastIndex = text.indexOf(find, lastIndex);
            if (lastIndex != -1) {
                textArea.replaceRange(replace, lastIndex, lastIndex + find.length());
                lastIndex += replace.length();
            } else {
                JOptionPane.showMessageDialog(this, "无法找到指定的文本！", "替换", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void replaceAll() {
        String find = findTextField.getText();
        String replace = replaceTextField.getText();
        if (find != null && !find.isEmpty()) {
            String text = textArea.getText();
            text = text.replaceAll(find, replace);
            textArea.setText(text);
        }
    }

}
