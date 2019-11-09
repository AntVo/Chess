import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * Chessboard is represented by a a Matrix of Tile objects.
 * There are two main components of the chessBoard,
 * 1. chessBoard - a Matrix of Tiles that represents the board state.
 *                 a chessboard contains 64 tiles which themselves can contain pieces.
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
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                Tile tile = new Tile( new BorderLayout() );
                tile.setBackground( i % 2 == 0 ? Color.black : Color.white );
                this.chessBoard[i][j] = tile;
            }
        }
    }

    public void initializeChessPieces(){
        System.out.println("Trying to initialize chess pieces");
        Tile tileToAddPiece = this.chessBoard[2][2];
        JLabel piece = new JLabel(new ImageIcon("../assets/pieces/test.png") );
        tileToAddPiece.add(piece);
    }


    public void printBoard(){
        // TODO
    }

}