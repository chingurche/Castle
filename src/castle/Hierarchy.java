package castle;

import java.util.ArrayList;

public class Hierarchy {
    private static Hierarchy INSTANCE;

    public final Vector2 SIZE = new Vector2(5, 5);

    private ArrayList<GameObject> gameObjects = new ArrayList<>();

    private Hierarchy() {

    }

    public static Hierarchy getInstance() {
        if (INSTANCE == null){
            INSTANCE = new Hierarchy();
        }

        return INSTANCE;
    }

    public void addObject(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    public void removeObject(GameObject gameObject) {
        gameObjects.remove(gameObject);
    }

    public boolean contains(GameObject obj) {
        for (var gameObject : gameObjects) {
            if (gameObject == obj) {
                return true;
            }
        }

        return false;
    }

    public GameObject getObjectOn(Vector2 position) {
        for (var gameObject : gameObjects) {
            if (gameObject.position.x == position.x && gameObject.position.y == position.y) {
                return gameObject;
            }
        }

        return null;
    }

    /* Legacy
    public <T extends GameObject> T findObjectOfType() {
        for (var gameObject : gameObjects) {
            try {
                var t = (T) gameObject;
            }
            catch (ClassCastException e) {

            }
        }
        return null;
    }*/

    public Vector2 getRandomEmptyPosition() {
        ArrayList<Vector2> emptyPositions = new ArrayList<>();
        for (int i = 0; i < SIZE.x; i++) {
            for (int j = 0; j < SIZE.y; j++) {
                var position = new Vector2(i, j);
                if (getObjectOn(position) == null) {
                    emptyPositions.add(position);
                }
            }
        }

        return emptyPositions.get((int) (Math.random() * emptyPositions.size()));
    }
}
