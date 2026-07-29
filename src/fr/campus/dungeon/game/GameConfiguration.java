package fr.campus.dungeon.game;

public class GameConfiguration {

    private Difficulty difficulty;

    public GameConfiguration(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public enum Difficulty {

        EASY,
        NORMAL,
        HARD

    }
}