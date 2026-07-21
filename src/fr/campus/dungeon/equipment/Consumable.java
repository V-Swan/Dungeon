package fr.campus.dungeon.equipment;

public class Consumable extends Equipment{

    private int healingValue;

    public Consumable(String name, int healingValue){
        super(name);
        this.healingValue = healingValue;

    }

    public int getHealingValue() {
        return healingValue;
    }

    @Override
    public String toString() {
        return super.toString() +
                " + " + healingValue + " point de vie";
    }
}
