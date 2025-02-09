package taquin.controller;

import taquin.model.*;
import taquin.view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

/**
 * Représente le contrôleur du bouton de retry.
 *
 * @author Florian Pépin
 * @version 1.0
 */
public class RetryButtonController extends JButton implements ActionListener {

    private Taquin taquin;
    private TimerController timerController;
    private GUI gui;

    public RetryButtonController(Taquin taquin, TimerController timerController, GUI gui) {
        super("Recommencer");
        this.taquin = taquin;
        this.timerController = timerController;
        this.gui = gui;
        this.customizeButton();
        this.addActionListener(this);
    }

    public RetryButtonController(Taquin taquin, GUI gui) {
        this(taquin, null, gui);
    }

    /**
     * Personnalise le bouton.
     */
    private void customizeButton() {
        this.setFont(new Font("Arial", Font.BOLD, 12));
        this.setBackground(new Color(45, 137, 239));
        this.setForeground(Color.WHITE);
        this.setFocusPainted(false);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setOpaque(true);
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(45, 137, 239), 1),
                BorderFactory.createEmptyBorder(10, 25, 10, 25)
        ));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.taquin.reset();
        this.gui.showGame();
        if (this.timerController != null) {
            this.timerController.stop();
        }
    }

}
