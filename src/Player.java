import java.util.ArrayList;

/**
 * Player class that represents a player in a game of chess
 */
public class Player
{
    private String name;
    private String playerColor;
    private ArrayList<Piece> pieces;

    public Player(String name, String playerColor, ArrayList<Piece> pieces)
    {
        this.name = name;
        this.playerColor = playerColor;
        this.pieces = pieces;
    }

    public String getName(){
        return this.name;
    }

    public String getPlayerColor(){
        return this.playerColor;
    }

    public ArrayList<Piece> getPieces(){
        return this.pieces;
    }
}