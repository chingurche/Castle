package castle.gameObjects;

import castle.*;

public class Castle extends GameObject implements Interactable {
    public Castle(Vector2 position){
        this.position = position;
        this.renderer = new Renderer("Ct", "\u001B[34m");
    }

    public void interact(Hero hero) {
        Hierarchy.getInstance().removeObject(this);
    }
}
