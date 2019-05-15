import java.util.Scanner;

public class Controller implements ControllerInterface{
    private final Scanner scanner = new Scanner(System.in);
    private ModelInterface model;
    private int horizontal, vertical, mines;
    private Position pos = new Position(0,0);
    Controller(ModelInterface model) {
        this.model = model;
    }

    @Override
    public void setSettings(){
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int mines = scanner.nextInt();
        if (x != 9 || y != 9 || mines != 10)
            model = new Model(x, y, mines);
        this.horizontal = x;
        this.vertical = y;
        this.mines = mines;
    }

    @Override
    public void newGame(){
        model = new Model(9,9,10);

        setSettings();
        model.newGame();
    }

    @Override
    public void setFlag() {
        model.setFlag(pos);
    }

    @Override
    public void setOpen() {
        model.setOpen(pos);
    }

    @Override
    public boolean isGameOver() {
        return model.isGameOver();
    }

    @Override
    public boolean isWin(){
        return model.isWin();
    }

    @Override
    public int[][] Board() {
        return model.board();
    }

    @Override
    public int getTurn() {
        int result = 0;
        boolean flag = false;
        Position position = new Position(0, 0);
        while (!flag) {
            String input = scanner.next();
            switch (input) {
                case "OPEN":
                    flag = true;
                    result = 1;
                    break;
                case "FLAG":
                    flag = true;
                    result = 2;
                    break;
                case "EXIT":
                    return 3;
                default:
                    flag = false;
                    break;
            }
            if (flag) {
                position.setX(Integer.parseInt(scanner.next()));
                position.setY(Integer.parseInt(scanner.next()));
                if (!model.correctPosition(position)) {
                    flag = false;
                }
            }
            if (!flag) {
                System.out.println("Enter correctly, please");
            }
        }
        pos = position;
        return result;
    }

    @Override
    public Position getSize(){
        return new Position(horizontal, vertical);
    }

    @Override
    public void setView(ViewInterface view) {

    }
    @Override
    public boolean isChanged(){
        return true;
    }

    @Override
    public boolean incorrectValues(){
        if (vertical == 0 || horizontal == 0 || mines == 0 || mines > (vertical*horizontal - 1))
            return true;
        return false;
    }
    @Override
    public void setNewSettings(String s, String s1, String s2){}
}
