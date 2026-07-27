package fr.campus.dungeon.character;

import fr.campus.dungeon.equipment.Equipment;
import fr.campus.dungeon.event.Event;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Equipment> inventory = new ArrayList<>();

    public void addItem(Equipment equipment){
        inventory.add(equipment);

    }

    public void removeItem(Equipment equipment){
        inventory.remove(equipment);

    }

    public ArrayList<Equipment> getInventory() {
        return inventory;
    }
}
