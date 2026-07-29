package fr.campus.dungeon.character;

import fr.campus.dungeon.equipment.Equipment;
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

        offensiveEquipment = weapon;
    }

    public void equipDefensiveEquipment(DefensiveEquipment defensiveEquipment) {

        if (defensiveEquipment == null) {
            return;
        }

        if (this.defensiveEquipment != null) {
            inventory.addItem(this.defensiveEquipment);
        }

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
    public void receiveEquipment(Equipment equipment) {

        if (equipment instanceof OffensiveEquipment weapon) {

            if (getOffensiveEquipment() == null ||
                    weapon.getBonusAttack() > getOffensiveEquipment().getBonusAttack()) {

                equipWeapon(weapon);
                System.out.println("Nouvelle arme équipée !");
            }
            else {
                inventory.addItem(equipment);
            }

        } else if (equipment instanceof DefensiveEquipment defense) {

            if (getDefensiveEquipment() == null ||
                    defense.getDamageReduction() > getDefensiveEquipment().getDamageReduction()) {

                equipDefensiveEquipment(defense);
                System.out.println("Nouvel équipement défensif équipé !");
            }
            else {
                inventory.addItem(equipment);
            }

        } else {
            inventory.addItem(equipment);
        }
    }
}

