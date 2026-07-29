package fr.campus.dungeon.character;

import fr.campus.dungeon.equipment.DefensiveEquipment;
import fr.campus.dungeon.equipment.OffensiveEquipment;
import fr.campus.dungeon.equipment.Robe;
import fr.campus.dungeon.equipment.Spell;

public class Wizard extends PlayerCharacter {

    public Wizard(String name) {

        super(
                name,
                6,
                8,
                new Spell("Parchemin dépourvu de magie", 0),
                new Robe("Robe lacérée", 0),
                new Inventory()
        );

    }
    @Override
    public void equipDefensiveEquipment(DefensiveEquipment equipment) {

        if (equipment == null) {
            return;
        }

        if (equipment instanceof Robe) {
            super.equipDefensiveEquipment(equipment);
        } else {
            System.out.println("Un mage ne peut pas équiper cet objet.");
        }
    }
    @Override
    public void equipWeapon(OffensiveEquipment weapon) {

        if (weapon == null) {
            return;
        }

        if (weapon instanceof Spell) {
            super.equipWeapon(weapon);
        } else {
            System.out.println("Un mage ne peut pas équiper cette arme.");
        }
    }
}