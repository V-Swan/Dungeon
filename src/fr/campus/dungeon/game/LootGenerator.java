package fr.campus.dungeon.game;

import fr.campus.dungeon.equipment.Consumable;
import fr.campus.dungeon.equipment.Equipment;
import fr.campus.dungeon.equipment.Robe;
import fr.campus.dungeon.equipment.Shield;
import fr.campus.dungeon.equipment.Spell;
import fr.campus.dungeon.equipment.Weapon;
import java.util.Random;

public class LootGenerator {

    private final Random random = new Random();


    private Equipment generateWeapon() {

        int choice = random.nextInt(4);

        switch (choice) {

            case 0:
                return new Weapon("Massue en bois", 3);

            case 1:
                return new Weapon("Épée en fer", 5);

            case 2:
                return new Weapon("Épée du Seigneur", 7);

            case 3:
                return new Weapon("Épée Légendaire", 10);
        }

        return new Weapon("Massue en bois", 3);
    }


    private Equipment generateShield() {

        int choice = random.nextInt(4);

        switch (choice) {

            case 0:
                return new Shield("Bouclier en bois", 1);

            case 1:
                return new Shield("Bouclier renforcé", 2);

            case 2:
                return new Shield("Bouclier du chevalier", 3);

            case 3:
                return new Shield("Bouclier légendaire", 4);
        }

        return new Shield("Bouclier en bois", 1);
    }


    private Equipment generateRobe() {

        int choice = random.nextInt(4);

        switch (choice) {

            case 0:
                return new Robe("Robe usée", 1);

            case 1:
                return new Robe("Robe enchantée", 2);

            case 2:
                return new Robe("Robe du mage", 3);

            case 3:
                return new Robe("Robe légendaire", 4);
        }

        return new Robe("Robe usée", 1);
    }


    private Equipment generateSpell() {

        int choice = random.nextInt(3);

        switch (choice) {

            case 0:
                return new Spell("Éclair mineur", 4);

            case 1:
                return new Spell("Éclair foudroyant", 7);

            case 2:
                return new Spell("Boule de feu", 10);
        }

        return new Spell("Éclair mineur", 4);
    }


    private Equipment generateConsumable() {

        int choice = random.nextInt(2);

        switch (choice) {

            case 0:
                return new Consumable("Potion de soin", 5);

            case 1:
                return new Consumable("Élixir de vie", 999);
        }

        return new Consumable("Potion de soin", 5);
    }


    public Equipment generateLoot() {

        int choice = random.nextInt(5);

        switch(choice) {

            case 0:
                return generateWeapon();

            case 1:
                return generateShield();

            case 2:
                return generateRobe();

            case 3:
                return generateSpell();

            case 4:
                return generateConsumable();
        }

        return new Consumable("Potion de soin", 5);
    }
}