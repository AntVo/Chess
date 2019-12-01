import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * Piece 
 */
public class Queen extends Piece
{

    public Queen(String imageLocation, String color, Tile tile)
    {   
        super(imageLocation, color, tile);
    }

    // Return ArrayList of Tiles piece can move to
    public ArrayList<Tile> getValidMoves(ChessBoard board)
    {       
        ArrayList<Tile> validMoves = new ArrayList<Tile>();

        ArrayList<Tile> verticalMoves = this.getValidDiagonalMoves(board);
        ArrayList<Tile> horizontalAndVerticalMoves = this.getValidHorizontalAndVerticalMoves(board);
         
        validMoves.addAll(verticalMoves);
        validMoves.addAll(horizontalAndVerticalMoves);
        return validMoves;
    }
    
    @Override
    public boolean validSpot(ChessBoard board, int rowStart, int colStart, int rowEnd, int colEnd)
    {
        if (super.validSpot(board, rowStart, colStart, rowEnd, colEnd) == false)
            return false;
        
        // If spot is diagonal it is valid
        if (Math.abs(rowStart-rowEnd) == Math.abs(colStart-colEnd) )
            return true;

        // If spot is on horizontal/vertical it is valid
        if (rowStart == rowEnd || colStart == colEnd )
            return true;

        return true; 
    }
}
