package castle.gameObjects;

import castle.*;

public class BigMonster extends GameObject implements Interactable {
    private final MonsterTask[] easyTasks = new MonsterTask[] {
            new MonsterTask("какого числа начнется MGB?", "7"),
            new MonsterTask("сколько человек могут быть в команде?", "4"),
            new MonsterTask("какой язык программирования будет изучаться в MGB?", "java"),
    };
    private final MonsterTask[] mediumTasks = new MonsterTask[] {
            new MonsterTask("псевдоним разработчика", "chingurche"),
            new MonsterTask("название команды разработчика", "omicron"),
            new MonsterTask("имя наставника команды разработчика", "ксения"),
    };
    private final MonsterTask[] hardTasks = new MonsterTask[] {
            new MonsterTask("название первой игры разработчика", "cave adventure"),
            new MonsterTask("квантовое", "вмешательство"),
            new MonsterTask("это киторок", "враг геймдева"),
    };

    public BigMonster(Vector2 position) {
        this.position = position;
        this.renderer = new Renderer("Bm", "\u001B[31m");
    }

    public void interact(Hero hero) {
        if (!askTask()) {
            hero.takeDamage();
        }

        Hierarchy.getInstance().removeObject(this);
    }

    private boolean askTask() {
        MonsterTask task;
        task = switch (GameCycle.getDifficulty()) {
            case GameDifficulty.easy -> easyTasks[(int) (Math.random() * easyTasks.length)];
            case GameDifficulty.medium -> mediumTasks[(int) (Math.random() * mediumTasks.length)];
            case GameDifficulty.hard -> hardTasks[(int) (Math.random() * hardTasks.length)];
        };

        return task.ask();
    }
}