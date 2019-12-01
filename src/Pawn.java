import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * Piece 
 */
public class Pawn extends Piece
{
    public Pawn(String imageLocation, String color, Tile tile)
    {   
        super(imageLocation, color, tile);
    }

    // Return ArrayList of Tiles piece can move to
    public ArrayList<Tile> getValidMoves(ChessBoard board, int row, int col)
    {       

        ArrayList<Tile> validMoves = new ArrayList<Tile>();
        return validMoves;
    }
    
    @Override
    public boolean validSpot(ChessBoard board, int colStart, int rowStart, int rowEnd, int colEnd)
    {
    	if(super.validSpot(board, colStart, rowStart, rowEnd, colEnd) == false)
    		return false;
    	

        // Check did not move horizontally (WARNING/TODO: Pawn actually can
        // make horizontal movements when attacking so need to account for that
        // condition)
    	if(colStart - colEnd == 0)
    	{
    		return true;
    	}
 
    	//else if - more rules like attacking
    	
    	return false;
    	
    }
}
