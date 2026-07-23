package fr.campus.dungeon.character;

import fr.campus.dungeon.equipment.DefensiveEquipment;
import fr.campus.dungeon.equipment.OffensiveEquipment;

public class Warrior extends PlayerCharacter {

    public Warrior(String name)  {

        super(
                name,
                10,
                5,
                null,
                null
        );
    }
}