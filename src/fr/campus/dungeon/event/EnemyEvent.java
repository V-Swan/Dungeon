package fr.campus.dungeon.event;

import fr.campus.dungeon.enemy.Enemy;

public class EnemyEvent extends Event {
    private Enemy enemy;

    public EnemyEvent(Enemy enemy) {
        this.enemy = enemy;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    @Override
    public String toString() {
        return "Vous rencontrez un " + enemy.getName() + " hostile";
    }
}
