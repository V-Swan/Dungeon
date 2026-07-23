package fr.campus.dungeon.game;
import fr.campus.dungeon.equipment.*;
import fr.campus.dungeon.menu.Menu;
import fr.campus.dungeon.character.PlayerCharacter;
import fr.campus.dungeon.character.Warrior;
import fr.campus.dungeon.character.Wizard;

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
            case "Warrior" -> new Warrior(playerName, 10, 5,
                    new Weapon("Épée", 5),
                    new Shield("Bouclier en fer", 2));
            case "Wizard" -> new Wizard(playerName, 6, 8,
                    new Spell("Boule de feu", 7),
                    new Robe ( "Robe en tissue", 1 ));
            default -> throw new IllegalArgumentException("Classe inconnue");
        };
    }
        }
