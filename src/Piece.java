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
    
    /**
     * Validate a move    
     * @param  board  Chessboard object holding state of the chessboard
     * @param  rowStart piece's initial chess row
     * @param  colStart piece's initial chess column
     * @param  rowEnd   row to move the chess piece to
     * @param  colEnd   column to move the chess piece to
     * @return true if valid, else false
     */
    public boolean validSpot(ChessBoard board, int colStart, int rowStart, int rowEnd, int colEnd)
    {   
    	if(colStart == colEnd && rowStart == rowEnd)
    	{
            // Did not change location
    		return false;
    	}
    	if(colEnd > 7 || colEnd < 0 || rowEnd > 7 || rowEnd < 0)
    	{
            // Outside boundaries of Chessboard
    		return false;
    	}
    	return true;
    }
    
    public void move(Tile selectedTile)
    {
    	System.out.println("moving piece");
    	//this.currentTile.remove(this);
    	this.currentTile.removePiece();
    	selectedTile.add(this);
    	selectedTile.setPiece(this);
    	this.currentTile = selectedTile;
    }
}

