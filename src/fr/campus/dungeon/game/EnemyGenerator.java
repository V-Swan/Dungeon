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

                addGoblins(enemies, 21);
                addSorcerers(enemies, 2);
                addDragons(enemies, 0);

                break;

            case NORMAL:

                addGoblins(enemies, 17);
                addSorcerers(enemies, 6);
                addDragons(enemies, 0);

                break;

            case HARD:

                addGoblins(enemies, 11);
                addSorcerers(enemies, 12);
                addDragons(enemies, 0);

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