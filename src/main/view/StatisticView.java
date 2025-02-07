package main.view;

import main.model.*;
import main.utils.*;

import java.awt.*;
import javax.swing.*;

public class StatisticView extends JPanel implements ModelListener {

    private Taquin taquin;
    private JLabel stats;

    public StatisticView(Taquin taquin) {
        super();
        this.taquin = taquin;
        this.taquin.addModelListener(this);
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.stats = new JLabel("Nombre de coups : " + this.taquin.getShot());
        this.add(this.stats);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
    }

    @Override
    public void updatedModel(Object source) {
        this.stats.setText("Nombre de coups : " + this.taquin.getShot());
    }

}
