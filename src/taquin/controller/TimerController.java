package taquin.controller;

import taquin.model.*;

import javax.swing.*;

/**
 * Représente le temps de jeu.
 *
 * @author Florian Pépin
 * @version 1.0
 */
public class TimerController {

    private Taquin taquin;
    private Timer timer;

    public TimerController(Taquin taquin) {
        this.taquin = taquin;
        this.start();
    }

    /**
     * Démarre le timer.
     */
    public void start() {
        this.timer = new Timer(1000, e -> {
            this.taquin.incrementTime();
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
