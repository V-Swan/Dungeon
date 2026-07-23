package fr.campus.dungeon.menu;
import java.util.Scanner;

public class Menu  {
    private Scanner scanner = new Scanner(System.in);

    public String mainMenu() {
        String userChoice = "-1";
        while (!userChoice.equals("1") &&
                !userChoice.equals("2"))
        {
            System.out.println("1 - New Game");
            System.out.println("2 - Quitter");
            userChoice = scanner.nextLine();

            if (!userChoice.equals("1") && !userChoice.equals("2")){
                System.out.println("Choix invalide ! Veuillez entrer 1 ou 2.");
            }
        }
        return userChoice;

    }


}

