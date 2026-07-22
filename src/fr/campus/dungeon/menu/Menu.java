package fr.campus.dungeon.menu;
import java.util.Scanner;

public class Menu  {
    private Scanner scanner = new Scanner(System.in);

    public int mainMenu () {
        System.out.println("1 - New Game");
        System.out.println("2 - Quitter");
        int userChoice = scanner.nextInt();
        return userChoice;

    }


}

