package app;

import chess.ChessPiece;

public class UI{
	public static void printBoard(ChessPiece[][] pieces){
		int n = pieces.length;
		for(int i = 0; i < pieces.length; i++){
			System.out.print((n--) + " ");
			for(int j = 0; j < pieces.length; j++){
				printPiece(pieces[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}

	public static void printPiece(ChessPiece piece){
		if(piece == null){
			System.out.print("-");
		}
		else{
			System.out.print(piece);
		}
		System.out.print(" ");
	}
}