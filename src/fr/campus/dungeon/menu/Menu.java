package fr.campus.dungeon.menu;
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
}