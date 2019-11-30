import java.util.ArrayList;

/**
 * Piece 
 */
public class King extends Piece
{

    public King(String imageLocation, String color, Tile tile)
    {   
        super(imageLocation, color, tile);
    }

    // Return ArrayList of Tiles piece can move to
    public ArrayList<Tile> getValidMoves(ChessBoard board)
    {       
        int row = this.getRow();
        int col = this.getCol();
        ArrayList<Tile> validMoves = new ArrayList<Tile>();
        return validMoves;
    }

}
