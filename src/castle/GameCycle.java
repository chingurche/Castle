package castle;

import castle.gameObjects.*;

public class GameCycle {
    private static GameDifficulty difficulty;
    private static Hierarchy hierarchy;
    private static Hero hero;
    private static Castle castle;

    public static GameDifficulty getDifficulty() { return difficulty; }

    public static void main(String[] args) {
        System.out.println("The Castle by chingurche");
        chooseDifficulty();
        initialize();
        cycleCircle();
    }

    private static void chooseDifficulty() {
        System.out.println("Выберите сложность:");
        System.out.println("1. Легкий");
        System.out.println("2. Средний (нужно хотя бы немного знать разработчика)");
        System.out.println("3. Невозможный (нужно быть разработчиком)");

        difficulty = Input.readDifficulty();
    }

    private static void initialize() {
        hierarchy = Hierarchy.getInstance();

        castle = new Castle(new Vector2((int) (Math.random() * hierarchy.SIZE.x), 0));
        hierarchy.addObject(castle);
        hero = new Hero(new Vector2((int) (Math.random() * hierarchy.SIZE.x), hierarchy.SIZE.y - 1));
        hierarchy.addObject(hero);
        for (int i = 0; i < 10; i++) {
            var smallMonster = new SmallMonster(hierarchy.getRandomEmptyPosition());
            hierarchy.addObject(smallMonster);
        }
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
                return;
            }

            hero.Move(Input.readDirection());
        }
    }
}