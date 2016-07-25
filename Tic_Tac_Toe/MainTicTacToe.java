package Tic_Tac_Toe;

import java.util.Scanner;
/* This is the main class containing the main method
 * this serves the purpose of taking inputs from players 
 * and showing the moves of the players
 */
public class MainTicTacToe {
	static final int Empty = 0, Cross = 1, Naught = 2, Playing = 0,
			Cross_Win = 2, Naught_Win = 3, Draw = 1, ROW = 3, COL = 3;
	static int currentState, currentPlayer, currentRow, currentCol, playerType;
	static int myBoard[][] = new int[ROW][COL];
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		do {
			try {
				System.out.println("1 Player Game OR 2 Player Game : ");
				playerType = Integer.parseInt(scan.next());
				
			} catch (Exception e) {
				System.out.println("Not an integer value");
				System.out.println("Playing as a Single player");
				playerType = 1;
			}

		} while (playerType != 1 && playerType != 2);

		Board board = new Board();
		myBoard = board.getBoard();
		currentState = Playing;
		currentPlayer = Cross;

		do {
			takeInput(currentPlayer);
			currentState = Rules.updateMove(currentPlayer, currentRow,
					currentCol, myBoard, currentState); // changing board state
														// and getting updated
														// state as a return
														// value
			DisplayBoard.printMove(myBoard);

			// print if game is ended
			if (currentState == Cross_Win) {
				System.out.println("Cross Win");
			} else if (currentState == Naught_Win) {
				System.out.println("Naught Win");
			} else if (currentState == Draw) {
				System.out.println("Draw");
			}

			currentPlayer = (currentPlayer == Cross ? Naught : Cross);
		} while (currentState == Playing);

	}

	/**
	 * This method will ask for matrix position to the current player
	 * 
	 * @param currPlayer
	 */
	static void takeInput(int currPlayer) {

		if (playerType == 2) {
			boolean inValid = false;
			do {
				inValid = false;
				if (currPlayer == Cross) {
					System.out
							.print("Player 'X' Enter Position from [1-3] [1-3] : ");
				} else {
					System.out
							.print("Player 'O' Enter Position from [1-3] [1-3] : ");
				}

				currentRow = scan.nextInt() - 1;
				currentCol = scan.nextInt() - 1;
				inValid = Rules.checkMove(currentRow, currentCol, myBoard,
						currPlayer);

			} while (inValid);
		} else {
			boolean inValid = false;
			do {
				inValid = false;
				if (currPlayer == Cross) {
					System.out
							.print("Player 'X' Enter Position from [1-3] [1-3] : ");
					currentRow = scan.nextInt() - 1;
					currentCol = scan.nextInt() - 1;
				} else {
					currentRow = (int) (Math.random() * (3 - 0));
					currentCol = (int) (Math.random() * (3 - 0));
				}
				inValid = Rules.checkMove(currentRow, currentCol, myBoard,
						currPlayer);
			} while (inValid);
		}
	}
}
