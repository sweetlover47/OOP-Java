public interface ControllerInterface {
    void setFlag();

    void setOpen();

    int getTurn();

    void setSettings();

    boolean isGameOver();

    boolean isWin();

    int[][] Board();

    void newGame();

    Position getSize();

    void setView(ViewInterface view);

    boolean isChanged();

    boolean incorrectValues();

    void setNewSettings(String s, String s1, String s2);
}
