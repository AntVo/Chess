import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * Represents a tile on a chessboard. 
 * 
 */
public class Tile extends JPanel
{
	//Defined variables.
    private Piece piece; // Null if empty
    private String tileColor; 
    private String notation = "";
    public String WHITE = "white";
    public String BLACK = "black";
    private boolean highlight;

    public Tile(BorderLayout borderLayout)
    {
        super(borderLayout);
        this.piece = null;
    }
        
    public Tile(BorderLayout borderLayout, String tileColor)
    {
        super(borderLayout);
        this.piece = null;
        this.tileColor = tileColor;
    }

    //Constructor
    public Tile(boolean color, int x, int y)
    {

    	this.highlight = false;
        this.piece = null;
        
        if(color == true)
        {
        	this.tileColor = WHITE;
        }
        else
        {
        	this.tileColor = BLACK;
        }
        // TODO: please comment what this does
        this.notation = Character.toString((char)(97+x));
        this.notation += (char)(y+48+1);
    }

    public int getX(){
        return this.getLocation().x;
    }

    public int getY(){
        return this.getLocation().y;
    }

    //Returns color.
    public String getColor()
    {
    	return this.tileColor;
    }
    
    //Returns a removed piece.
    public Piece removePiece()
    {
    	Piece p = this.piece;
    	return p;
    }
    
    //Sets a piece.
    public void setPiece(Piece p)
    {
    	this.piece = p;
    }
    
    //Checks if there is a piece present.
    public boolean isEmpty(){
        return this.piece == null;
    }
}
