import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MyWindow extends JFrame implements PropertyChangeListener {
    private final int imageSize = (new ImageIcon("src\\resources\\0.png")).getIconHeight();
    private int counter;
    MyWindow(int x, int y, ViewGUI view, ControllerGUI controller) {
        super("Minesweeper");
        super.setSize( x * imageSize, y * imageSize + 70 );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout gridLayout = new GridLayout(0, x, 1, 1);
        JPanel panel = new JPanel();
        panel.setLayout(gridLayout);
        for (int j = 0; j < y; ++j)
            for (int i = 0; i < x; ++i) {
                JButton button = view.getButton(i, j);
                button.addMouseListener(controller.getListener(i, j));
                panel.add(button);
            }
        JMenuBar menuBar = new JMenuBar();
        JMenuItem item1 = new JMenuItem("New game");
        JMenuItem item2 = new JMenuItem("Settings");
        JMenuItem item3 = new JMenuItem("About");

        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.newGame();
                view.endGame();
                view.newGame();
            }
        });

        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // controller.setNewSettings("0", "0", "0");
               // view.installSettings();
                /*controller.newGame();
                view.endGame();
                view.newGame();*/
                view.endGame();
                controller.setNewSettings("0","0","0");
                view.installSettings();
                controller.setSettings();
                if (controller.getTurn() != -10) {
                    view.quitSettings();
                    controller.setView(view);
                    view.startGame(controller.getSize());
                }
            }
        });
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MyWindow.this, "Game developer: Anastasia\nAll rights is mine.", "Dialog Window", JOptionPane.DEFAULT_OPTION);
            }
        });

        menuBar.add(item1);
        menuBar.add(item2);
        menuBar.add(item3);
        setJMenuBar(menuBar);

        Container container = getContentPane();
        container.add(panel, BorderLayout.CENTER);
        setResizable(false);
        controller.addListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(evt.getNewValue());
        counter = Integer.parseInt(evt.getNewValue().toString());
    }
}
