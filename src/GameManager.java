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


    // Create LayeredPane on which graphiss will be draw.
    // Add MouseListeners to listen for mouse events 
    public void initializeGame(Dimension boardSize){
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);
    }

    // Given the current state of the Chessboard, Player, and 
    // Pieces, redraw the board.
    // Render should be called anytime the state of the board
    public void render(){
        Dimension boardSize = new Dimension(600, 600);

        //  Use a Layered Pane for this this application


          //Add a chess board to the Layered Pane 
        initializeGame(boardSize);
        chessBoard = new ChessBoard(boardSize);
        chessBoard.initializeChessBoard();
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setResizable(true);
        this.setLocationRelativeTo( null );
        this.setVisible(true);
    }


    public void mousePressed(MouseEvent e){
    }
    public void mouseClicked(MouseEvent e) {
    }
    public void mouseMoved(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e){
    }
    public void mouseExited(MouseEvent e) {
    }
    public void mouseDragged(MouseEvent me) {
    }
    public void mouseReleased(MouseEvent e) {
    }


    public static void main(String[] args)
    {
        Player playerOne = new Player("Player One", WHITE );
        Player playerTwo = new Player("Player Two", BLACK );

        GameManager gameManager = new GameManager();
        gameManager.render();
        gameManager.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
        gameManager.pack();
        gameManager.setResizable(true);
        gameManager.setLocationRelativeTo( null );
        gameManager.setVisible(true);
    }




    // Enums
    private static final String BLACK = "BLACK";
    private static final String WHITE = "WHITE";
}