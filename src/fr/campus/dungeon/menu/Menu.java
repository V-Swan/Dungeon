package fr.campus.dungeon.menu;
import java.util.Scanner;

public class Menu  {
    private Scanner scanner = new Scanner(System.in);

    public int mainMenu () {
        int userChoice = -1;
        while (userChoice != 1 && userChoice != 2){
            System.out.println("1 - New Game");
            System.out.println("2 - Quitter");
            userChoice = scanner.nextInt();

            if (userChoice != 1 && userChoice != 2){
                System.out.println("Choix invalide ! Veuillez entrer 1 ou 2.");
            }
        }

        return userChoice;

    }


}

