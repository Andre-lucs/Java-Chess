package chess;

import boardgame.Position;

public class ChessPosition{
	private char collum;
	private int row;

	public ChessPosition(char collum, int row){
		if(collum < 'a' || collum > 'h' || row < 1 || row > 8){
			throw new ChessExeption("Invalid ChessPosition it should be around a1 and h8.");
		}
		this.collum = collum;
		this.row = row;
	}

	public char getCollum(){
		return collum;
	}
	public int getRow(){
		return row;
	}

	public Position toPosition(){
		return new Position(8 - row, ((int)collum - 'a'));
	}

	public static ChessPosition fromPosition(Position position){
		return new ChessPosition((char)('a' - position.getCollum()), 8 - position.getRow());
	}

	@Override
	public String toString(){
		return "" + collum + row;
	}

}