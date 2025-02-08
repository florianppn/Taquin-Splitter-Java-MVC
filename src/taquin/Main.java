package taquin;

import taquin.model.*;
import taquin.view.*;

public class Main {

    public static void main(String[] args) {
        Taquin taquin = new Taquin(5);
        taquin.shuffle(100);
        GUI gui = new GUI(taquin);
    }

}