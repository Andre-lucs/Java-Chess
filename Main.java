import boardgame.*;
import chess.*;
import app.*;

public class Main{
	public static void main(String[] args){
		ChessMatch match = new ChessMatch();
		UI.printBoard(match.getPieces());
	}
}