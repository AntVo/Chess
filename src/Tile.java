import javax.swing.*;

/**
 * Represents a tile on a chessboard. 
 */
public class Tile extends JLabel
{
	//Defined variables.
    private Piece piece; // Null if empty
    private String tileColor;
    public String WHITE = "white";
    public String BLACK = "black";
    
    int x;
    int y;
    
    String notation = "";
    
    boolean highlight;
    
    //Constructor
    public Tile(boolean color, int x, int y)
    {
    	this.x = x;
    	this.y = y;
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
        
        this.notation = Character.toString((char)(97+x));
        this.notation += (char)(y+48+1);
        
    }
    
    //Returns x coordinate;
    public int getX()
    {
    	return this.x;
    }
    
    //Returns y coordinate.
    public int getY()
    {
    	return this.y;
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
