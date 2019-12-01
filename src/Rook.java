import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * Piece 
 */
public class Rook extends Piece
{
    public Rook(String imageLocation, String color, Tile tile)
    {   
        super(imageLocation, color, tile);
    }
    
    // Return ArrayList of Tiles piece can move to
    public ArrayList<Tile> getValidMoves(ChessBoard board)
    {       
        return getValidHorizontalAndVerticalMoves(board);
    }

    
    @Override
    public boolean validSpot(ChessBoard board, int rowStart, int colStart, int rowEnd, int colEnd)
    {
        if (super.validSpot(board, rowStart, colStart, rowEnd, colEnd) == false)
            return false;
  
        // If spot is on horizontal/vertical it is valid
        if (rowStart == rowEnd || colStart == colEnd )
            return true;

        return true; 
    }
}
