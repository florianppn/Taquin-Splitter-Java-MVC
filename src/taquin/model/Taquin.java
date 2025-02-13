package taquin.model;

import java.util.*;

import taquin.utils.*;

/**
 * Représente la grille de jeu.
 *
 * @author Florian Pépin
 * @version 1.0
 */
public class Taquin extends AbstractListenableModel {

    private int size;
    private int x0;
    private int y0;
    private int clickX;
    private int clickY;
    private int[][] grid;
    private int shot;
    private long time;
    private long savedTime;

    public Taquin(int size, int time) {
        this.size = size;
        this.x0 = size-1;
        this.y0 = size-1;
        this.clickX = -1;
        this.clickY = -1;
        this.grid = this.generateTable();
        this.shot = 0;
        this.time = time;
        this.savedTime = time;
    }

    public int[][] getGrid() {
        return this.grid;
    }

    public int getSize() {
        return this.size;
    }

    public int getX0() {
        return this.x0;
    }

    public int getY0() {
        return this.y0;
    }

    public int getClickX() {
        return this.clickX;
    }

    public int getClickY() {
        return this.clickY;
    }

    public int getShot() {
        return this.shot;
    }

    public long getTime() {
        return this.time;
    }

    public void setX0(int x0) {
        this.x0 = x0;
        this.fireChange();
    }

    public void setY0(int y0) {
        this.y0 = y0;
        this.fireChange();
    }

    public void setClickX(int clickX) {
        this.clickX = clickX;
        this.fireChange();
    }

    public void setClickY(int clickY) {
        this.clickY = clickY;
        this.fireChange();
    }

    /**
     * Décrémente le temps de jeu.
     */
    public void decrementTime() {
        this.time--;
        this.fireChange();
    }

    /**
     * Génère une grille de jeu.
     *
     * @return La grille de jeu.
     */
    public int[][] generateTable() {
        int[][] table = new int[this.size][this.size];
        int value = 1;
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                table[i][j] = value;
                value++;
            }
        }
        table[this.size-1][this.size-1] = 0;
        return table;
    }

    /**
     * Mélange la grille de jeu.
     *
     * @param n Le nombre de coups pour mélanger la grille.
     */
    public void shuffle(int n) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            List<Pair<Integer, Integer>> neighbors = this.getNeighbors(this.x0, this.y0);
            int choice = random.nextInt(neighbors.size());
            this.grid[this.x0][this.y0] = this.grid[neighbors.get(choice).x][neighbors.get(choice).y];
            this.grid[neighbors.get(choice).x][neighbors.get(choice).y] = 0;
            this.x0 = neighbors.get(choice).x;
            this.y0 = neighbors.get(choice).y;
        }
    }

    /**
     * Récupère les voisins d'une case.
     *
     * @param x représente la position x de la case.
     * @param y représente la position y de la case.
     * @return La liste des voisins de la case.
     */
    private List<Pair<Integer, Integer>> getNeighbors(int x, int y) {
        ArrayList<Pair<Integer, Integer>> neighbors = new ArrayList<>();

        if (this.isPosition(x+1, y+1)) neighbors.add(new Pair<>(x+1, y+1));
        if (this.isPosition(x-1, y-1)) neighbors.add(new Pair<>(x-1, y-1));
        if (this.isPosition(x+1, y-1)) neighbors.add(new Pair<>(x+1, y-1));
        if (this.isPosition(x-1, y+1)) neighbors.add(new Pair<>(x-1, y+1));

        return neighbors;
    }

    public boolean isNeighbor(int x, int y) {
        return (Math.abs(this.x0 - x) == 1 && this.y0 == y) || (Math.abs(this.y0 - y) == 1 && this.x0 == x);
    }

    public boolean isPosition(int x, int y) {
        return x >= 0 && x < this.size && y >= 0 && y < this.size;
    }

    /**
     * Déplace une case de la grille.
     *
     * @param x représente la position x de la case à déplacer.
     * @param y représente la position y de la case à déplacer.
     */
    public void move(int x, int y) {
        if (this.isPosition(x, y) && this.isNeighbor(x, y)) {
            this.grid[this.x0][this.y0] = this.grid[x][y];
            this.grid[x][y] = 0;
            this.x0 = x;
            this.y0 = y;
            this.shot++;
            this.fireChange();
        }
    }

    /**
     * Vérifie si la grille est résolue.
     *
     * @return Vrai si la grille est résolue, faux sinon.
     */
    public boolean isSolved() {
        int value = 1;
        for (int i = 0; i < this.size-1; i++) {
            for (int j = 0; j < this.size-1; j++) {
                if (this.grid[i][j] != value) {
                    return false;
                }
                value++;
            }
        }
        return this.grid[this.size-1][this.size-1] == 0;
    }

    /**
     * Réinitialise la grille de jeu.
     */
    public void reset() {
        this.shot = 0;
        this.time = this.savedTime;
        this.x0 = this.size-1;
        this.y0 = this.size-1;
        this.grid = this.generateTable();
        this.shuffle(100);
        this.fireChange();
    }

}


