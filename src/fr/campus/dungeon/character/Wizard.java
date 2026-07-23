package fr.campus.dungeon.character;

import fr.campus.dungeon.equipment.DefensiveEquipment;
import fr.campus.dungeon.equipment.OffensiveEquipment;

public class Wizard extends PlayerCharacter {

    public Wizard(String name,
                  int lifePoints,
                  int strength,
                  OffensiveEquipment offensiveEquipment,
                  DefensiveEquipment defensiveEquipment) {

        super(
                name,
                lifePoints,
                strength,
                offensiveEquipment,
                defensiveEquipment
        );

    }
}