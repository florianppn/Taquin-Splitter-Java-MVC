package taquin.view;

import taquin.model.Taquin;
import taquin.utils.*;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * Représente la grille du jeu avec les images.
 *
 * @author Florian Pépin
 * @version 1.0
 */
public class GridWithImageView extends JPanel implements ModelListener {

    private final static String PATH = "/resources/cutout_images/";
    private Taquin taquin;
    private String imageUrl;

    public GridWithImageView(Taquin taquin, String imageUrl) {
        super();
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.taquin = taquin;
        this.taquin.addModelListener(this);
        this.imageUrl = imageUrl;
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
                    try {
                        Image img = new ImageIcon(Objects.requireNonNull(getClass().getResource(PATH + imageUrl + grid[i][j] + ".jpg"))).getImage();
                        g.drawImage(img, x, y, cellWidth, cellHeight, null);
                    } catch (Exception e) {
                        g.drawString(Integer.toString(grid[i][j]), x + cellWidth / 2, y + cellHeight / 2);
                    }
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
