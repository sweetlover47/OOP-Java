public class Position {
    private static int x, y;
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public static int getX() {
        return x;
    }
    public static int getY() {
        return y;
    }

    public static void setX(int x) {
        Position.x = x;
    }

    public static void setY(int y) {
        Position.y = y;
    }
}
