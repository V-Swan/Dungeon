package fr.campus.dungeon.character;

import fr.campus.dungeon.equipment.OffensiveEquipment;
import fr.campus.dungeon.equipment.DefensiveEquipment;

public abstract class PlayerCharacter extends Character {

    private OffensiveEquipment offensiveEquipment;
    private DefensiveEquipment defensiveEquipment;

    public PlayerCharacter(String name, int lifePoints, int baseAttack,
                           OffensiveEquipment offensiveEquipment,
                           DefensiveEquipment defensiveEquipment) {

        super(name, lifePoints, baseAttack);

        this.offensiveEquipment = offensiveEquipment;
        this.defensiveEquipment = defensiveEquipment;
    }

    public OffensiveEquipment getOffensiveEquipment() {
        return offensiveEquipment;
    }

    public DefensiveEquipment getDefensiveEquipment() {
        return defensiveEquipment;
    }

    @Override
    public int getAttack() {

        if (offensiveEquipment != null) {
            return getBaseAttack() + offensiveEquipment.getBonusAttack();
        }

        return getBaseAttack();
    }

    @Override
    public String toString() {
        return "Personnage : " + getName() +
                ", Vie : " + getLifePoints() +
                ", Attaque de base : " + getBaseAttack() +
                ", Arme : " + offensiveEquipment +
                ", Défense : " + defensiveEquipment;
    }
}