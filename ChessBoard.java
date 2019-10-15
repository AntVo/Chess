import java.util.ArrayList;

/**
 * Chessboard is represented by a a Matrix of Tile objects
 */
public class ChessBoard
{
    private Tile[][] chessBoard;

    public ChessBoard()
    {
        this.chessBoard = null;
    }


    public Tile[][] getChessBoard(){
        return this.chessBoard;
    }

    /** 
     * Initializes the Chessboard by creating Tiles, alternating colors 
     * between white and black.
     * End result should be a matrix like:
     */
    public void initializeChessBoard()
    {   
        String tileColor = "WHITE";
        for (int i = 0; i < 8; i++){
            Tile[] boardRow = new Tile[8];
            for (int j = 0; j < 8; j++){
                Tile tileToAdd = new Tile(tileColor);
                boardRow[j] = tileToAdd;

                if (tileColor == "WHITE") tileColor = "BLACK";
                else tileColor = "WHITE";
            }
            this.chessBoard.push(boardRow);
        }
    }

    public void initializeChessPieces(){

    }


    public printBoard(){
        // TODO
    }

}