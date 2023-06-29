package boardgame;

public abstract class Piece{
	protected Position position;
	private final Board board;

	public Piece(Board board){
		this.board = board;
		this.position = null;
	}

	protected Board getBoard(){
		return this.board;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	protected abstract boolean[][] possibleMoves();
	public boolean possibleMove(Position position){
		return possibleMoves()[position.getRow()][position.getCollum()];
	}

	public boolean isThereAnyPossibleMove(){
		boolean[][] mat = possibleMoves();
		for (boolean[] booleans : mat) {
			for (int j = 0; j < mat.length; j++) {
				if (booleans[j]) return true;
			}
		}
		return false;
	}

}