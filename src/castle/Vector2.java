package castle;

public class Vector2 {
    public int x;
    public int y;

    public static Vector2 zero() { return new Vector2(0, 0); }
    public static Vector2 up() { return new Vector2(0, 1); }
    public static Vector2 left() { return new Vector2(-1, 0); }
    public static Vector2 down() { return new Vector2(0, -1); }
    public static Vector2 right() { return new Vector2(1, 0); }

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2 add(Vector2 other) {
        return new Vector2(x + other.x, y + other.y);
    }
    public Vector2 reduce(Vector2 other) {
        return new Vector2(x - other.x, y - other.y);
    }

    public boolean isValid() {
        var hierarchy = Hierarchy.getInstance();
        if (x < 0 || x > hierarchy.SIZE.x - 1) {
            return false;
        }
        if (y < 0 || y > hierarchy.SIZE.y - 1) {
            return false;
        }
        return true;
    }
}
