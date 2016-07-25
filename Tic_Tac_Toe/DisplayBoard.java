package Tic_Tac_Toe;

public class DisplayBoard {
	static final int ROW= 3, COL= 3;

	/**
	 * It will print board state after every move
	 * @param board
	 */
	static void printMove(int board[][]){
		for(int row= 0; row < ROW; row++){
			for (int col= 0; col < COL; col++){
				printCell(board[row][col]);	
				if(col != COL-1){
					System.out.print("|");
				}
			}
			if(row != ROW-1){
				System.out.println("");
			}
		}
		System.out.println("");
		System.out.println("______");
	}
	
	static void printCell(int placeValue){
		switch(placeValue){
		case 0: System.out.print(" "); 
		break;
		case 1: System.out.print("X");
		break;
		case 2: System.out.print("O"); 
		break;
		default:
			System.out.println("Wrong Place Value");
		}
	}
}