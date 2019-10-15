import java.util.ArrayList;

/**
 * Represents a tile on a chessboard. 
 */
public class Tile
{
    private Piece piece; // Null if empty
    private String tileColor;

    public Tile(tileColor)
    {
        this.piece = null;
        this.tileColor = tileColor;
    }


        
    public isEmpty(){
        return this.piece == null;
    }

    public renderBoard(){
        // TODO
    }    
}