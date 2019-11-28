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
    
    public boolean validSpot(ChessBoard board, int xStart, int yStart, int xEnd, int yEnd)
    {
    	if(xStart == xEnd && yStart == yEnd)
    	{
    		return false;
    	}
    	if(xEnd > 7 || xEnd < 0 || yEnd > 7 || yEnd < 0)
    	{
    		return false;
    	}
    	return true;
    }
}

