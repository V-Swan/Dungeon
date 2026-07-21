package fr.campus.dungeon.equipment;



public class OffensiveEquipment extends Equipment {
    private int bonusAttack;

    public OffensiveEquipment(String name, int bonusAttack){
        super(name);
        this.bonusAttack = bonusAttack;

    }

    public int getBonusAttack() {
        return bonusAttack;
    }

    @Override
    public String toString() {
        return super.toString() +
                " +" + bonusAttack + " attaque";
    }
}
