package chess;

import boardgame.Board;
import boardgame.Piece;

public class ChessMatch{
	private Board board;

	public ChessMatch(){
		this.board = new Board(8, 8);
	}

	public ChessPiece[][] getPieces(){
		ChessPiece[][] table = new ChessPiece[board.getBounds().getRow()][board.getBounds().getCollum()];
		Piece[][] pt = board.getPieces();
		for(int i = 0; i < board.getBounds().getRow(); i++){
			for(int j = 0; j < board.getBounds().getCollum(); j++){
				table[i][j] = (ChessPiece) pt[i][j];
			}
		}
		return table;
	}
	
}