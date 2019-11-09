
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * Piece 
 */
public class Queen extends JLabel implements Piece
{
    private static String white_icon = "../assets/pieces/white_queen.png";
    private static String black_icon = "../assets/pieces/black_queen.png";
    private String color;
    private Tile currentTile;

    public Queen(String color, Tile currentTile)
    {   
        super();
        if (color.toUpperCase() == "WHITE"){
            this.setIcon(new ImageIcon(white_icon));
            this.color = "WHITE";
        }
        else {
            this.setIcon(new ImageIcon(black_icon));
            this.color = "BLACK";
        }
        this.currentTile = currentTile;
        currentTile.add(this);
    }
}
