/*
//Utilisateur : dungeon_user
//Mot de passe : dungeon_password

package fr.campus.dungeon.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/dungeon" ;
    private static final String USER = "dungeon_user";
    private static final String PASSWORD = "dungeon_password";

    public static Connection getConnection() {
        DriverManager.getConnection(URL, USER, PASSWORD);
    }
}


 */