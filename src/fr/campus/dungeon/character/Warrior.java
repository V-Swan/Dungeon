package fr.campus.dungeon.character;

import fr.campus.dungeon.equipment.DefensiveEquipment;
import fr.campus.dungeon.equipment.OffensiveEquipment;

public class Warrior extends PlayerCharacter {

    public Warrior(String name,
                   int lifePoints,
                   int baseAttack,
                   OffensiveEquipment offensiveEquipment,
                   DefensiveEquipment defensiveEquipment)  {

        super(
                name,
                lifePoints,
                baseAttack,
                offensiveEquipment,
                defensiveEquipment
        );
    }
}