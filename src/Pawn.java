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
    
    public ArrayList<Tile> move(Tile tiles[][], int x, int y)
    {
    
    	//find location
    	
		//see if it moved
		//find possible moves (one or two spaces depending on if it moved
    	//is there anything blocking the way forward
    	//attack?
    	//if pawn reaches other side of board
    	return null;
    	
    }
    
    @Override
    public boolean validSpot(ChessBoard board, int colStart, int rowStart, int rowEnd, int colEnd)
    {
    	if(super.validSpot(board, colStart, rowStart, rowEnd, colEnd) == false)
    		return false;
    	
    	if(xStart - xEnd == 0)
    	{
    		return true;
    	}
    	//else if - more rules like attacking
    	
    	return false;
    	
    }
}
