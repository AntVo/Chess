import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
 
/**
Class to manage and handle game logic for a Chess game
*/
public class GameManager extends JFrame implements MouseListener, MouseMotionListener
{   
    // The entire game is drawn on top of this layeredPanel
	Player currentPlayer = null;
    JLayeredPane layeredPane;
    ChessBoard chessBoard;
    Piece selectedPiece = null;
    Tile selectedTile = null;
    Player playerOne = new Player("Player One", WHITE );
    Player playerTwo = new Player("Player Two", BLACK );

    public void initializeGame(){
        Dimension boardSize = new Dimension(600, 600);

        this.graphicsSetup(boardSize);

        // Initialize Chessboard
        chessBoard = new ChessBoard(boardSize, playerOne, playerTwo);
        chessBoard.initializeChessBoard();
        chessBoard.initializeChessPieces();
        currentPlayer = playerOne;
        // Render the chessBoard by adding it to our JFrame
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
    }

    // Perform necessary actions to setup a jframe to render
    // the game.
    public void graphicsSetup(Dimension boardSize){
        // Initialize Layered Pane where everything will be drawn
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);

        // Listen to Mouse actions
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);
        
        // More configuration
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setResizable(true);
        this.setLocationRelativeTo( null );
        this.setVisible(true);
    }

    /*
     *  if tile is clicked, check piece color, check turn,
     *   get options for movement
     *  if tile was clicked with no piece on it, check if a piece was
     *      clicked before and move it if valid
     *  if tile is empty, do nothing
     */
    public void mousePressed(MouseEvent e)
    {   
        Component clickedElement = chessBoard.findComponentAt(e.getX(), e.getY());
        
        // Handle user clicking on a piece
        if (clickedElement instanceof Piece){
            Piece clickedPiece =  (Piece)clickedElement;
            selectedTile = clickedPiece.getTile();

            // Handle attacks (when):
            //   (1) Player has already selected a piece 
            //   (2) Player clicks on a piece that is not theirs
            if (this.selectedPiece != null){
                if(clickedPiece.color != currentPlayer.getPlayerColor())
                {
                    if (this.selectedPiece.getValidMoves(chessBoard).contains(selectedTile)){                        
                        Player opponent = currentPlayer == playerOne ? playerTwo : playerOne;
                        opponent.removePiece(clickedPiece);
                        selectedTile.removePiece();
                        selectedPiece.movePiece(selectedTile);
                        chessBoard.repaint();

                        this.checkAndMakePromotions(selectedPiece);

                        
                        this.switchPlayers();
                        selectedPiece = null;
                        selectedTile = null;
                        chessBoard.removeAllHighlights();
                        this.makeBoardstateChecks();
                        chessBoard.repaint();

                    }
                }
                return;
            }

            if (clickedPiece.color == currentPlayer.getPlayerColor()){
                this.selectedPiece = clickedPiece;
                chessBoard.highlightAvailableMoves(clickedPiece);
                selectedPiece.getTile().highlightSelf();
            }

            return;
        }

        // Handle user clicked on an empty tile
        if (clickedElement instanceof Tile){
            chessBoard.removeAllHighlights();
            selectedTile = (Tile)clickedElement;

            // Handle moving a piece:
            if (this.selectedPiece != null){
                // The piece is the current players color
                if (this.selectedPiece.getColor() == currentPlayer.getPlayerColor()){
                    

                    // Otherwise, the move is a valid one
                    if (this.selectedPiece.getValidMoves(chessBoard).contains(selectedTile)){

                        // Validate that the move would put the opponent out of check
                        Tile originalTile = this.selectedPiece.getTile();
                        this.selectedPiece.movePiece(selectedTile);  
                        this.checkAndMakePromotions(selectedPiece);

                        
                        if (chessBoard.isChecked(currentPlayer)){
                            // Player is still checked after the move. Don't allow it
                            // (by reverting the move)
                            this.selectedPiece.movePiece(originalTile);                            
                            selectedPiece = null;
                            selectedTile = null;
                            return; // Move wouldnt put opponent out of check. Ignore
                        }
    

                        System.out.println("Moving piece");
                        // Selected a piece and clicked on empty tile -> Move piece to that tile
                        this.selectedPiece.movePiece(selectedTile);  
                        this.checkAndMakePromotions(selectedPiece);
    
                    
                        
                        this.selectedPiece = null;
                        this.switchPlayers();
                        this.makeBoardstateChecks();
                    }
                }
            }
        }


        // Player clicking did not do anything. Reset state
        selectedPiece = null;
        selectedTile = null;

        // System.out.println("Current Player: ");
        // System.out.println(currentPlayer.getPlayerColor());
    }

    public void makeBoardstateChecks(){
        playerOne.isChecked = chessBoard.isChecked(playerOne) ? true : false;
        if (playerOne.isChecked){
            playerOne.getKing().getTile().setColor(RED);
        }
        else {
            playerOne.getKing().getTile().setDefaultColor();
        }

        playerTwo.isChecked = chessBoard.isChecked(playerTwo) ? true : false;
        if (playerTwo.isChecked){
            playerTwo.getKing().getTile().setColor(RED);
        } else {
            playerTwo.getKing().getTile().setDefaultColor();
        }

        if (chessBoard.isCheckmated(playerOne)){
            System.out.println("Player Two Wins");
            // TODO: Player two wins!
        }
        if (chessBoard.isCheckmated(playerTwo)){
            System.out.println("Player One Wins");
            // TODO: Player one wins!
        }
    }

    public void checkAndMakePromotions(Piece piece){
        if(piece instanceof Pawn)
        {
            String color = currentPlayer.getPlayerColor();
            if((color == "BLACK" && selectedTile.getRow() == 7) ||
                (color == "WHITE" && selectedTile.getRow() == 0))
            {
                currentPlayer.removePiece(piece);
                selectedTile.removePiece();
                Piece queen = (Queen)chessBoard.createPiece("QUEEN", color, selectedTile, currentPlayer);
                selectedTile.add(queen);
                queen.movePiece(selectedTile);
            }
        }
    }

    /*
    **  Move the chess piece around. Bonus if we have time. 
    */
    public void mouseDragged(MouseEvent e){}

    /*
    **  Drop the chess piece back onto the chess board
    *   Arman - Do we even need this? cant we just click, and click again?
    *   i.e.    We could probably just use mouseClicked
    *  maybe we can implement both later, if we have time
    */
    public void mouseReleased(MouseEvent e){
    }
    public void mouseClicked(MouseEvent e){
    }
    public void mouseMoved(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e){
    }
    public void mouseExited(MouseEvent e){
    }


    public void switchPlayers(){
        this.currentPlayer = currentPlayer == playerOne ? playerTwo : playerOne;
    }

    public static void main(String[] args)
    {
        GameManager gameManager = new GameManager();
        gameManager.initializeGame();
    }


    // ENUMS
    private static final String BLACK = "BLACK";
    private static final String WHITE = "WHITE";
    private static final Color RED = new Color(180, 40, 40);

}