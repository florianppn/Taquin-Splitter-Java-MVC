package taquin.view;

import taquin.controller.*;
import taquin.model.*;

import javax.swing.*;
import java.awt.*;

/**
 * Représente la fenêtre principale de l'application.
 *
 * @author Florian Pépin
 * @version 1.0
 */
public class GUI extends JFrame {

    private Taquin taquin;

    public GUI(Taquin taquin) {
        super("Taquin");
        this.taquin = taquin;
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setResizable(false);
        this.showGame();
        this.setVisible(true);
    }

    /**
     * Affiche le jeu.
     */
    public void showGame() {
        this.getContentPane().removeAll();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2));
        panel.add(new StatisticView(this.taquin));
        panel.add(new RetryButtonController(this.taquin, this));
        this.add(panel, BorderLayout.NORTH);
        this.add(new GridWithImageView(this.taquin, "forest/"), BorderLayout.CENTER);
        this.addMouseListener(new MouseController(this.taquin, this));
        this.revalidate();
        this.repaint();
    }

    /**
     * Affiche l'écran de fin de jeu.
     */
    public void showEndGame() {
        this.getContentPane().removeAll();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2));
        panel.add(new StatisticView(this.taquin));
        panel.add(new RetryButtonController(this.taquin, this));
        this.add(panel, BorderLayout.NORTH);
        this.add(new EndGameView(this.taquin), BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

}
