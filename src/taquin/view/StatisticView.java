package taquin.view;

import taquin.model.*;
import taquin.utils.*;

import java.awt.*;
import javax.swing.*;

/**
 * Représente la vue des statistiques du jeu.
 *
 * @author Florian Pépin
 * @version 1.0
 */
public class StatisticView extends JPanel implements ModelListener {

    private Taquin taquin;
    private JLabel stats;

    public StatisticView(Taquin taquin) {
        super();
        this.taquin = taquin;
        this.taquin.addModelListener(this);
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.stats = new JLabel("Nombre de coups : " + this.taquin.getShot());
        this.add(this.stats);
    }

    @Override
    public void updatedModel(Object source) {
        this.stats.setText("Nombre de coups : " + this.taquin.getShot());
    }

}
