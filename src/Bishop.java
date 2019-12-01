import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 * Piece 
 */
public class Bishop extends Piece
{
    public Bishop(String imageLocation, String color, Tile tile)
    {   
        super(imageLocation, color, tile);
    }

    // Return ArrayList of Tiles the Bishop can move to
    @Override
    public ArrayList<Tile> getValidMoves(ChessBoard board)
    {       
        return this.getValidDiagonalMoves(board);
    }

    @Override
    public boolean validSpot(ChessBoard board, int rowStart, int colStart, int rowEnd, int colEnd)
    {
        if (super.validSpot(board, rowStart, colStart, rowEnd, colEnd) == false)
            return false;
        
        // Validate that spot is diagonal
        // ( delta row and delta col must be equal for diagonal )
        if (Math.abs(rowStart-rowEnd) != Math.abs(colStart-colEnd))
            return false;

        return true;        
    }
}
