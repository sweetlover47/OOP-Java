import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    private final int imageSize = (new ImageIcon("src\\resources\\0.png")).getIconHeight();
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
        JMenuItem item2 = new JMenuItem("High Scores");
        JMenuItem item3 = new JMenuItem("About");
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.newGame();
                view.endGame();
                view.newGame();
            }
        });
        menuBar.add(item1);
        menuBar.add(item2);
        menuBar.add(item3);
        setJMenuBar(menuBar);
        //panel.add(menuBar, BorderLayout.PAGE_START);

        Container container = getContentPane();
        container.add(panel, BorderLayout.CENTER);
        setResizable(false);
    }
}
