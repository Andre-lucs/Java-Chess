package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{
	public King(Board board, Color color){
		super(board, color);
	}

	@Override
	public String toString(){
		return "K";
	}

	@Override
	protected boolean[][] possibleMoves() {
		boolean[][] mat =new boolean[getBoard().getBounds().getRow()][getBoard().getBounds().getCollum()];
		return mat;
	}
}