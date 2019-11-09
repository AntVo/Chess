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
    private Piece piece; // Null if empty
    private String tileColor; 
    private int x;
    private int y;

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

    public boolean isEmpty(){
        return this.piece == null;
    }
}