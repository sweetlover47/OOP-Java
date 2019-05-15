import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.concurrent.Flow;

public class ControllerGUI implements ControllerInterface {
    private int vertical, horizontal, mines;
    private Model model;
    private Position pos;
    private int turn;
    private ViewInterface view;
    private boolean isChanged = true;
    ControllerGUI(ModelInterface model) {
        this.model = (Model) model;
    }
    public BoardListener getListener(int x, int y){
        return new BoardListener(x, y);
    }
    public void setView(ViewInterface view) { this.view = view; }

    class BoardListener implements MouseListener {
        private int x, y;
        BoardListener(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            JButton button = (JButton) e.getSource();
            button.getModel().setArmed(true);
            if (SwingUtilities.isLeftMouseButton(e)) {
                pos = new Position(x, y);
                change(2);
            }
            if (SwingUtilities.isRightMouseButton(e)){
                pos = new Position(x, y);
                change(1);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            JButton button = (JButton) e.getSource();
            button.getModel().setArmed(true);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            JButton button = (JButton) e.getSource();
            button.getModel().setArmed(true);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton button = (JButton) e.getSource();
            button.getModel().setArmed(false);
        }

    }

    private void change(int turn) {
        isChanged = true;
        switch(turn) {
            case 1:
                setFlag();
                break;
            case 2:
                setOpen();
                break;
            default:
                break;
        }
    }

    @Override
    public void setFlag() {
        model.setFlag(pos);
        turn = 2;
    }

    @Override
    public void setOpen() {
        model.setOpen(pos);
        turn = 1;
    }

    @Override
    public int getTurn() {
        return turn;
    }

    @Override
    public void setSettings() {
        if (horizontal != 9 || vertical != 9 || mines != 10)
            model = new Model(horizontal, vertical, mines);
    }

    @Override
    public boolean isGameOver() {
        return model.isGameOver();
    }

    @Override
    public boolean isWin() {
        return model.isWin();
    }

    @Override
    public int[][] Board() {
        return model.board();
    }

    @Override
    public void newGame() {
        model = new Model(9,9,10);
        setSettings();
        isChanged = true;
        turn = 0;
        model.newGame();
    }

    public Position getSize(){
        return new Position(horizontal, vertical);
    }

    @Override
    public boolean isChanged() {
        boolean tmp = isChanged;
        isChanged = false;
        turn = 0;
        return tmp;
    }


    public void setNewSettings(String x, String y, String mines) {
        horizontal = Integer.parseInt(x);
        vertical =Integer.parseInt(y);
        this.mines = Integer.parseInt(mines);
    }

    @Override
    public boolean incorrectValues(){
        if (vertical == 0 || horizontal == 0 || mines == 0 || mines > (vertical*horizontal - 1))
            return true;
        return false;
    }
}
