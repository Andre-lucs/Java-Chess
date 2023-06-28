package app;

import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI{

	public static final String TEXT_RESET = "\u001B[0m";
	public static final String TEXT_RED = "\u001B[31m";
	public static final String TEXT_BLACK = "\u001B[30m";
	public static final String TEXT_GREEN = "\u001B[32m";
	public static final String TEXT_BLUE = "\u001B[34m";
	public static final String TEXT_PURPLE = "\u001B[35m";
	public static final String TEXT_CYAN = "\u001B[36m";
	public static final String TEXT_YELLOW = "\u001B[33m";
	public static final String TEXT_WHITE = "\u001B[37m";

	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	public static ChessPosition readChessPosition(Scanner sc){
		try {
			String pos = sc.nextLine();
			char collum = pos.charAt(0);
			int row = Integer.parseInt(pos.substring(1));
			return new ChessPosition(collum, row);
		}catch (RuntimeException e){
			throw new InputMismatchException("Invalid chess position.");
		}
	}
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
			System.out.print(((piece.getColor() == Color.WHITE) ? TEXT_WHITE : TEXT_YELLOW ) + piece + TEXT_RESET);
		}
		System.out.print(" ");
	}

	public static void clearScreen(){
		System.out.println("\033[H\033[2J");
		System.out.flush();
	}
}