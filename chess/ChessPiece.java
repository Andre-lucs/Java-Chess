package chess;

import boardgame.Piece;
import boardgame.Board;
import boardgame.Position;

public abstract class ChessPiece extends Piece{

	private Color color;
	
	public ChessPiece(Board board, Color color){
		super(board);
		this.color = color;
	}

	public Color getColor(){
		return this.color;
	}

	protected boolean isThereOpponentPiece(Position position){
		return ((ChessPiece) getBoard().getPiece(position)).getColor() != color;
	}
}