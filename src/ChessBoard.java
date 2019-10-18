import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * Chessboard is represented by a a Matrix of Tile objects.
 * There are two main components of the chessBoard,
 * 1. chessBoard - a Matrix of Tiles that represents the board state.
 * 2. Jpanel - The Chessboard itself extends JPanel and is a GUI element.
 */
public class ChessBoard extends JPanel
{
    private Tile[][] chessBoard;
    private Dimension boardSize;;

    public ChessBoard(Dimension boardSize)
    {
        super();
        this.chessBoard = null;
        this.boardSize = boardSize;
    }


    public Tile[][] getChessBoard(){
        return this.chessBoard;
    }

    /** 
     * Calls JPanel methods to setup the JPanel Element.
     * 
     * Initializes the Chessboard by creating Tiles, alternating colors 
     * between white and black.
     * End result should be a matrix like:
     */
    public void initializeChessBoard()
    {   
        this.setLayout( new GridLayout(8, 8) );
        this.setPreferredSize( this.boardSize );
        this.setBounds(0, 0, this.boardSize.width, this.boardSize.height);
        for (int i = 0; i < 64; i++) {
            JPanel square = new JPanel( new BorderLayout() );
            this.add( square );
            int row = (i / 8) % 2;
            if (row == 0)
                square.setBackground( i % 2 == 0 ? Color.black : Color.white );
            else
                square.setBackground( i % 2 == 0 ? Color.white : Color.black );
        }
    }

    public void initializeChessPieces(){

    }


    public void printBoard(){
        // TODO
    }

}