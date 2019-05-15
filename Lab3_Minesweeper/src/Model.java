import java.util.Arrays;

public class Model implements ModelInterface{
    private int vertical, horizontal;
    private int mines;
    private boolean gameOver = false;
    private int[][] hiddenField;
    private int[][] playerField;
    Model(int _x, int _y, int _mines) {
        vertical = _y;
        horizontal = _x;
        mines = _mines;
        hiddenField = new int[horizontal][vertical];
        playerField = new int[horizontal][vertical];
        int setMines = 0;
        for (int[] line : playerField)
            Arrays.fill(line, -1);
        int x, y;
        while(setMines != mines){
            x = (int) (Math.random() * 1000) % horizontal;
            y = (int) (Math.random() * 1000) % vertical;
            if (hiddenField[x][y] != 9) {
                hiddenField[x][y] = 9;
                ++setMines;
                initMine(x, y);
            }
        }
    }

    public void newGame(){
        gameOver = false;
    }

    private void initMine(int x, int y){
        for (int i = Math.max(x-1, 0); i <= Math.min(x+1, horizontal - 1); ++i)
            for (int j = Math.max(y-1, 0); j <= Math.min(y+1, vertical - 1); ++j)
                if (hiddenField[i][j] != 9)
                    ++hiddenField[i][j];
    }
/*
    public void setSettings(int x, int y, int mines){
        horizontal = x;
        vertical = y;
        this.mines = mines;
    }
*/

    @Override
    public boolean correctPosition(Position position) {
        if (position.getX()>=0 && position.getX()<horizontal && position.getY() >=0 && position.getY() < vertical)
            return true;
        return false;
    }

    @Override
    public void setFlag(Position position) {
        if (!correctPosition(position))
            return;
        if (playerField[position.getX()][position.getY()] == -2)
            playerField[position.getX()][position.getY()] = -1;
        else if (playerField[position.getX()][position.getY()] == -1)
            playerField[position.getX()][position.getY()] = -2;
    }

    @Override
    public void setOpen(Position position) {
        if (hiddenField[position.getX()][position.getY()] == 9) {
            gameOver = true;
        }
        openCell(position);
    }

    private void openCell(Position position){
        if (!correctPosition(position))
            return;
        int x = position.getX();
        int y = position.getY();
        if (playerField[x][y] != -1)
            return;
        playerField[x][y] = hiddenField[x][y];
        if (playerField[x][y] == 0) {
            for (int i = x - 1; i <= x+1; ++i)
                for (int j = y - 1; j <= y+1; ++j)
                    if (i != x || j != y)
                        openCell(new Position(i, j));
        }
    }

    @Override
    public int[][] board(){
        return playerField;
    }

    @Override
    public boolean isWin(){
        int count = 0;
        int notOpened = 0;
        for(int i = 0; i < horizontal; ++i)
            for (int j = 0; j < vertical; ++j) {
                if (hiddenField[i][j] == 9 && playerField[i][j] == -2)
                    ++count;
            }
        return (count == mines);
    }

    @Override
    public boolean isGameOver(){
        return gameOver;
    }

}


/* Имеет private-поле property, отвечающее за свойство модели
 * Инкапсулирует список подписчиков - скрытое поле subscribers
 * Подписчики регистрируются методом subscribe, который добавляет нового подписчика в список и принудительно его оповещает через notifySubscriber
 * Есть метод unsubscribe
 * Для оповещения всех подписчиков есть метод notifySubscribers
 * notifySubscriber (int num) {
 *  subscriber.modelChanged(true);
 * }*/