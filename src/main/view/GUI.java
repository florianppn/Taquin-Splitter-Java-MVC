package main.view;

import main.model.*;

import javax.swing.*;

public class GUI extends JFrame {

    private Taquin taquin;

    public GUI(Taquin taquin) {
        super("Taquin");
        this.taquin = taquin;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.add(new GridView(this.taquin));
    }

}
