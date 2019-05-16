public interface ModelInterface {
    boolean correctPosition(Position position);
    void setFlag(Position position);
    void setOpen(Position position);
    boolean isWin();
    boolean isGameOver();
    void newGame();
    int[][] board();

    boolean isNewBoard();
}
