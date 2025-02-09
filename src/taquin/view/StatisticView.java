package taquin.view;

import taquin.model.*;
import taquin.utils.*;

import java.awt.*;
import javax.swing.*;

/**
 * Représente les statistiques du joueur.
 *
 * @author Florian Pépin
 * @version 1.0
 */
public class StatisticView extends JPanel implements ModelListener {

    private Taquin taquin;
    private JLabel stats;

    public StatisticView(Taquin taquin) {
        super(new GridBagLayout());
        this.taquin = taquin;
        this.taquin.addModelListener(this);
        this.setBackground(Color.WHITE);
        this.stats = new JLabel("Nombre de coups : " + this.taquin.getShot());
        this.add(this.stats);
    }

    @Override
    public void updatedModel(Object source) {
        this.stats.setText("Nombre de coups : " + this.taquin.getShot());
    }

}
