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
    public Piece piece; // Null if empty
    private String tileColor; 
    private String notation = "";
    public String WHITE = "WHITE";
    public String BLACK = "BLACK";
    public boolean highlight;
    
    int x, y;

    public Tile(BorderLayout borderLayout)
    {
        super(borderLayout);
        this.piece = null;
    }
    
    public Tile(BorderLayout borderLayout, int x, int y)
    {
        super(borderLayout);
        this.piece = null;
        
        this.x = x;
        this.y = y;
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
        this.x = x;
        this.y = y;
//        // TODO: please comment what this does
//        this.notation = Character.toString((char)(97+x));
//        this.notation += (char)(y+48+1);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
    	super.paintComponent(g);
    	
    	if(highlight)
    	{
    		int thickness = 5;
    		g.fillRect(0, 0, this.getWidth(), thickness);
    		g.fillRect(0, 0, thickness, this.getHeight());
    		
    		g.fillRect(0, this.getHeight() - thickness, this.getWidth(), thickness);
    		g.fillRect(this.getWidth() - thickness, 0, thickness, this.getHeight());
    	}
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
    	this.remove(this.piece);
    	piece = null;
    	return p;
    }
    
    
    //Sets a piece.
    public void setPiece(Piece p)
    {
    	this.piece = p;
    }

    public Piece getPiece(){
        return this.piece;
    }
    
    //Checks if there is a piece present.
    public boolean isEmpty()
   {
        return this.piece == null;
    }
}
