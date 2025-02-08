package taquin.utils;

/**
 * Représente une paire de deux objets.
 *
 * @param <X> Le type du premier objet.
 * @param <Y> Le type du deuxième objet.
 * @author Florian Pépin
 * @version 1.0
 */
public class Pair<X, Y> {

    public final X x;
    public final Y y;

    public Pair(X x, Y y) {
        this.x = x;
        this.y = y;
    }

}
