package fr.campus.dungeon;
import fr.campus.dungeon.game.Game;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.start();


        /* OffensiveEquipment steelSword = new OffensiveEquipment("Steel sword", 7);
        DefensiveEquipment shield = new DefensiveEquipment("Steel Shield", 3);
        Consumable highPotion = new Consumable("High potion", 8);
        System.out.println(steelSword);
        System.out.println(shield);
        System.out.println(highPotion); */
    }
}