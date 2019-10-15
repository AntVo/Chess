
/**
Class to manage and handle game logic for a Chess game
*/
public class GameManager
{   


    public static void main(String[] args)
    {
        Player playerOne = new Player("Player One", WHITE );
        Player playerTwo = new Player("Player Two", BLACK );

        ChessBoard chessBoard new ChessBoard();
        chessBoard.intializeChessBoard();
        chessBoard.initializeChessPieces();

    }



    // Enums
    private static final String BLACK = "BLACK";
    private static final String WHITE = "WHITE";
}