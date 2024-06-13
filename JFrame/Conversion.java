import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Conversion extends JFrame {

    private JTextField inputField;
    private JTextField outputField;

    public Conversion() {
        setTitle("汇率换算");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel label1 = new JLabel("人民币/元：");
        inputField = new JTextField(10);
        JLabel label2 = new JLabel("美元/dollar：");
        outputField = new JTextField(10);
        JLabel label3 = new JLabel("今天的汇率为：6.87");
        JButton convertButton = new JButton("换算");

        panel.add(label1);
        panel.add(inputField);
        panel.add(label2);
        panel.add(outputField);
        panel.add(label3);
        panel.add(convertButton);
        add(panel);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double inputAmount = Double.parseDouble(inputField.getText());
                double exchangeRate = 6.87;
                double result = inputAmount /exchangeRate;
                outputField.setText("$" + result);
            }
        });
    }

    public static void main(String[] args) {
        Conversion frame = new Conversion();
        frame.setVisible(true);
    }
}