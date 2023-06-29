package boardgame;

public class Position{
	private int row;
	private int collum;
	
	public Position(){
		row = collum = 1;
	}
	public Position(int row, int collum){
		this.row = row;
		this.collum = collum;
	}

	public int getRow(){
		return this.row;
	}
	public void setRow(int row){
		this.row = row;
	}
	public int getCollum(){
		return this.collum;
	}
	public void setCollum(int collum){
		this.collum = collum;
	}

	public void setValues(int row, int collum){
		this.row = row;
		this.collum = collum;
	}
	@Override
	public String toString(){
		return "Row: "+this.row+". Collum: "+this.collum;
	}
}