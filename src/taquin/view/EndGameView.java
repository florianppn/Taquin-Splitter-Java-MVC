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

    public EndGameView(Taquin taquin) {
        super();
        this.taquin = taquin;
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("Vous avez gagné !", SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 48));
        this.add(label, BorderLayout.CENTER);
    }

}
