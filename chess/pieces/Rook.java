package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{
	public Rook(Board board, Color color){
		super(board, color);
	}

	@Override
	public String toString(){
		return "R";
	}

	@Override
	protected boolean[][] possibleMoves() {
		boolean[][] mat =new boolean[getBoard().getBounds().getRow()][getBoard().getBounds().getCollum()];

		Position pos = new Position(0,0);
		//up
		pos.setValues(position.getRow()-1, position.getCollum());
		while(getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)){
			mat[pos.getRow()][pos.getCollum()] = true;
			pos.setRow(pos.getRow()-1);
		}
		if(getBoard().positionExists(pos) && isThereOpponentPiece(pos)){
			mat[pos.getRow()][pos.getCollum()] = true;
		}
		//down
		pos.setValues(position.getRow()+1, position.getCollum());
		while(getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)){
			mat[pos.getRow()][pos.getCollum()] = true;
			pos.setRow(pos.getRow()+1);
		}
		if(getBoard().positionExists(pos) && isThereOpponentPiece(pos)){
			mat[pos.getRow()][pos.getCollum()] = true;
		}
		//left
		pos.setValues(position.getRow(), position.getCollum()-1);
		while(getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)){
			mat[pos.getRow()][pos.getCollum()] = true;
			pos.setCollum(pos.getCollum()-1);
		}
		if(getBoard().positionExists(pos) && isThereOpponentPiece(pos)){
			mat[pos.getRow()][pos.getCollum()] = true;
		}
		//right
		pos.setValues(position.getRow(), position.getCollum()+1);
		while(getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)){
			mat[pos.getRow()][pos.getCollum()] = true;
			pos.setCollum(pos.getCollum()+1);
		}
		if(getBoard().positionExists(pos) && isThereOpponentPiece(pos)){
			mat[pos.getRow()][pos.getCollum()] = true;
		}
		return mat;
	}
}