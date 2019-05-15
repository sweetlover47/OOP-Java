import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Controller controller = new Controller(new Model(9, 9, 10));
        ViewText viewText = new ViewText();
        ControllerGUI controllerGUI = new ControllerGUI(new Model(9,9,10));
        ViewGUI viewGUI = new ViewGUI(controllerGUI);
        Minesweeper minesweeper = new Minesweeper(controllerGUI, viewGUI);
        minesweeper.run();
    }

}
