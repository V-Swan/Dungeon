package fr.campus.dungeon.game;

import fr.campus.dungeon.enemy.Dragon;
import fr.campus.dungeon.enemy.Enemy;
import fr.campus.dungeon.enemy.Gobelin;
import fr.campus.dungeon.enemy.Sorcier;

import java.util.ArrayList;

public class EnemyGenerator {

    public ArrayList<Enemy> generateEnemies(GameConfiguration configuration) {

        ArrayList<Enemy> enemies = new ArrayList<>();

        switch (configuration.getDifficulty()) {

            case EASY:

                addGoblins(enemies, 4);
                addSorcerers(enemies, 2);
                addDragons(enemies, 1);

                break;

            case NORMAL:

                addGoblins(enemies, 2);
                addSorcerers(enemies, 4);
                addDragons(enemies, 1);

                break;

            case HARD:

                addGoblins(enemies, 1);
                addSorcerers(enemies, 2);
                addDragons(enemies, 2);

                break;
        }

        return enemies;
    }


    private void addGoblins(ArrayList<Enemy> enemies, int number) {

        for (int i = 0; i < number; i++) {
            enemies.add(new Gobelin());
        }
    }


    private void addSorcerers(ArrayList<Enemy> enemies, int number) {

        for (int i = 0; i < number; i++) {
            enemies.add(new Sorcier());
        }
    }


    private void addDragons(ArrayList<Enemy> enemies, int number) {

        for (int i = 0; i < number; i++) {
            enemies.add(new Dragon());
        }
    }
}