public class ViewText implements ViewInterface{
    @Override
    public void update(int[][] board) {
        for (int[] line: board) {
            for (int i : line)
                System.out.print(i + "\t");
            System.out.println();
        }
    }

    @Override
    public void installSettings(){
        System.out.println("Enter size of board and num of mines (\"9 9 10\" is meaning board 9x9 with 10 mines)");
    }

    @Override
    public void quitSettings(){
        System.out.println("Settings complete");
    }

    @Override
    public  void startGame(Position pos){
        System.out.println("Game is started");
    }

    @Override
    public void endGame(){
        System.out.println("Game is ended");
    }

    @Override
    public void sendMessage(String message){
        System.out.println(message);
    }

    @Override
    public void newGame() {

    }
}
