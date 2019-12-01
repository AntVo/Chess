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
}
