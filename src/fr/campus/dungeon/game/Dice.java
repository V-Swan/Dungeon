package fr.campus.dungeon.game;

import java.util.Random;

public class Dice {

    private Random random = new Random();

    public int rollD6() {
        return random.nextInt(6) + 1;
    }
}