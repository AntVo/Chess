import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * Piece, ?: Should this be an abstract class instead of an interface?
 */
public abstract class Piece extends JLabel
{
    String color;
    Tile currentTile;

    public Piece(String imageLocation, String color, Tile tile) {
        super();
        this.setIcon(new ImageIcon(imageLocation));
        this.color = color;
        this.currentTile = tile;
        this.currentTile.setPiece(this);
        this.currentTile.add(this);
    }

    
}

