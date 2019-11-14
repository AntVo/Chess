import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
 
/**
Class to manage and handle game logic for a Chess game
*/
public class GameManager extends JFrame implements MouseListener, MouseMotionListener
{   
    // The entire game is drawed on top of this layeredPane
    JLayeredPane layeredPane;
    ChessBoard chessBoard;


    // 
    public void initializeGame(){
        Dimension boardSize = new Dimension(600, 600);

        this.graphicsSetup(boardSize);

        // Initialize Chessboard
        chessBoard = new ChessBoard(boardSize);
        chessBoard.initializeChessBoard();
        chessBoard.initializeChessPieces();
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
        Component chessPiece =  chessBoard.findComponentAt(e.getX(), e.getY());

        if (!(chessPiece instanceof Piece)) return;
        System.out.println("===============");
        System.out.println("Clicked on a chess piece! Inside GameManager.mousePressed()");
        System.out.println("Piece: ");
        System.out.println(chessPiece);
        // System.out.println("Piece's Tile: ");
        // System.out.println(chessPiece.getTile());
        System.out.println("Now we actually need to implement some functionality");
        System.out.println("===============");
    }

    /*
    **  Move the chess piece around
    */
    public void mouseDragged(MouseEvent e){}

    /*
    **  Drop the chess piece back onto the chess board
    */
    public void mouseReleased(MouseEvent e){}

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
        Player playerOne = new Player("Player One", WHITE );
        Player playerTwo = new Player("Player Two", BLACK );

        GameManager gameManager = new GameManager();
        gameManager.initializeGame();
    }


    // Enums
    private static final String BLACK = "BLACK";
    private static final String WHITE = "WHITE";
}