package fr.campus.dungeon.character;

public class Wizard extends PlayerCharacter {

    public Wizard(String name) {

        super(
                name,
                6,
                8,
                null,
                null,
                new Inventory()
        );

    }
}