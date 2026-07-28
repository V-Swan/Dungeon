package fr.campus.dungeon.menu;
import fr.campus.dungeon.character.Inventory;
import fr.campus.dungeon.equipment.Equipment;

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
            System.out.println("3 - Fuir !");

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
        int choice = scanner.nextInt();
        Equipment item = inventory.getItem(choice);
        return item;

    }


}