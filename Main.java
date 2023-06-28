import boardgame.*;
import chess.*;
import app.*;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main{
	public static void main(String[] args){
		ChessMatch match = new ChessMatch();
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				UI.clearScreen();
				UI.printBoard(match.getPieces());
				System.out.println("\nWitch piece to move? ");
				ChessPosition origin = UI.readChessPosition(sc);

				System.out.println("\nMove to where? ");
				ChessPosition destiny = UI.readChessPosition(sc);

				match.performChessMove(origin, destiny);
			}catch(InputMismatchException | ChessException e){
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}

	}
}