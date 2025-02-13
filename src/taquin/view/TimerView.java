package taquin.view;

import taquin.model.*;
import taquin.utils.*;

import javax.swing.*;
import java.awt.*;

/**
 * Représente le temps de jeu.
 *
 * @author Florian Pépin
 * @version 1.0
 */
public class TimerView extends JPanel implements ModelListener {

    private Taquin taquin;
    private JLabel label;

    public TimerView(Taquin taquin) {
        super();
        this.taquin = taquin;
        this.taquin.addModelListener(this);
        this.label = new JLabel(this.getTextTime());
        this.label.setFont(new Font("Arial", Font.BOLD, 24));
        this.setBackground(Color.WHITE);
        if (this.taquin.getTime() <= 15) {
            this.label.setForeground(Color.RED);
        } else {
            this.setBackground(Color.WHITE);
        }
        this.add(this.label);
    }

    /**
     * Crée une chaîne de caractères représentant le temps de jeu.
     * Uniquement les heures, minutes et secondes sont affichées.
     *
     * @return le temps de jeu sous forme de chaîne de caractères.
     */
    public String getTextTime() {
        long time = this.taquin.getTime();
        if (time > 3600) {
            return time / 3600 + "h " + (time % 3600) / 60 + "m " + time % 60 + "s";
        } else if (time > 60) {
            return time / 60 + "m " + time % 60 + "s";
        } else {
            return time + "s";
        }
    }

    @Override
    public void updatedModel(Object o) {
        this.label.setText(this.getTextTime());
        if (this.taquin.getTime() <= 15) {
            this.label.setForeground(Color.RED);
        }
    }

}
