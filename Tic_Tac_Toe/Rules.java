package Tic_Tac_Toe;

public class Rules {
	static final int Empty= 0, Cross= 1, Naught= 2, Playing= 0, 
			Cross_Win= 2, Naught_Win= 3, Draw= 1, ROW= 3, COL= 3;
	
	/**
	 * It will check if player's move is correct or not
	 * @param currentRow
	 * @param currentCol
	 * @param board
	 * @param currPlayer
	 * @return Returns true or false according to the move
	 */
	public static boolean checkMove(int currentRow, int currentCol, int board[][], int currPlayer){
		if(currentRow >= 0 && currentRow < ROW && currentCol >= 0 && 
				currentCol < COL && board[currentRow][currentCol] == Empty){
			board[currentRow][currentCol]= currPlayer;
			return false;
		}
		else{
			if(currPlayer == 1)
			System.out.println("Enter a Valid move");
			return true;
		}
	}
	
	/**
	 * This will update the current state of the game
	 * @param currPlayer
	 * @param cRow
	 * @param cCol
	 * @param myBoard
	 * @param currentState
	 * @return It returns the current state
	 */
		static int updateMove(int currPlayer, int cRow, int cCol, int myBoard[][], int currentState){
			if(hasWon(currPlayer, cRow, cCol, myBoard)){
				return (currPlayer == Cross ? Cross_Win : Naught_Win);
			}
			else if(isDraw(myBoard)){
				return Draw;
			}else{
				return Playing;
			}
		}
		
		static boolean hasWon(int currPlayer, int cRow, int cCol, int myBoard[][]){
			return(myBoard[cRow][0] == currPlayer && myBoard[cRow][1] == currPlayer && myBoard[cRow][2] == currPlayer 
					|| myBoard[0][cCol] == currPlayer && myBoard[1][cCol] == currPlayer && myBoard[2][cCol] == currPlayer
					|| cRow == cCol && myBoard[0][0] == currPlayer && myBoard[1][1] == currPlayer && myBoard[2][2] == currPlayer 
					|| myBoard[0][2] == currPlayer && myBoard[1][1] == currPlayer && myBoard[2][0] == currPlayer );
			}
		
		static boolean isDraw(int myBoard[][]){
			for(int row= 0; row < ROW; row++){
				for(int col= 0; col < COL; col++){
					if(myBoard[row][col] == Empty){
						return false;
					}
				}
			}
			return true;
		}
}