package taquin.controller;

import taquin.model.*;
import taquin.view.*;

import javax.swing.*;

/**
 * Représente le temps de jeu.
 *
 * @author Florian Pépin
 * @version 1.0
 */
public class TimerController {

    private Taquin taquin;
    private GUI gui;
    private Timer timer;

    public TimerController(Taquin taquin, GUI gui) {
        this.taquin = taquin;
        this.gui = gui;
        this.start();
    }

    /**
     * Démarre le timer.
     */
    public void start() {
        this.timer = new Timer(1000, e -> {
            this.taquin.decrementTime();
            if(this.taquin.getTime() <= 0) {
                timer.stop();
                this.gui.showEndGame(false);
            }
        });
        timer.start();
    }

    /**
     * Arrête le timer.
     */
    public void stop() {
        this.timer.stop();
    }

}
