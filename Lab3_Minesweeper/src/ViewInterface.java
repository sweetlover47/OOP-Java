public interface ViewInterface {
    void update(int[][] board);
    void installSettings();
    void quitSettings();
    void startGame(Position pos);
    void endGame();
    void sendMessage(String message);
    void newGame();
}
