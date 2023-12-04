package castle;

import castle.gameObjects.BigMonster;
import castle.gameObjects.Castle;
import castle.gameObjects.Hero;
import java.util.Scanner;

public class GameCycle {
    private static GameDifficulty difficulty;
    private static Hierarchy hierarchy;
    private static Hero hero;
    private static Castle castle;

    public static GameDifficulty getDifficulty() { return difficulty; }

    public static void main(String[] args) {
        chooseDifficulty();
        initialize();
        cycleCircle();
    }

    private static void chooseDifficulty() {
        System.out.println("Choose difficulty:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");

        difficulty = Input.readDifficulty();
    }

    private static void initialize() {
        hierarchy = Hierarchy.getInstance();

        castle = new Castle(new Vector2((int) (Math.random() * hierarchy.SIZE.x), 0));
        hierarchy.addObject(castle);
        hero = new Hero(new Vector2((int) (Math.random() * hierarchy.SIZE.x), hierarchy.SIZE.y - 1));
        hierarchy.addObject(hero);
        for (int i = 0; i < 6; i++) {
            var bigMonster = new BigMonster(hierarchy.getRandomEmptyPosition());
            hierarchy.addObject(bigMonster);
        }
    }

    private static void cycleCircle() {
        while (true) {
            RenderPipeline.RenderHierarchy();
            System.out.println("Жизни: " + hero.getHealth());

            if (hero.getHealth() == 0) {
                System.out.println("Герой убит");
                return;
            }
            if (!hierarchy.contains(castle)) {
                System.out.println("Герой достиг замка");
            }

            hero.Move(Input.readDirection());
        }
    }
}