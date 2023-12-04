package castle.gameObjects;

import castle.*;

public class SmallMonster extends GameObject implements Interactable {
    public SmallMonster(Vector2 position) {
        this.position = position;
        this.renderer = new Renderer("Sm", "\u001B[33m");
    }
    public void interact(Hero hero) {
        if (!askTask()) {
            hero.takeDamage();
        }

        Hierarchy.getInstance().removeObject(this);
    }

    private boolean askTask() {
        int first = (int) (Math.random() * 1000);
        int second = (int) (Math.random() * 1000);

        System.out.println(first + " + " + second);
        String result = Input.readString();

        return Integer.parseInt(result) == first + second;
    }
}