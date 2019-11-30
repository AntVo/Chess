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

    // 
    public void initializeGame(){
        Dimension boardSize = new Dimension(600, 600);

        this.graphicsSetup(boardSize);

        // Initialize Chessboard
        chessBoard = new ChessBoard(boardSize);
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
    **  Add the selected chess piece to the dragging layer so it can be moved
    */
    public void mousePressed(MouseEvent e)
    {   
        Component clickedElement = chessBoard.findComponentAt(e.getX(), e.getY());
        
        // Handle user clicking on a piece
        if (clickedElement instanceof Piece){
            Piece piece =  (Piece)clickedElement;

            // Handles when:
            //   - Player has already selected a piece 
            //   - Player clicks on a piece that is not theirs
            if (this.selectedPiece != null){
                if(piece.color != currentPlayer.getPlayerColor())
                {
                    selectedTile = piece.getTile();
                    selectedTile.removePiece();
                    selectedPiece.move(selectedTile);
                    chessBoard.repaint();
                    if(currentPlayer.getPlayerColor() == WHITE)
                    {
                        currentPlayer = playerTwo;
                    }
                    else
                    {
                        currentPlayer = playerOne;
                    }
                    selectedPiece = null;
                    selectedTile = null;
                }
            }


            // TODO: Handle when user has not yet selected a piece and clicks on a piece
            this.selectedPiece = piece;
            chessBoard.highlightAvailableMoves(piece);
            return;
        }

        // Handle user clicked on an empty tile
        if (clickedElement instanceof Tile){
            chessBoard.removeAllHighlights();

            // Handle moving a piece:
            if (this.selectedPiece != null){
                System.out.println("Moving piece");
                // Selected a piece and clicked on empty tile -> Move piece to that tile
                Tile clickedTile = (Tile)clickedElement;
                this.selectedTile = clickedTile;
                this.selectedPiece.movePiece(clickedTile);  
                this.selectedPiece = null;
                
                if(currentPlayer.getPlayerColor() == WHITE){
                    currentPlayer = playerTwo;
                }
                else {
                    currentPlayer = playerOne;
                }
            }
        }
    }

    /*
    **  Move the chess piece around. Bonus if we have time. 
    */
    public void mouseDragged(MouseEvent e){}

    /*
    **  Drop the chess piece back onto the chess board
    * 	Arman - Do we even need this? cant we just click, and click again?
    *  	i.e.	We could probably just use mouseClicked
    *  maybe we can implement both later, if we have time
    */
    public void mouseReleased(MouseEvent e){}

    /*
     *  if tile is clicked, check piece color, check turn,
     *   get options for movement
     *  if tile was clicked with no piece on it, check if a piece was
     *  	clicked before and move it if valid
     *  if tile is empty, do nothing
     */
    public void mouseClicked(MouseEvent e) {
    }
    public void mouseMoved(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e){
    }
    public void mouseExited(MouseEvent e) {
    }

    public static void main(String[] args)
    {
        

        GameManager gameManager = new GameManager();
        gameManager.initializeGame();
    }


    // Enums
    private static final String BLACK = "BLACK";
    private static final String WHITE = "WHITE";
}