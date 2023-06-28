package boardgame;

public class Board{
	private final Position size;
	private Piece[][] pieces; 

	public Board(int rows, int collums){
		if(rows < 1 || collums < 1) throw new BoardExeption("Error creating board: there must be at least 1 row and 1 collum");
		size = new Position(rows, collums);
		this.pieces = new Piece[rows][collums];
	}

	public Position getBounds(){ return size; }

	public Piece[][] getPieces(){ return pieces; }

	public void placePiece(Piece piece, Position pos){
		if(thereIsAPiece(pos)) throw new BoardExeption("There is a piece on the position already.");
		pieces[pos.getRow()][pos.getCollum()] = piece;
		piece.position = pos;
	}

	public void removePiece(Piece piece){
		if(piece == null) return;
		pieces[piece.position.getRow()][piece.position.getCollum()] = null;
		piece.position = null;
	}
	public Piece removePiece(Position pos){
		if(!positionExists(pos)) throw new BoardExeption("Position not on board");
		Piece aux = null;
		if(thereIsAPiece(pos)) {
			aux = getPiece(pos);
			removePiece(aux);
		}
		return aux;
	}

	public Piece getPiece(Position position){
		if(!positionExists(position)) throw new BoardExeption("Position not on board");
		return this.pieces[position.getRow()][position.getCollum()];
	}

	public boolean positionExists(Position position){
		return this.positionExists(position.getRow(), position.getCollum());
	}

	public boolean positionExists(int row, int collum){
		return row >= 0 && row < size.getRow() && collum >= 0 && collum < size.getCollum();
	}

	public boolean thereIsAPiece(Position position){
		return getPiece(position) != null;
	}
}