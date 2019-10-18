import javax.swing.*;

/**
 * Represents a tile on a chessboard. 
 */
public class Tile extends JLabel
{
    private Piece piece; // Null if empty
    private String tileColor;

    public Tile(String tileColor)
    {
        this.piece = null;
        this.tileColor = tileColor;
    }
        
    public boolean isEmpty(){
        return this.piece == null;
    }
}