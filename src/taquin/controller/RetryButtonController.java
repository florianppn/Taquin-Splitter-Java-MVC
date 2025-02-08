package taquin.controller;

import taquin.model.*;
import taquin.view.*;

import javax.swing.*;
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
    private GUI gui;

    public RetryButtonController(Taquin taquin, GUI gui) {
        super("Retry");
        this.taquin = taquin;
        this.gui = gui;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.taquin.reset();
        this.gui.showGame();
    }

}
