package castle;

import castle.gameObjects.Castle;
import castle.gameObjects.Hero;

public class GameCycle {
    private static Hierarchy hierarchy;
    private static Hero hero;

    public static void main(String[] args) {
        var check = new Vector2(0, 5).isValid();
        System.out.println(check);
        //Initialize();
        //CycleCircle();
    }

    public static void Initialize() {
        hierarchy = Hierarchy.getInstance();

        var castle = new Castle(new Vector2((int) (Math.random() * hierarchy.SIZE.x), 0));
        hierarchy.addObject(castle);
        hero = new Hero(new Vector2((int) (Math.random() * hierarchy.SIZE.x), hierarchy.SIZE.y - 1));
        hierarchy.addObject(hero);
    }

    public static void CycleCircle() {
        while (true) {
            RenderPipeline.RenderHierarchy();
            hero.Move(Input.readDirection());
        }
    }
}