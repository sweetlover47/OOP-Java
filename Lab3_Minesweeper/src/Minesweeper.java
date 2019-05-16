import static java.lang.System.exit;

public class Minesweeper {
    private ControllerInterface controller;
    private ViewInterface view;
    Minesweeper(ControllerInterface controller, ViewInterface view) {
        this.controller = controller;
        this.view = view;
        view.installSettings();
        controller.setNewSettings("9", "9", "10");
        controller.setSettings();
        if (controller.getTurn() != -10) {
            view.quitSettings();
            controller.setView(view);
            view.startGame(controller.getSize());
        }
    }
    public void run() {
        while (true) {
            int turn = controller.getTurn();
            switch (turn) {
                case 1:
                    controller.setOpen();
                    break;
                case 2:
                    controller.setFlag();
                    break;
                case 3:
                    exit(0);
                default:
                    break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (controller.isChanged())
                view.update(controller.Board());
            if (controller.isGameOver()) {
                view.sendMessage("Game over :(\nStarting new game...");
            }
            else if (controller.isWin()) {
                view.sendMessage("You win!\nStarting new game...");
            }
            if (controller.isWin() || controller.isGameOver()) {
                //view.installSettings();
                controller.newGame();
                view.endGame();
                view.newGame();
                //view.quitSettings();
            }
        }
    }
}
