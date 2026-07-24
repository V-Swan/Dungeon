package fr.campus.dungeon.game;

import fr.campus.dungeon.character.PlayerCharacter;
import fr.campus.dungeon.character.Warrior;
import fr.campus.dungeon.character.Wizard;
import fr.campus.dungeon.enemy.Dragon;
import fr.campus.dungeon.enemy.Enemy;
import fr.campus.dungeon.enemy.Gobelin;
import fr.campus.dungeon.enemy.Sorcier;
import fr.campus.dungeon.event.EnemyEvent;
import fr.campus.dungeon.menu.Menu;


public class Game {
    private int playerPosition = 1;
    private final Menu MENU = new Menu();
    private PlayerCharacter character;
    private Board board;
    private final Dice dice = new Dice();

    public void start() {
        String choice = MENU.mainMenu();
        if (choice.equals("1")) {
            startGame();

        } else if (choice.equals("2")) {
            // Quitter
            System.out.println("Au revoir !");
        }
    }
        // ======================= GAME START ===========================
    private void startGame() {
        System.out.println("=== Création du personnage ===");
        character = createCharacter();

        board = new Board(64);
        initializeBoard();
        //board.displayBoard();

        System.out.println("\n" + character);

        gameLoop();

        endGame();
    }
        //creation perso
    private PlayerCharacter createCharacter() {
        String characterClass = MENU.characterClassMenu();
        String playerName = MENU.getPlayerName();

        return switch (characterClass) {
            case "Warrior" -> new Warrior(playerName);
            case "Wizard" -> new Wizard(playerName);
            default -> throw new IllegalArgumentException("Classe inconnue");
        };
    }
        //board (test méthode random plus tard)
        private void initializeBoard() {
            board.placeEvent(4, new EnemyEvent(new Gobelin()));
            board.placeEvent(19, new EnemyEvent(new Sorcier()));
            board.placeEvent(49, new EnemyEvent(new Dragon()));
        }

    private void movePlayer() {

        int diceResult = dice.rollD6();

        System.out.println("Vous lancez le dé...");
        System.out.println("Le dé affiche : " + diceResult);

        playerPosition += diceResult;

        if (playerPosition > board.getCells().size()) {
            playerPosition = board.getCells().size();
        }

        System.out.println(
                "Votre personnage avance de " + diceResult + " cases."
        );

        System.out.println(
                "Vous êtes maintenant sur la case : " + playerPosition
        );
    }
    private void checkCell() {

        Cell cell = board.getCell(playerPosition - 1);

        if (cell.getEvent() instanceof EnemyEvent enemyEvent) {

            Enemy enemy = enemyEvent.getEnemy();

            System.out.println("Vous rencontrez un " + enemy.getName() + " !");

            Battle battle = new Battle(character, enemy);
            battle.startCombat();

            if (enemy.isDead()) {
                cell.clearEvent();
            }
        }
        else {
            System.out.println("Cette case est vide.");
        }
    }

    private boolean hasWon() {
        return playerPosition >= board.getCells().size();
    }
    private boolean hasLost() {
        return character.isDead();
    }

    private void playTurn() {
        MENU.waitPlayer();
        movePlayer();

        if (!hasWon()) {
            checkCell();
        }
    }
            //ajouter les autres logiques combat etc
            private void gameLoop() {
                while (!hasWon() && !hasLost()) {
                    playTurn();
                }
            }
    private void endGame() {

        if (hasWon()) {
            System.out.println("Félicitations ! Vous avez terminé le donjon !");
        }
        else if (hasLost()) {
            System.out.println("Vous êtes mort dans le donjon...");
        }

        System.out.println(character);
    }
}
