package fr.campus.dungeon.game;

import fr.campus.dungeon.event.Event;

import java.util.ArrayList;

public class Board {
    private ArrayList<Cell> cells = new ArrayList<>();

    public Board(int size) {
        createCells(size);
    }

    private void createCells(int size) {
        for (int i = 0; i < size; i++) {
            cells.add(new Cell());
        }
    }

    public Cell getCell(int index) { // plus secure pour apres
        return cells.get(index);
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public void placeEvent(int index, Event event) {

        if (index < cells.size() && index >= 0) {
            cells.get(index).setEvent(event); // recup cell et set event

        } else {
            System.out.println("Impossible de placer l'événement : case inexistante");
        }
    }

    //test

    public void displayBoard() {

        for (int i = 0; i < cells.size(); i++) {

            if (cells.get(i).getEvent() != null) {
                System.out.println(
                        "Case " + i + " : " + cells.get(i).getEvent()
                );
            }
        }
    }


}
