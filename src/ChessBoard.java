import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * Chessboard is represented by a a Matrix of Tile objects.
 * There are two main components of the chessBoard,
 * 1. chessBoard - a Matrix of Tiles that represents the board state.
 *                 a chessboard contains 64 tiles which themselves can contain pieces.
 * 2. Jpanel - The Chessboard itself extends JPanel and is a GUI element
 */
public class ChessBoard extends JPanel
{
    // Data structure that represents the Chessboard
    // represented as a matrix of Tiles that contains pieces
    private Tile[][] chessBoard;
    private Dimension boardSize;

    public ChessBoard(Dimension boardSize)
    {
        super();
        this.chessBoard = new Tile[8][8];
        this.boardSize = boardSize;
    }


    public Tile[][] getChessBoard(){
        return this.chessBoard;
    }

    /**
     * Initializes the Chessboard by creating Tiles, alternating colors 
     * between white and black.
     * End result should be a matrix of tiles
     */
    public void initializeChessBoard()
    {   
        // Setup the JFrame that represents the chessboard
        this.setLayout( new GridLayout(8, 8) );
        this.setPreferredSize( this.boardSize );
        this.setBounds(0, 0, this.boardSize.width, this.boardSize.height);
        
        // Iterate over a matrix and create colored tiles
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                Tile tile = new Tile( new BorderLayout() );
                tile.setBackground( i % 2 == j % 2 ? DARK_BROWN : LIGHT_BROWN);
                this.chessBoard[i][j] = tile;
                this.add(tile);
            }
        }
    }

    public void initializeChessPieces(){
        String[] chessRow = {ROOK, KNIGHT, BISHOP, QUEEN, KING, BISHOP, KNIGHT, ROOK};

        // (1) Set the first black row of pieces
        int row = 0;
        for (int i = 0; i < 8; i++){
            Tile tileToAddPiece = this.chessBoard[row][i];
            this.createPiece(chessRow[i], BLACK, tileToAddPiece);
        }

        // (2) Set the row of black pawns
        row = 1;
        for (int i = 0; i < 8; i++){
            Tile tileToAddPiece = this.chessBoard[row][i];
            this.createPiece(PAWN, BLACK, tileToAddPiece);
        }

        // (3) Set the row of white pawns
        row = 6;
        for (int i = 0; i < 8; i++){
            Tile tileToAddPiece = this.chessBoard[row][i];
            this.createPiece(PAWN, WHITE, tileToAddPiece);
        }        

        // (4) Set the row of white pieces
        row = 7;
        for (int i = 0; i < 8; i++){
            Tile tileToAddPiece = this.chessBoard[row][i];
            this.createPiece(chessRow[i], WHITE, tileToAddPiece);
        }        
    }

    public Piece createPiece(String pieceName, String pieceColor, Tile pieceTile){
        Piece newPiece = null;
        switch(pieceName){
            case ROOK:
                newPiece = new Rook(pieceColor, pieceTile);
                break;
            case KNIGHT:
                newPiece = new Knight(pieceColor, pieceTile);
                break;
            case BISHOP:
                newPiece = new Bishop(pieceColor, pieceTile);
                break;
            case QUEEN:
                newPiece = new Queen(pieceColor, pieceTile);
                break;
            case KING:
                newPiece = new King(pieceColor, pieceTile);
                break;
            case PAWN:
                newPiece = new Pawn(pieceColor, pieceTile);
        }
        return newPiece;
    }


    final Color LIGHT_BROWN = new Color(153, 102, 0);
    final Color DARK_BROWN = new Color(102, 51, 0);
    final String ROOK = "ROOK";
    final String KNIGHT = "KNIGHT";
    final String BISHOP = "BISHOP";
    final String QUEEN = "QUEEN";
    final String KING = "KING";
    final String PAWN = "PAWN";
    final String WHITE = "WHITE";
    final String BLACK = "BLACK";
}