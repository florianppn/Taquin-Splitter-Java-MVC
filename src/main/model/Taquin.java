package main.model;

import java.util.*;
import main.utils.*;

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
    private int[][] grid;

    public Taquin(int size) {
        this.size = size;
        this.x0 = size-1;
        this.y0 = size-1;
        this.grid = this.generateTable();
    }

    public int[][] getGrid() {
        return this.grid;
    }

    public int getSize() {
        return this.size;
    }

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

    public void shuffle(int n) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            List<Pair<Integer, Integer>> neighbors = this.getNeighbors(this.x0, this.y0);
            int choice = random.nextInt(neighbors.size());
            this.move(neighbors.get(choice).x, neighbors.get(choice).y);
        }
    }

    private List<Pair<Integer, Integer>> getNeighbors(int x, int y) {
        ArrayList<Pair<Integer, Integer>> neighbors = new ArrayList<>();

        if (this.isPosition(x+1, y+1)) neighbors.add(new Pair<>(x+1, y+1));
        if (this.isPosition(x-1, y-1)) neighbors.add(new Pair<>(x-1, y-1));
        if (this.isPosition(x+1, y-1)) neighbors.add(new Pair<>(x+1, y-1));
        if (this.isPosition(x-1, y+1)) neighbors.add(new Pair<>(x-1, y+1));

        return neighbors;
    }

    private boolean isPosition(int x, int y) {
        return x >= 0 && x < this.size && y >= 0 && y < this.size;
    }

    private void move(int x, int y) {
        if (this.isPosition(x, y)) {
            this.grid[this.x0][this.y0] = this.grid[x][y];
            this.grid[x][y] = 0;
            this.x0 = x;
            this.y0 = y;
        }
    }

    public boolean isSolved() {
        int value = 1;
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (this.grid[i][j] != value) {
                    return false;
                }
                value++;
            }
        }
        return true;
    }

}


