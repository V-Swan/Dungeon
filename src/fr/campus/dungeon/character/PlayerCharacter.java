package fr.campus.dungeon.character;

import fr.campus.dungeon.equipment.OffensiveEquipment;
import fr.campus.dungeon.equipment.DefensiveEquipment;

public abstract class PlayerCharacter {

    private String name;
    private int lifePoints;
    private int strength;

    private OffensiveEquipment offensiveEquipment;
    private DefensiveEquipment defensiveEquipment;


    public PlayerCharacter(String name, int lifePoints, int strength,
                           OffensiveEquipment offensiveEquipment,
                           DefensiveEquipment defensiveEquipment) {

        this.name = name;
        this.lifePoints = lifePoints;
        this.strength = strength;
        this.offensiveEquipment = offensiveEquipment;
        this.defensiveEquipment = defensiveEquipment;
    }


    public String getName() {
        return name;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public int getStrength() {
        return strength;
    }

    public OffensiveEquipment getOffensiveEquipment() {
        return offensiveEquipment;
    }

    public DefensiveEquipment getDefensiveEquipment() {
        return defensiveEquipment;
    }


    @Override
    public String toString() {
        return "Personnage : " + name +
                ", Vie : " + lifePoints +
                ", Force : " + strength +
                ", Arme : " + offensiveEquipment +
                ", Défense : " + defensiveEquipment;
    }
}