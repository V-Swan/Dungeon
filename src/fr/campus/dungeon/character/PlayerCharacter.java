package fr.campus.dungeon.character;

import fr.campus.dungeon.equipment.OffensiveEquipment;
import fr.campus.dungeon.equipment.DefensiveEquipment;
import fr.campus.dungeon.character.Inventory;

public abstract class PlayerCharacter extends Character {

    private OffensiveEquipment offensiveEquipment;
    private DefensiveEquipment defensiveEquipment;
    private Inventory inventory;

    public PlayerCharacter(String name, int lifePoints, int baseAttack,
                           OffensiveEquipment offensiveEquipment,
                           DefensiveEquipment defensiveEquipment,
                           Inventory inventory) {

        super(name, lifePoints, baseAttack);

        this.offensiveEquipment = offensiveEquipment;
        this.defensiveEquipment = defensiveEquipment;
        this.inventory = inventory;
    }

    public OffensiveEquipment getOffensiveEquipment() {
        return offensiveEquipment;
    }

    public DefensiveEquipment getDefensiveEquipment() {
        return defensiveEquipment;
    }

    public Inventory getInventory(){
        return inventory;
    }

    @Override
    public int getAttack() {

        if (offensiveEquipment != null) {
            return getBaseAttack() + offensiveEquipment.getBonusAttack();
        }

        return getBaseAttack();
    }

    public void heal(int amount) {
        addLifePoints(amount);
    }

    public void equipWeapon(OffensiveEquipment weapon) {

        if (weapon == null) {
            return;
        }

        if (offensiveEquipment != null) {
            inventory.addItem(offensiveEquipment);
        }

        inventory.removeItem(weapon);

        offensiveEquipment = weapon;
    }

    public void equipDefensiveEquipment(DefensiveEquipment defensiveEquipment) {

        if (this.defensiveEquipment != null) {
            inventory.addItem(this.defensiveEquipment);
        }

        inventory.removeItem(defensiveEquipment);

        this.defensiveEquipment = defensiveEquipment;
    }

    @Override
    public String toString() {
        return "Personnage : " + getName() +
                ", Vie : " + getLifePoints() +
                ", Attaque de base : " + getBaseAttack() +
                ", Arme : " + offensiveEquipment +
                ", Défense : " + defensiveEquipment;
    }
    @Override
    public void takeDamage(int damage) {

        if (defensiveEquipment != null) {

            damage -= defensiveEquipment.getDamageReduction();

        }

        if (damage < 0) {
            damage = 0;
        }

        super.takeDamage(damage);
    }
}

