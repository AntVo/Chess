import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * Chessboard is represented by a Matrix of Tile objects.
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
    private Player playerOne;
    private Player playerTwo;

    public ChessBoard(Dimension boardSize, Player p1, Player p2)
    {
        super();
        this.chessBoard = new Tile[8][8];
        this.boardSize = boardSize;
        this.playerOne = p1;
        this.playerTwo = p2;
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
                Tile tile = new Tile( new BorderLayout(), i, j);

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
            this.createPiece(chessRow[i], BLACK, tileToAddPiece, playerTwo);
        }

        // (2) Set the row of black pawns
        row = 1;
        for (int i = 0; i < 8; i++){
            Tile tileToAddPiece = this.chessBoard[row][i];
            this.createPiece(PAWN, BLACK, tileToAddPiece, playerTwo);
        }

        // (3) Set the row of white pawns
        row = 6;
        for (int i = 0; i < 8; i++){
            Tile tileToAddPiece = this.chessBoard[row][i];
            this.createPiece(PAWN, WHITE, tileToAddPiece, playerOne);
        }        

        // (4) Set the row of white pieces
        row = 7;
        for (int i = 0; i < 8; i++){
            Tile tileToAddPiece = this.chessBoard[row][i];
            this.createPiece(chessRow[i], WHITE, tileToAddPiece, playerOne);
        }        
    }

    public Piece createPiece(String pieceName, String pieceColor, Tile pieceTile, Player player){
        Piece newPiece = null;
        String imgLocation = null;
        switch(pieceName){
            case ROOK:
                imgLocation = pieceColor == WHITE ? WHITE_ROOK_PNG : BLACK_ROOK_PNG;
                newPiece = new Rook(imgLocation, pieceColor, pieceTile);
                break;
            case KNIGHT:
                imgLocation = pieceColor == WHITE ? WHITE_KNIGHT_PNG : BLACK_KNIGHT_PNG;
                newPiece = new Knight(imgLocation, pieceColor, pieceTile);
                break;
            case BISHOP:
                imgLocation = pieceColor == WHITE ? WHITE_BISHOP_PNG : BLACK_BISHOP_PNG;
                newPiece = new Bishop(imgLocation, pieceColor, pieceTile);
                break;
            case QUEEN:
                imgLocation = pieceColor == WHITE ? WHITE_QUEEN_PNG : BLACK_QUEEN_PNG;
                newPiece = new Queen(imgLocation, pieceColor, pieceTile);
                break;
            case KING:
                imgLocation = pieceColor == WHITE ? WHITE_KING_PNG : BLACK_KING_PNG;
                // King needs to know the opponent player to do check calculations
                Player oppPlayer = player == playerOne ? playerTwo : playerOne;
                newPiece = new King(imgLocation, pieceColor, pieceTile, oppPlayer);
                break;

            case PAWN:
                imgLocation = pieceColor == WHITE ? WHITE_PAWN_PNG : BLACK_PAWN_PNG;
                newPiece = new Pawn(imgLocation, pieceColor, pieceTile);
        }
        player.addPiece(newPiece);
        return newPiece;
    }
    
    public Tile getTileAt(int x, int y)
    {
    	int chessX = y / (boardSize.width / 8);
    	int chessY = x / (boardSize.height / 8);
    	System.out.println("[" + chessX + ", " + chessY + "]");
    	return chessBoard[chessX][chessY]; 
    }

    public Tile getTileAtLocation(int row, int col){
        return this.chessBoard[row][col];
    }

    public Piece getPieceAtLocation(int row, int col){
        return this.getTileAtLocation(row, col).getPiece();
    }   

    public void highlightAvailableMoves(Piece piece){
        ArrayList<Tile> availableMoves = piece.getValidMoves(this);
        for (Tile tile : availableMoves){
            tile.setColor(LIGHT_GREEN);
        }
    }

    public void removeAllHighlights(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                this.chessBoard[i][j].setBackground( i % 2 == j % 2 ? DARK_BROWN : LIGHT_BROWN);
            }
        }
    }

    final Color LIGHT_BROWN = new Color(153, 102, 0);
    final Color DARK_BROWN = new Color(102, 51, 0);
    final Color LIGHT_GREEN = new Color(50, 150, 50);



    private static final String ROOK = "ROOK";
    private static final String KNIGHT = "KNIGHT";
    private static final String BISHOP = "BISHOP";
    private static final String QUEEN = "QUEEN";
    private static final String KING = "KING";
    private static final String PAWN = "PAWN";
    private static final String WHITE = "WHITE";
    private static final String BLACK = "BLACK";
    private static final String WHITE_BISHOP_PNG = "../assets/pieces/white_bishop.png";
    private static final String BLACK_BISHOP_PNG = "../assets/pieces/black_bishop.png";
    private static final String WHITE_KNIGHT_PNG = "../assets/pieces/white_knight.png";
    private static final String BLACK_KNIGHT_PNG ="../assets/pieces/black_knight.png";
    private static final String WHITE_ROOK_PNG = "../assets/pieces/white_rook.png";
    private static final String BLACK_ROOK_PNG = "../assets/pieces/black_rook.png";
    private static final String WHITE_KING_PNG = "../assets/pieces/white_king.png";
    private static final String BLACK_KING_PNG = "../assets/pieces/black_king.png";
    private static final String BLACK_QUEEN_PNG = "../assets/pieces/black_queen.png";
    private static final String WHITE_QUEEN_PNG = "../assets/pieces/white_queen.png";
    private static final String WHITE_PAWN_PNG = "../assets/pieces/white_pawn.png";
    private static final String BLACK_PAWN_PNG = "../assets/pieces/black_pawn.png";

}