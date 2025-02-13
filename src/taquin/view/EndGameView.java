package taquin.view;

import taquin.model.*;

import javax.swing.*;
import java.awt.*;

/**
 * Représente la vue de fin de partie.
 *
 * @author Florian Pépin
 * @version 1.0
 */
public class EndGameView extends JPanel {

    private Taquin taquin;
    private boolean state;

    public EndGameView(Taquin taquin, boolean state) {
        super();
        this.taquin = taquin;
        this.setLayout(new BorderLayout());
        JLabel label = this.createLabel();
        label.setFont(new Font("Serif", Font.BOLD, 48));
        this.add(label, BorderLayout.CENTER);
    }

    public JLabel createLabel() {
        if (this.state) {
            return new JLabel("Vous avez gagné !", SwingConstants.CENTER);
        } else {
            return new JLabel("Vous avez perdu !", SwingConstants.CENTER);
        }
    }

}
