package taquin;

import taquin.model.*;
import taquin.view.*;

/**
 * Représente le démarrage de l'application.
 *
 *
 * @author Florian Pépin
 * @version 1.0
 */
public class Main {

    /**
     * Méthode principale de l'application.
     *
     * @param args Les arguments passés en ligne de commande.
     */
    public static void main(String[] args) {
        Taquin taquin = new Taquin(4);
        taquin.shuffle(100);
        GUI gui = new GUI(taquin, "kids/");
    }

}