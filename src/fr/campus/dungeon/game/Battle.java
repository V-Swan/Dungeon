package fr.campus.dungeon.game;

import fr.campus.dungeon.menu.Menu;
import fr.campus.dungeon.character.Character;

public class Battle {

    private Character player;
    private Character enemy;
    private final Menu MENU = new Menu();

    public Battle(Character player, Character enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void startCombat() {

        System.out.println("Le combat commence !");

        while (!player.isDead() && !enemy.isDead()) {

            displayFightStatus();

            playerTurn();

            if (enemy.isDead()) {
                System.out.println(enemy.getName() + " est vaincu !");
                break;
            }

            enemyTurn();
        }
    }

    private void playerTurn() {

        String choice = MENU.combatMenu();

        switch (choice) {

            case "1":
                System.out.println(player.getName() + " attaque !");
                player.attack(enemy);
                break;

            case "2":
                System.out.println("Aucun objet disponible.");
                break;
        }

        System.out.println(
                enemy.getName() + " : " + enemy.getLifePoints() + " PV"
        );
    }

    private void enemyTurn() {

        System.out.println(enemy.getName() + " attaque !");

        enemy.attack(player);

        System.out.println(
                player.getName() + " : " + player.getLifePoints() + " PV"
        );

        if (player.isDead()) {
            System.out.println(player.getName() + " est mort !");
        }
    }
    private void displayFightStatus() {

        System.out.println("====================");
        System.out.println(player.getName()
                + " : "
                + player.getLifePoints()
                + " PV");

        System.out.println(enemy.getName()
                + " : "
                + enemy.getLifePoints()
                + " PV");

        System.out.println("====================");
    }
}