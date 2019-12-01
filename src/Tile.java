import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * Represents a tile on a chessboard. 
 * 
 */
public class Tile extends JPanel
{
	//Defined variables.
    public Piece piece; // Null if empty
    private String tileColor; 
    private String notation = "";
    public String WHITE = "white";
    public String BLACK = "black";
    private int row;
    private int col;

    public Tile(BorderLayout borderLayout)
    {
        super(borderLayout);
        this.piece = null;
    }
        
    public Tile(BorderLayout borderLayout, String tileColor)
    {
        super(borderLayout);
        this.piece = null;
        this.tileColor = tileColor;
    }

    //Constructor
    public Tile(BorderLayout borderLayout, int row, int col)
    {

        this.piece = null;
        this.row = row;
        this.col = col;

        // TODO: please comment what this does
        this.notation = Character.toString((char)(97+row));
        this.notation += (char)(col+48+1);
    }

    public int getRow(){
        return this.row;
    }

    public int getCol(){
        return this.col;
    }

    // Returns color
    public String getColor()
    {
    	return this.tileColor;
    }
    
    public void setColor(Color color)
    {
       this.setBackground(color);
    }

    //Returns a removed piece.
    public Piece removePiece()
    {
        Piece p = this.piece;
        this.remove(this.piece);
        this.piece = null;
        return p;
    }
    
    //Sets a piece.
    public void setPiece(Piece p)
    {
    	this.piece = p;
    }

    public Piece getPiece(){
        return this.piece;
    }

    public void highlightSelf(){
        this.setBackground(new Color(80, 80, 200));
    }

    //Checks if there is a piece present.
    public boolean isEmpty(){
        return this.piece == null;
    }

    // Boolean check if this tile is under attack by opposite player
    public boolean isUnderAttack(ChessBoard chessBoard, Player opposingPlayer){
        ArrayList<Piece> enemyPieces = opposingPlayer.getPieces();
        for (Piece enemyPiece : enemyPieces){
            if (enemyPiece instanceof King){
                // TODO: handle edge case, so we dont get recursive loop
                continue;
            }
            if (enemyPiece instanceof Pawn){
                // Handle edge case where pawns would only be able to attack 
                // the diagonal piece if the King was to move there
                Pawn enemyPawn = (Pawn)enemyPiece;
                if (enemyPawn.getAttackMoves(chessBoard).contains(this)){
                    return true;
                }
            }
            if (enemyPiece.getValidMoves(chessBoard).contains(this)){
                return true;
            }
        }
        return false;
    }
}
