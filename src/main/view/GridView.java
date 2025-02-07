package main.view;

import main.model.*;
import main.utils.*;

import java.awt.*;
import javax.swing.*;

/**
 * Représente la vue de la grille de jeu.
 *
 *
 */
public class GridView extends JPanel implements ModelListener {

    private Taquin taquin;

    public GridView(Taquin taquin) {
        super();
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.taquin = taquin;
        this.taquin.addModelListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        int[][] grid = this.taquin.getGrid();
        int width = getWidth() / this.taquin.getSize();
        int height = getHeight() / this.taquin.getSize();
        for (int i = 0; i < this.taquin.getSize(); i++) {
            for (int j = 0; j < this.taquin.getSize(); j++) {
                int x = j * width;
                int y = i * height;
                g.drawRect(x, y, width, height);
                g.drawString(Integer.toString(grid[i][j]), x + width / 2, y + height / 2);
            }
        }
    }

    @Override
    public void updatedModel(Object source) {
        repaint();
    }

}
