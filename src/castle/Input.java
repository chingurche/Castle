package castle;

import castle.Vector2;

import java.util.Scanner;

public class Input {
    public static Vector2 readDirection() {
        var in = new Scanner(System.in);
        switch (in.next()) {
            case "w", "W":
                return Vector2.down();
            case "a", "A":
                return Vector2.left();
            case "s", "S":
                return Vector2.up();
            case "d", "D":
                return Vector2.right();
            default:
                return Vector2.zero();
        }
    }
}
