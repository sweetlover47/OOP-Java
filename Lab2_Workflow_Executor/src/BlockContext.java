final public class BlockContext {
    private final String cmd;
    private final String[] args;

    BlockContext(String cmd, String[] args) {
        this.args = args;
        this.cmd = cmd;
    }

    String getCommand() {
        return cmd;
    }

    String[] getArgs() {
        return args;
    }

}
