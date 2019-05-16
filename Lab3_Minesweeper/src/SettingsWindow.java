import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import static java.awt.Font.BOLD;

public class SettingsWindow extends JFrame implements ActionListener{
    private JTextField widthTextField, heightTextField, minesTextField;
    private JFrame frame;
    private ControllerGUI tcontroller;
    private ViewGUI tview;
    public SettingsWindow(ControllerGUI controller, ViewGUI view) {
        tcontroller = controller;
        tview = view;
        frame = new JFrame("Settings");
        frame.setSize(300, 210);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel text = new JLabel("Min(HxW) >= 2, mines < HxW(all > 0)", SwingConstants.CENTER);
        text.setFont(new Font("Arial", BOLD, 12));
        text.setBounds(10, 10, 260, 25);
        frame.add(text);

        JLabel widthLabel = new JLabel("Width");
        widthLabel.setBounds(10, 40, 80, 25);
        frame.add(widthLabel);

        widthTextField = new JTextField(20);
        widthTextField.setBounds(100, 40, 160, 25);
        frame.add(widthTextField);

        JLabel heightLabel = new JLabel("Height");
        heightLabel.setBounds(10, 70, 80, 25);
        frame.add(heightLabel);

        heightTextField = new JTextField(20);
        heightTextField.setBounds(100, 70, 160, 25);
        frame.add(heightTextField);

        JLabel minesLabel = new JLabel("Mines");
        minesLabel.setBounds(10, 100, 80, 25);
        frame.add(minesLabel);

        minesTextField = new JTextField(20);
        minesTextField.setBounds(100, 100, 160, 25);
        frame.add(minesTextField);

        JButton loginButton = new JButton("OK");
        loginButton.setBounds(10, 130, 80, 25);
        frame.add(loginButton);

        loginButton.addActionListener(this);
        frame.setVisible(true);

        {
            controller=controller;
            /*
        super("Settings");

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
        panel.add(button);
        button.addActionListener(new MyChangeListener());
        {
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
        }
        getContentPane().add(panel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(350, 188);
        setResizable(false);
        panel.setVisible(true);
        */
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tcontroller.setNewSettings(widthTextField.getText(), heightTextField.getText(), minesTextField.getText());
        if (!tcontroller.incorrectValues()) {
            tcontroller.setSettings();
            frame.dispose();
            tview.startGame(tcontroller.getSize());
        }
    }
}
