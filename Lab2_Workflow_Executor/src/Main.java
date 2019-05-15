import java.io.IOException;
import java.util.logging.LogManager;

public class Main {

    public static void main(String[] args) {
        String filename;
        if (args.length > 0 && args[0] != null) {
            filename = args[0];
        }
        else {
            System.err.println("Please, write path to file");
            return;
        }
        try {
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("logging.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        WorkflowExecutor exec = new WorkflowExecutor();
        exec.work(filename);
    }
}
