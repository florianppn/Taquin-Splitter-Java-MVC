package main.controller;

import main.model.*;

import java.awt.event.*;

public class MouseController implements MouseListener {

    private Taquin taquin;

    public MouseController(Taquin taquin) {
        this.taquin = taquin;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked :"+e.getX()+" "+e.getY());
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
