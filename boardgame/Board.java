package boardgame;

public class Board{
	private Position size;
	private Piece[][] pieces; 

	public Board(int rows, int collums){
		size = new Position(rows, collums);
		this.pieces = new Piece[rows][collums];
	}

	public Position getBounds(){ return size; }

	public Piece[][] getPieces(){ return pieces; }

}