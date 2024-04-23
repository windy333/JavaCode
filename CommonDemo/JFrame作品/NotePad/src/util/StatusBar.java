package util;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StatusBar {
    private JLabel positionLabel;
    private JLabel encodingLabel;

    public StatusBar() {
        positionLabel = new JLabel();
        encodingLabel = new JLabel("enCoding：Utf-8");
    }

    public JToolBar createStatusBar() {
        JToolBar statusBar = new JToolBar();
        statusBar.setFloatable(false);
        statusBar.setBorder(new EmptyBorder(5, 5, 5, 5)); // 设置状态栏边框
        statusBar.setLayout(new BorderLayout()); // 设置布局管理器为BorderLayout

        // 设置标签字体和边框
        Font labelFont = new Font("SansSerif", Font.PLAIN, 12); // 选择合适的字体和大小
        positionLabel.setFont(labelFont);
        positionLabel.setBorder(new EmptyBorder(0, 0, 0, 10)); // 设置位置标签右边距
        encodingLabel.setFont(labelFont);
        encodingLabel.setBorder(new EmptyBorder(0, 10, 0, 0)); // 设置编码标签左边距

        // 添加标签到状态栏
        statusBar.add(positionLabel, BorderLayout.WEST);
        statusBar.add(encodingLabel, BorderLayout.EAST);

        return statusBar;
    }

    public void updatePosition(int line, int column) {
        positionLabel.setText("当前行: " + line +"    "+"当前列: " + column);
    }
}
