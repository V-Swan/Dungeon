package fr.campus.dungeon.game;

import fr.campus.dungeon.character.Character;
import fr.campus.dungeon.character.PlayerCharacter;
import fr.campus.dungeon.equipment.Consumable;
import fr.campus.dungeon.equipment.DefensiveEquipment;
import fr.campus.dungeon.equipment.Equipment;
import fr.campus.dungeon.equipment.OffensiveEquipment;
import fr.campus.dungeon.menu.Menu;

public class Battle {

    private final PlayerCharacter player;
    private final Character enemy;
    private final Menu MENU = new Menu();

    public Battle(PlayerCharacter player, Character enemy) {
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
                attackEnemy();
                break;

            case "2":
                useItem();
                break;
        }

    }

    private void enemyTurn() {

        int damage = enemy.attack(player);

        System.out.println(enemy.getName() + " attaque " + player.getName() + " !");

        System.out.println(player.getName() + " subit " + damage + " points de dégâts.");

        System.out.println(player.getName() + " : " + player.getLifePoints() + " PV");

        if (player.isDead()) {
            System.out.println(player.getName() + " est mort !");
        }
    }

    private void displayFightStatus() {

        System.out.println("====================");
        System.out.println(player.getName() + " : " + player.getLifePoints() + " PV");

        System.out.println(enemy.getName() + " : " + enemy.getLifePoints() + " PV");

        System.out.println("====================");
    }

    private void attackEnemy() {

        int damage = player.attack(enemy);

        System.out.println(player.getName() + " attaque " + enemy.getName() + " avec une puissance de " + player.getAttack() + " !");

        System.out.println(enemy.getName() + " subit " + damage + " points de dégâts.");

        System.out.println(enemy.getName() + " : " + enemy.getLifePoints() + " PV");
    }

    private void useItem() {

        Equipment usedItem = MENU.chooseItem(player.getInventory());

        if (usedItem == null) {
            return;
        }

        if (usedItem instanceof Consumable) {

            Consumable potion = (Consumable) usedItem;

            int oldLifePoints = player.getLifePoints();

            player.heal(potion.getHealingValue());

            int healed = player.getLifePoints() - oldLifePoints;

            player.getInventory().removeItem(potion);

            System.out.println(player.getName() + " utilise " + potion + " !");

            System.out.println(player.getName() + " récupère " + healed + " PV.");

            System.out.println(player.getName() + " : "
                    + player.getLifePoints()
                    + "/"
                    + player.getMaxLifePoints()
                    + " PV");
        }
        else if (usedItem instanceof OffensiveEquipment) {

            OffensiveEquipment weapon = (OffensiveEquipment) usedItem;

            player.equipWeapon(weapon);

            System.out.println(player.getName() + " équipe " + weapon + " !");
        }
        else if (usedItem instanceof DefensiveEquipment) {

            DefensiveEquipment equipment = (DefensiveEquipment) usedItem;

            player.equipDefensiveEquipment(equipment);

            System.out.println(player.getName() + " équipe " + equipment + " !");

        }
        else {
            System.out.println("Cet objet ne peut pas être utilisé.");
        }
    }
}
