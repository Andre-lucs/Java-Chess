package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.*;

public class ChessMatch{
	private Board board;

	public ChessMatch(){
		this.board = new Board(8, 8);
		initialSetup();
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

	private void initialSetup(){
		placeNewPiece( 'b', 5, new Rook(board, Color.WHITE));
		placeNewPiece( 'g', 2, new King(board, Color.BLACK));
	}

	public ChessPiece performChessMove(ChessPosition origin, ChessPosition destiny){
		Position source = origin.toPosition();
		Position target = destiny.toPosition();
		ValidateSourcePosition(source);
		ValidateTargetPosition(source, target);
		Piece capturedPiece = MakeMove(source, target);
		return (ChessPiece) capturedPiece;
	}

	private Piece MakeMove(Position origin, Position destiny){
		ChessPiece movePiece = (ChessPiece) board.getPiece(origin);
		ChessPiece capturedPiece = (ChessPiece) board.getPiece(destiny);
		if(capturedPiece != null && capturedPiece.getColor() == movePiece.getColor()) throw new ChessException("Cant eat friend pieces.");
		board.removePiece(movePiece);
		board.removePiece(capturedPiece);
		board.placePiece(movePiece, destiny);
		return capturedPiece;
	}

	public void placeNewPiece(char collum, int row, ChessPiece piece){
		board.placePiece(piece, new ChessPosition(collum, row).toPosition());
	}

	private void ValidateSourcePosition(Position pos){
		if(!board.thereIsAPiece(pos)) throw new ChessException("There is no piece on source position.");
		if(!board.getPiece(pos).isThereAnyPossibleMove()) throw new ChessException("The piece is locked.");
	}

	private void ValidateTargetPosition(Position origin, Position target){
		if(!board.getPiece(origin).possibleMove(target)) throw new ChessException("The chosen piece cant move to that position");
	}
}