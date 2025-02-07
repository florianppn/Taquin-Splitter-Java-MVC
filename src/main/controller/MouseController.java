package main.controller;

import main.model.*;
import main.view.*;

import java.awt.event.*;

/**
 * Représente le contrôleur de la souris.
 *
 * @author Florian Pépin
 * @version 1.0
 */
public class MouseController implements MouseListener {

    private Taquin taquin;
    private GUI gui;

    public MouseController(Taquin taquin, GUI gui) {
        this.taquin = taquin;
        this.gui = gui;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = this.getColumn(e);
        int y = this.getRow(e);
        this.taquin.setClickX(x);
        this.taquin.setClickY(y);
        this.taquin.move(y, x);
        this.finishGame();
    }

    public void finishGame() {
        if(this.taquin.isSolved()) {
            this.gui.showEndGame();
        }
    }

    public int getRow(MouseEvent e) {
        int y = e.getY();
        int gridSize = this.taquin.getSize();
        int cellHeight = e.getComponent().getHeight() / gridSize;
        return y / cellHeight;
    }

    public int getColumn(MouseEvent e) {
        int x = e.getX();
        int gridSize = this.taquin.getSize();
        int cellWidth = e.getComponent().getWidth() / gridSize;
        return x / cellWidth;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //
    }

}
