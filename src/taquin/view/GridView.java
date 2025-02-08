package taquin.view;

import taquin.model.*;
import taquin.utils.*;

import java.awt.*;
import javax.swing.*;

/**
 * Représente la vue de la grille de jeu.
 *
 * @author Florian Pépin
 * @version 1.0
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
        int[][] grid = this.taquin.getGrid();
        int cellWidth = getWidth() / this.taquin.getSize();
        int cellHeight = getHeight() / this.taquin.getSize();
        for (int i = 0; i < this.taquin.getSize(); i++) {
            for (int j = 0; j < this.taquin.getSize(); j++) {
                int x = j * cellWidth;
                int y = i * cellHeight;
                g.setColor(Color.BLACK);
                if (grid[i][j] == 0) {
                    g.fillRect(x, y, cellWidth, cellHeight);
                } else {
                    g.drawRect(x, y, cellWidth, cellHeight);
                    g.drawString(Integer.toString(grid[i][j]), x + cellWidth / 2, y + cellHeight / 2);
                }
            }
        }
        g.setColor(Color.RED);
        g.drawRect(this.taquin.getClickX()*cellWidth, this.taquin.getClickY()*cellHeight, cellWidth, cellHeight);
    }

    @Override
    public void updatedModel(Object source) {
        repaint();
    }

}
