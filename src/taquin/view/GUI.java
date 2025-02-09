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
    private String folderPictures;

    public GUI(Taquin taquin, String folderPictures) {
        super("Taquin");
        this.taquin = taquin;
        this.folderPictures = folderPictures;
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
        TimerController timerController = new TimerController(this.taquin);
        panel.setLayout(new GridLayout(1,3));
        panel.add(new StatisticView(this.taquin));
        panel.add(new TimerView(this.taquin));
        panel.add(new RetryButtonController(this.taquin, timerController, this));
        this.add(panel, BorderLayout.NORTH);
        this.add(new GridWithImageView(this.taquin, folderPictures), BorderLayout.CENTER);
        this.addMouseListener(new MouseController(this.taquin, timerController, this));
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
