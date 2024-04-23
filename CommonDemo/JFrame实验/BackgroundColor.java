import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BackgroundColor extends JFrame implements ActionListener{
    private JTextField textField;
    private JButton changeColorButton;

    public BackgroundColor() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(200, 100);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        this.add(panel);

        textField = new JTextField(20);
        panel.add(textField);

        changeColorButton = new JButton("改变颜色");
        panel.add(changeColorButton);
        changeColorButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == changeColorButton) {
            //JColorChooser Color
            Color color = JColorChooser.showDialog(null, "选择颜色",
                    Color.BLUE); //选择后默认蓝色
            if (color != null) {
                textField.setBackground(color);
            }
        }
    }

    public static void main(String[] args) {
        BackgroundColor frame = new BackgroundColor();
        frame.setVisible(true);
    }
}
