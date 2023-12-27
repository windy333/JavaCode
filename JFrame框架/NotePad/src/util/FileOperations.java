package util;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileOperations {
    private static NotepadMainFrame mainFrame;

    public FileOperations(NotepadMainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }


    public static void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(mainFrame);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                // 使用UTF-8编码读取文件
                String content = new String(Files.readAllBytes(Paths.get(file.getPath())), StandardCharsets.UTF_8);
                mainFrame.getTextArea().setText(content);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(mainFrame, "文件不能被打开", "错误", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        // 设置文件过滤器，只显示和保存.txt文件
        FileNameExtensionFilter filter = new FileNameExtensionFilter("文本文件 (*.txt)", "txt");
        fileChooser.setFileFilter(filter);
        // 可选，不允许选择所有文件类型
        fileChooser.setAcceptAllFileFilterUsed(false);

        int option = fileChooser.showSaveDialog(mainFrame);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            // 确保文件后缀为.txt
            if (!file.getName().toLowerCase().endsWith(".txt")) {
                file = new File(file.getParentFile(), file.getName() + ".txt");
            }
            try {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(mainFrame.getTextArea().getText());
                fileWriter.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(mainFrame, "文件不能被保存", "错误", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    //这里会直接新建一个文件，没有保护模式
    public static void newFile() {
        mainFrame.getTextArea().setText("");
    }

}
