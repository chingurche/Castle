package castle;

import castle.gameObjects.Castle;
import castle.gameObjects.Hero;
import java.util.Scanner;

public class GameCycle {
    private static GameDifficulty difficulty;
    private static Hierarchy hierarchy;
    private static Hero hero;

    public GameDifficulty getDifficulty() { return difficulty; }

    public static void main(String[] args) {
        ChooseDifficulty();
        Initialize();
        CycleCircle();
    }

    private static void ChooseDifficulty() {
        System.out.println("Choose difficulty:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");

        difficulty = Input.readDifficulty();
    }

    private static void Initialize() {
        hierarchy = Hierarchy.getInstance();

        var castle = new Castle(new Vector2((int) (Math.random() * hierarchy.SIZE.x), 0));
        hierarchy.addObject(castle);
        hero = new Hero(new Vector2((int) (Math.random() * hierarchy.SIZE.x), hierarchy.SIZE.y - 1));
        hierarchy.addObject(hero);
    }

    private static void CycleCircle() {
        while (true) {
            RenderPipeline.RenderHierarchy();
            hero.Move(Input.readDirection());
        }
    }
}