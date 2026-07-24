package fr.campus.dungeon.game;
import fr.campus.dungeon.event.Event;

public class Cell {
    private Event event; // = null si pas initialiser

    public Cell() {

    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void clearEvent() {
        event = null;
    }
}
