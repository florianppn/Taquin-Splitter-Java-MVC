package splitter;

import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

/**
 * Représente le découpage d'une image en plusieurs morceaux.
 *
 * @author Florian Pépin
 * @version 1.0
 */
public class ImageCutter {

    private final static String PATH_IMAGES = "/resources/images/";
    private String name;
    private String format;
    private int rows;
    private int columns;

    public ImageCutter(String name, String format, int rows, int columns) {
        this.name = name;
        this.format = format;
        this.rows = rows;
        this.columns = columns;
    }

    /**
     * Découpe l'image en plusieurs morceaux.
     */
    public void cut() {
        try {
            InputStream imageStream = getClass().getResourceAsStream(PATH_IMAGES + this.name + "." + this.format);
            BufferedImage image = ImageIO.read(imageStream);
            int cellWidth = image.getWidth() / this.columns;
            int cellHeight = image.getHeight() / this.rows;
            BufferedImage[][] grid = new BufferedImage[this.rows][this.columns];

            this.extractSubImage(image, grid, cellWidth, cellHeight);
            this.saveSubImages(grid);
        } catch (Exception e) {
            System.err.println("Error cutting image : " + e.getMessage());
        }
    }

    /**
     * Extrait les images découpées.
     *
     * @param image l'image à découper.
     * @param grid la grille d'images.
     * @param cellWidth la largeur d'une cellule.
     * @param cellHeight la hauteur d'une cellule.
     */
    private void extractSubImage(BufferedImage image, BufferedImage[][] grid, int cellWidth, int cellHeight) {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                int x = j * cellWidth;
                int y = i * cellHeight;
                grid[i][j] = image.getSubimage(x, y, cellWidth, cellHeight);
            }
        }
    }

    /**
     * Sauvegarde les images découpées.
     *
     * @param grid la grille d'images.
     */
    private void saveSubImages(BufferedImage[][] grid) {
        File firstDir = new File(this.rows + "x" + this.columns+"/");
        File secondDir = new File(firstDir, this.name + "/");
        int value = 1;
        if (!firstDir.exists()) firstDir.mkdirs();
        if (!secondDir.exists()) secondDir.mkdirs();
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                File outputfile = new File(this.rows + "x" + this.columns + "/" + this.name + "/" + value + "." + this.format);
                value++;
                try {
                    ImageIO.write(grid[i][j], this.format, outputfile);
                } catch (IOException e) {
                    throw new RuntimeException("Error saving images : " + e.getMessage());
                }
            }
        }
    }

}
