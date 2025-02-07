package main;

import main.model.*;
import main.view.*;

public class Main {

    public static void main(String[] args) {
        Taquin taquin = new Taquin(4);
        taquin.shuffle(100);
        GUI gui = new GUI(taquin);
    }

}