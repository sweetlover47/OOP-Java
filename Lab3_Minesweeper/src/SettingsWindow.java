import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class SettingsWindow extends JFrame{
    private JTextField field1, field2, field3;
    public SettingsWindow(ControllerGUI controller) {
        super("Settings");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 188);
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);
        JLabel text = new JLabel("Размеры от 2 до 100, кол-во мин от 1 до W*H");
        JLabel height = new JLabel("Ширина");
        JLabel width = new JLabel("Высота");
        JLabel mines = new JLabel("Кол-во мин");
        field1 = new JTextField(20);
        field2 = new JTextField(20);
        field3 = new JTextField(20);
        JButton button = new JButton("OK");
        panel.add(text);
        panel.add(height);
        panel.add(width);
        panel.add(mines);
        panel.add(field1);
        panel.add(field2);
        panel.add(field3);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1, s2, s3;
                s1 = field1.getText();
                s2 = field2.getText();
                s3 = field3.getText();
                controller.setNewSettings(field1.getText(), field2.getText(), field3.getText());
            }
        });
        panel.add(button);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, text, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.NORTH, text, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, height, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, width, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, mines, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, height, 10, SpringLayout.SOUTH, text);
        layout.putConstraint(SpringLayout.NORTH, width, 10, SpringLayout.SOUTH, height);
        layout.putConstraint(SpringLayout.NORTH, mines, 10, SpringLayout.SOUTH, width);
        layout.putConstraint(SpringLayout.WEST, field1, 32, SpringLayout.EAST, height);
        layout.putConstraint(SpringLayout.WEST, field2, 32, SpringLayout.EAST, width);
        layout.putConstraint(SpringLayout.WEST, field3, 13, SpringLayout.EAST, mines);
        layout.putConstraint(SpringLayout.NORTH, field1, 8, SpringLayout.SOUTH, text);
        layout.putConstraint(SpringLayout.NORTH, field2, 8, SpringLayout.SOUTH, field1);
        layout.putConstraint(SpringLayout.NORTH, field3, 8, SpringLayout.SOUTH, field2);
        layout.putConstraint(SpringLayout.NORTH, button, 10, SpringLayout.SOUTH, mines);
        layout.putConstraint(SpringLayout.WEST, button, 10, SpringLayout.WEST, panel);
        setContentPane(panel);
        setResizable(false);
        panel.setVisible(true);
    }
}
