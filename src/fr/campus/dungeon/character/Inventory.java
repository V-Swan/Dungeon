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

    public Equipment getItem(int index) {
        return inventory.get(index);
    }

    public int getNumberOfItems() {
        return inventory.size();
    }

    public void displayInventory() {

        if (inventory.isEmpty()) {
            System.out.println("Inventaire vide.");
            return;
        }

        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(
                    (i + 1) + " - " + inventory.get(i)
            );
        }
    }
}

