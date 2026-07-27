package fr.campus.dungeon.character;


import fr.campus.dungeon.equipment.Weapon;

public class Warrior extends PlayerCharacter {

    public Warrior(String name)  {

        super(
                name,
                10,
                5,
                new Weapon("Épée Inefficace", 0),
                null,
                new Inventory()
        );
    }
}