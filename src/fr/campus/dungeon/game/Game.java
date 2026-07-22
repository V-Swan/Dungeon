package fr.campus.dungeon.game;
import fr.campus.dungeon.menu.Menu;

public class Game {
    private Menu startingMenu;

    public Game() {
        startingMenu = new Menu();
    }

    public void start() {
        int choice = startingMenu.mainMenu();
        if (choice == 1) {
            // Démarrer le jeu
            System.out.println("Lancer le jeu...");
        } else if (choice == 2) {
            // Quitter
            System.out.println("Au revoir !");
        }
    }
}
