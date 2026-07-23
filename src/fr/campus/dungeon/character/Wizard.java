package fr.campus.dungeon.character;

import fr.campus.dungeon.equipment.DefensiveEquipment;
import fr.campus.dungeon.equipment.OffensiveEquipment;

public class Wizard extends PlayerCharacter {

    public Wizard(String name,
                  int lifePoints,
                  int baseAttack,
                  OffensiveEquipment offensiveEquipment,
                  DefensiveEquipment defensiveEquipment) {

        super(
                name,
                lifePoints,
                baseAttack,
                offensiveEquipment,
                defensiveEquipment
        );

    }
}