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
        this.label = new JLabel("0s");
        this.label.setFont(new Font("Arial", Font.BOLD, 24));
        this.setBackground(Color.WHITE);
        this.add(this.label);
    }

    @Override
    public void updatedModel(Object o) {
        this.label.setText(this.taquin.getTime() + "s");
    }

}
