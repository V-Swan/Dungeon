package fr.campus.dungeon.menu;
import fr.campus.dungeon.character.Inventory;
import fr.campus.dungeon.equipment.Equipment;
import fr.campus.dungeon.game.GameConfiguration.Difficulty;

import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);

    public String mainMenu() {
        String userChoice = "-1";
        while (!userChoice.equals("1") &&
                !userChoice.equals("2")) {
            System.out.println("1 - New Game");
            System.out.println("2 - Quitter");
            userChoice = scanner.nextLine();

            if (!userChoice.equals("1") && !userChoice.equals("2")) {
                System.out.println("Choix invalide ! Veuillez entrer 1 ou 2.");
            }
        }
        return userChoice;

    }

    public String characterClassMenu() {
        String userClass = " ";

        while (!userClass.equalsIgnoreCase("Warrior") &&
                !userClass.equalsIgnoreCase("Wizard")) {
            System.out.println("Choisissez votre classe :");
            System.out.println("Warrior");
            System.out.println("Wizard");
            userClass = scanner.nextLine().trim();

            if (!userClass.isEmpty()) {
                userClass = userClass.substring(0, 1).toUpperCase() +
                        userClass.substring(1).toLowerCase();
            }

            if (!userClass.equalsIgnoreCase("Warrior") && !userClass.equalsIgnoreCase("Wizard")) {
                System.out.println("Choix invalide ! Veuillez entrer Warrior ou Wizard.");
            }
        }
        return userClass;

    }
    public String getPlayerName() {
        System.out.print("Entrez le nom de votre personnage : ");
        String name = scanner.nextLine().trim();
        while (name.isEmpty()) {
            System.out.println("Le nom ne peut pas être vide !");
            System.out.print("Entrez le nom de votre personnage : ");
            name = scanner.nextLine().trim();
        }
        return name;
    }
    public void waitPlayer() {
        System.out.println("Appuyez sur Entrée pour lancer le dé...");
        scanner.nextLine();
    }
    public String combatMenu() {
        String choice = "";

        while (!choice.equals("1") && !choice.equals("2")) {

            System.out.println("=== Combat ===");
            System.out.println("1 - Attaquer");
            System.out.println("2 - Utiliser un objet");

            choice = scanner.nextLine();

            if (!choice.equals("1") && !choice.equals("2")) {
                System.out.println("Choix invalide !");
            }
        }
        return choice;
    }
    public void displayInventory(Inventory inventory){
        System.out.println("=== Inventaire ===");
        for (int i = 0; i < inventory.getNumberOfItems(); i++) {
            Equipment item = inventory.getItem(i);
            System.out.println(i + " - " + item);

        }
    }

    public Equipment chooseItem(Inventory inventory) {

        if (inventory.getNumberOfItems() == 0) {
            System.out.println("Votre inventaire est vide !");
            return null;
        }

        int choice = -1;

        while (choice < 0 || choice >= inventory.getNumberOfItems()) {

            displayInventory(inventory);

            System.out.println("Choisissez un objet :");
            /*
             Scanner lit toujours une entrée utilisateur comme une String.
             Integer.parseInt() permet de convertir cette String en int
             afin de pouvoir utiliser la valeur comme un index dans l'ArrayList.
             */
            String input = scanner.nextLine();
            choice = Integer.parseInt(input);

            if (choice < 0 || choice >= inventory.getNumberOfItems()) {
                System.out.println("Choix invalide !");
            }
        }

        return inventory.getItem(choice);
    }
    public Difficulty difficultyMenu() {

        String choice = "";

        while (!choice.equals("1")
                && !choice.equals("2")
                && !choice.equals("3")) {

            System.out.println("=== Difficulté ===");
            System.out.println("1 - Facile");
            System.out.println("2 - Normal");
            System.out.println("3 - Difficile");

            choice = scanner.nextLine();

            if (!choice.equals("1")
                    && !choice.equals("2")
                    && !choice.equals("3")) {

                System.out.println("Choix invalide !");
            }
        }

        switch (choice) {

            case "1":
                return Difficulty.EASY;

            case "2":
                return Difficulty.NORMAL;

            case "3":
                return Difficulty.HARD;

            default:
                throw new IllegalArgumentException("Difficulté inconnue");
        }
    }
}