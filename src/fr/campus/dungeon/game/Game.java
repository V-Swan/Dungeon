package fr.campus.dungeon.game;
import fr.campus.dungeon.menu.Menu;

public class Game {
    private final Menu MENU = new Menu();

    public void start() {
        String choice = MENU.mainMenu();
        if (choice.equals("1")) {
            // Démarrer le jeu
            System.out.println("Lancer le jeu...");
        } else if (choice.equals("2")) {
            // Quitter
            System.out.println("Au revoir !");
        }
    }
}
