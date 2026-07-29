package fr.campus.dungeon.game;

import fr.campus.dungeon.character.PlayerCharacter;
import fr.campus.dungeon.character.Warrior;
import fr.campus.dungeon.character.Wizard;
import fr.campus.dungeon.enemy.Dragon;
import fr.campus.dungeon.enemy.Enemy;
import fr.campus.dungeon.equipment.Equipment;
import fr.campus.dungeon.event.EnemyEvent;
import fr.campus.dungeon.event.LootBoxEvent;
import fr.campus.dungeon.menu.Menu;
import java.util.Random;
import java.util.ArrayList;


public class Game {
    private int playerPosition = 1;
    private final Menu MENU = new Menu();
    private PlayerCharacter character;
    private Board board;
    private final Dice dice = new Dice();
    private GameConfiguration configuration;
    private final EnemyGenerator enemyGenerator = new EnemyGenerator();
    private final Random random = new Random();
    private final LootGenerator lootGenerator = new LootGenerator();
    private boolean running = true;

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

        GameConfiguration.Difficulty difficulty = MENU.difficultyMenu();

        configuration = new GameConfiguration(difficulty);

        board = new Board(64);

        initializeBoard();

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
    private void initializeBoard() {

        ArrayList<Enemy> enemies = enemyGenerator.generateEnemies(configuration);

        for (Enemy enemy : enemies) {

            int position = getRandomEmptyPosition();

            board.placeEvent(position, new EnemyEvent(enemy));
        }

        placeLootBoxes();

        placeBoss();
    }

    private void placeLootBoxes() {

        for (int i = 0; i < 24; i++) {

            int position = getRandomEmptyPosition();

            board.placeEvent(
                    position,
                    new LootBoxEvent(lootGenerator.generateLoot(character))
            );
        }
    }
    private void placeBoss() {

        int lastPosition = board.getCells().size();

        board.placeEvent(
                lastPosition - 1,
                new EnemyEvent(new Dragon())
        );
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

        } else if (cell.getEvent() instanceof LootBoxEvent lootBoxEvent) {

            Equipment equipment = lootBoxEvent.getEquipment();

            System.out.println("Vous trouvez un coffre !");
            System.out.println("Vous obtenez : " + equipment);

            character.receiveEquipment(equipment);

            cell.clearEvent();

        } else {
            System.out.println("Cette case est vide.");
        }
    }

    private boolean hasWon() {
        Cell lastCell = board.getCell(board.getCells().size() - 1);

        return playerPosition >= board.getCells().size()
                && lastCell.getEvent() == null;
    }
    private boolean hasLost() {
        return character.isDead();
    }

    private void playTurn() {

        String choice = MENU.actionMenu();

        switch (choice) {

            case "1":
                movePlayer();

                if (!hasWon()) {
                    checkCell();
                }
                break;

            case "2":
                useInventory();
                break;

            case "3":
                System.out.println("Vous quittez le donjon.");
                running = false;
                break;

            default:
                System.out.println("Choix invalide.");
        }

        if (hasLost()) {
            System.out.println("Votre aventure se termine ici...");
        }
    }
    private void useInventory() {

        if (character.getInventory().getNumberOfItems() == 0) {
            System.out.println("Votre inventaire est vide.");
            return;
        }

        int choice = MENU.inventoryMenu(character.getInventory());

        character.useItem(choice);
    }

        //ajouter les autres logiques combat etc
        private void gameLoop() {

            while (running && !hasWon() && !hasLost()) {
                playTurn();
            }
        }
    private void endGame() {

        if (hasWon()) {
            System.out.println("Félicitations ! Vous avez terminé le donjon !");
        }
        else if (hasLost()) {
            System.out.println("Le donjon aura eu raison de vous...");
        }

        System.out.println(character);
    }
    private int getRandomEmptyPosition() {

        int position;

        do {
            position = random.nextInt(board.getCells().size() - 1);

        } while (board.getCell(position).getEvent() != null);

        return position;
    }
}
