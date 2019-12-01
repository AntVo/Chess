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
    public ArrayList<Tile> getValidMoves(ChessBoard board)
    {       
        int row = this.getRow();
        int col = this.getCol();
        ArrayList<Tile> validMoves = new ArrayList<Tile>();


        // Add all valid northwest moves to array of valid moves
        int currRow = row - 1;
        int currCol = col - 1;
        while (validSpot(board, row, col, currRow, currCol)){
            Tile currTile = board.getTileAtLocation(currRow, currCol);
            validMoves.add(currTile);

            // If we run into enemy piece, we added it as a valid move, but
            // dont allow further movement in direction
            Piece currPiece = board.getPieceAtLocation(currRow, currCol);
            if (currPiece != null && currPiece.getColor() != this.getColor()){
                break;
            }
            currRow--;
            currCol--;
        }

        // Add all valid northeast moves to array of valid moves
        currRow = row - 1;
        currCol = col + 1;
        while (validSpot(board, row, col, currRow, currCol)){
            Tile currTile = board.getTileAtLocation(currRow, currCol);
            validMoves.add(currTile);

            // If we run into enemy piece, we added it as a valid move, but
            // dont allow further movement in direction
            Piece currPiece = board.getPieceAtLocation(currRow, currCol);
            if (currPiece != null && currPiece.getColor() != this.getColor()){
                break;
            }
            currRow--;
            currCol++;
        }

        // Add all valid southwest moves to array of valid moves
        currRow = row + 1;
        currCol = col - 1;
        while (validSpot(board, row, col, currRow, currCol)){
            Tile currTile = board.getTileAtLocation(currRow, currCol);
            validMoves.add(currTile);

            // If we run into enemy piece, we added it as a valid move, but
            // dont allow further movement in direction
            Piece currPiece = board.getPieceAtLocation(currRow, currCol);
            if (currPiece != null && currPiece.getColor() != this.getColor()){
                break;
            }
            currRow++;
            currCol--;
        }

        // Add all valid southeast moves to array of valid moves
        currRow = row + 1;
        currCol = col + 1;
        while (validSpot(board, row, col, currRow, currCol)){
            Tile currTile = board.getTileAtLocation(currRow, currCol);
            validMoves.add(currTile);

            // If we run into enemy piece, we added it as a valid move, but
            // dont allow further movement in direction
            Piece currPiece = board.getPieceAtLocation(currRow, currCol);
            if (currPiece != null && currPiece.getColor() != this.getColor()){
                break;
            }
            currRow++;
            currCol++;
        }
        return validMoves;
    }


    
    @Override
    public boolean validSpot(ChessBoard board, int rowStart, int colStart, int rowEnd, int colEnd)
    {
        if (super.validSpot(board, rowStart, colStart, rowEnd, colEnd) == false)
            return false;
        
        // Validate that spot is diagonal
        // (delta row and delta col must be equal for diagonal )
        if (Math.abs(rowStart-rowEnd) != Math.abs(colStart-colEnd))
            return false;

        return true;        
    }
}
