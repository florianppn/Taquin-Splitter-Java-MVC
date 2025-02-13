package taquin;

import taquin.model.*;
import taquin.view.*;

import java.io.*;
import java.util.*;

/**
 * Représente le démarrage de l'application.
 *
 *
 * @author Florian Pépin
 * @version 1.0
 */
public class Main {

    private static int SIZE, TIME, SHUFFLE;
    private static String THEME;

    static {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("config.properties"));
            SIZE = Integer.parseInt(prop.getProperty("SIZE"));
            TIME = Integer.parseInt(prop.getProperty("TIME"));
            SHUFFLE = Integer.parseInt(prop.getProperty("SHUFFLE"));
            THEME = prop.getProperty("THEME");
        } catch (IOException ex) {
            SIZE = 4;
            TIME = 360;
            SHUFFLE = 100;
            THEME = "4x4/forest/";
        }
    }

    /**
     * Méthode principale de l'application.
     *
     * @param args Les arguments passés en ligne de commande.
     */
    public static void main(String[] args) {
        Taquin taquin = new Taquin(SIZE, TIME);
        taquin.shuffle(SHUFFLE);
        GUI gui = new GUI(taquin, THEME);
    }

}