package fr.campus.dungeon.event;

import fr.campus.dungeon.equipment.Equipment;

public class LootBoxEvent extends Event {

    private Equipment equipment;

    public LootBoxEvent(Equipment equipment) {
        this.equipment = equipment;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    @Override
    public String toString() {
        return "Vous trouvez un coffre contenant : " + equipment;
    }
}