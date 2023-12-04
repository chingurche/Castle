package castle;

import java.util.Scanner;

public class Input {
    public static String readString() {
        var in = new Scanner(System.in);
        return in.nextLine();
    }

    public static GameDifficulty readDifficulty() {
        var in = new Scanner(System.in);
        return switch (in.next()) {
            default -> GameDifficulty.easy;
            case "2" -> GameDifficulty.medium;
            case "3" -> GameDifficulty.hard;
        };
    }

    public static Vector2 readDirection() {
        var in = new Scanner(System.in);
        return switch (in.next()) {
            case "w", "W" -> Vector2.down();
            case "a", "A" -> Vector2.left();
            case "s", "S" -> Vector2.up();
            case "d", "D" -> Vector2.right();
            default -> Vector2.zero();
        };
    }
}
