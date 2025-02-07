package main.view;

import main.controller.MouseController;
import main.model.*;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private Taquin taquin;

    public GUI(Taquin taquin) {
        super("Taquin");
        this.taquin = taquin;
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.add(new StatisticView(this.taquin), BorderLayout.NORTH);
        this.add(new GridView(this.taquin), BorderLayout.CENTER);
        this.addMouseListener(new MouseController(this.taquin));

        this.setVisible(true);
    }

}
