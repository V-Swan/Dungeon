package fr.campus.dungeon.character;

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
}