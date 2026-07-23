package fr.campus.dungeon.game;

import fr.campus.dungeon.character.PlayerCharacter;
import fr.campus.dungeon.character.Warrior;
import fr.campus.dungeon.character.Wizard;
import fr.campus.dungeon.menu.Menu;

public class Game {
    private final Menu MENU = new Menu();
    private PlayerCharacter character;

    public void start() {
        String choice = MENU.mainMenu();
        if (choice.equals("1")) {
            startGame();

        } else if (choice.equals("2")) {
            // Quitter
            System.out.println("Au revoir !");
        }
    }

    private void startGame() {
        System.out.println("=== Création du personnage ===");
        character = createCharacter();
        System.out.println("\n" + character);
    }

    private PlayerCharacter createCharacter() {
        String characterClass = MENU.characterClassMenu();
        String playerName = MENU.getPlayerName();

        return switch (characterClass) {
            case "Warrior" -> new Warrior(playerName);
            case "Wizard" -> new Wizard(playerName);
            default -> throw new IllegalArgumentException("Classe inconnue");
        };
    }
}
