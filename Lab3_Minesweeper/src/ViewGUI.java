import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
/* Доделать MyWindow, install/quit Settings */
public class ViewGUI implements ViewInterface {
    private JButton[][] buttons;
    private JFrame game;
    private SettingsWindow settingsWindow;
    private ImageIcon[] imagesMap;
    private int vertical, horizontal;
    private ControllerInterface controller;

    public ViewGUI(ControllerInterface controller) throws IOException {
        imagesMap = new ImageIcon[12];
        for (int i = 0; i < 12; ++i) {
            imagesMap[i] = new ImageIcon("src\\resources\\"+Integer.toString(i)+".png");
        }
        this.controller = controller;
        Position pos = controller.getSize();
        horizontal = pos.getX();
        vertical = pos.getY();
    }

    private ImageIcon getImage(int cell) {
        return imagesMap[(cell + 2) % 12];
    }

    @Override
    public void update(int[][] board) {
        for (int i = 0; i < horizontal; i++)
            for (int j = 0; j < vertical; j++)
                buttons[i][j].setIcon(getImage(board[i][j]));
    }

    @Override
    public void installSettings() {
        settingsWindow = new SettingsWindow((ControllerGUI) controller, this);
    }

    @Override
    public void quitSettings() {
        settingsWindow.dispose();
    }

    @Override
    public void startGame(Position pos) {
        vertical = pos.getY();
        horizontal = pos.getX();
        buttons = new JButton[horizontal][vertical];
        game = new MyWindow(horizontal, vertical, this, (ControllerGUI) controller);
        game.setVisible(true);
    }

    @Override
    public void endGame() {
        game.setVisible(false);
        game.dispose();
    }

    @Override
    public void sendMessage(String message) {
        JOptionPane.showMessageDialog(game, message, "Dialog Window", JOptionPane.DEFAULT_OPTION);
    }

    public JButton getButton(int x, int y) {
        return (buttons[x][y] = new JButton());
    }

    @Override
    public void newGame() {
        startGame(controller.getSize());
    }
}

