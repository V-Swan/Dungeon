package fr.campus.dungeon.character;


import fr.campus.dungeon.equipment.Shield;
import fr.campus.dungeon.equipment.Weapon;

public class Warrior extends PlayerCharacter {

    public Warrior(String name)  {

        super(
                name,
                10,
                5,
                new Weapon("Épée Inefficace", 0),
                new Shield("Bouclier en mousse", 0),
                new Inventory()
        );
    }
}