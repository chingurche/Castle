package castle.gameObjects;

import castle.*;

public class BigMonster extends GameObject implements Interactable {
    public static MonsterTask[] easyTasks = new MonsterTask[] {
            new MonsterTask("какого числа начнется MGB?", "7"),
            new MonsterTask("сколько человек могут быть в команде?", "4"),
            new MonsterTask("какой язык программирования будет изучаться в MGB?", "java"),
    };
    public static MonsterTask[] mediumTasks = new MonsterTask[] {
            new MonsterTask("никнейм разработчика", "chingurche"),
            new MonsterTask("2 + 2?", "4"),
            new MonsterTask("2 + 2?", "4"),
    };
    public static MonsterTask[] hardTasks = new MonsterTask[] {
            new MonsterTask("название первой игры разработчика", "cave adventure"),
            new MonsterTask("квантовое?", "вмешательство"),
            new MonsterTask("2 + 2?", "4"),
    };

    public void interact(Hero hero) {
        if (!askTask()) {
            hero.takeDamage();
        }

        Hierarchy.getInstance().removeObject(this);
    }

    private boolean askTask() {
        MonsterTask task = new MonsterTask();
        GameDifficulty difficulty = GameCycle.getDifficulty();
        switch (difficulty) {
            case GameDifficulty.easy:
                task = easyTasks[(int) (Math.random() * easyTasks.length)];
            case GameDifficulty.medium:
                task = mediumTasks[(int) (Math.random() * easyTasks.length)];
            case GameDifficulty.hard:
                task = hardTasks[(int) (Math.random() * easyTasks.length)];
        }

        return task.Ask();
    }
}