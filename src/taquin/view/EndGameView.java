package taquin.view;

import taquin.model.*;
import taquin.utils.*;

import javax.swing.*;
import java.awt.*;

public class EndGameView extends JPanel implements ModelListener {

    private Taquin taquin;

    public EndGameView(Taquin taquin) {
        super();
        this.taquin = taquin;
        this.taquin.addModelListener(this);

        JLabel label = new JLabel("You won!", SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 48));
        this.add(label);
    }

    @Override
    public void updatedModel(Object source) {
        //
    }

}
