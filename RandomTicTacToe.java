
/**
 * @author Sonya Cates <scates@rwu.edu>
 * @date Aug 19, 2019
 */

import java.util.Random;
import java.util.Scanner;

public class RandomTicTacToe {
	public static final int ROWS = 3; // tictactoe game will always have 3 rows
	public static final int COLUMNS = 3; // tictactoe game will always have 3 columns
	// constants to specify the players
	public static final int COMPUTER = 0;
	public static final int HUMAN = 1;
	// constants to specify the current state of the game
	public static final int TIE = 2;
	public static final int COMPUTER_WIN = 3;
	public static final int HUMAN_WIN = 4;
	public static final int IN_PROGRESS = 5;
	
	public static char[][] board = new char[ROWS][COLUMNS];// store the board as a 2D array of chars
	public static int currentPlayer = COMPUTER; // Computer is the first player
	public static char humanMarker = 'O'; // Human will play O
	public static char computerMarker = 'X'; // Computer will play X
	public static int gameState = IN_PROGRESS; // Game is initially in progress

	public static Scanner input = new Scanner(System.in);

	/**
	 * Run the game.
	 */
	public static void main(String[] args) {
		initializeBoard();
		printBoard();
		do {
			if (currentPlayer == COMPUTER) {
				computerMove();
			} else {
				humanMove();
			}
			printBoard();
			gameState = getGameState();
			takeTurn();
		} while (gameState == IN_PROGRESS);

		switch (gameState) {
		case COMPUTER_WIN:
			System.out.println("Computer Wins!");
			break;
		case HUMAN_WIN:
			System.out.println("You Win!");
			break;
		case TIE:
			System.out.println("It's a tie!");
		}
	}

	/**
	 * Determine if the game has been won or if it is still in progress.
	 * 
	 * @return
	 */
	private static int getGameState() {
		boolean haveWinner = false;
		char marker = ' ';
		// a. checks to see if someone has three in a row
		for (int i = 0; i < ROWS; i++) {
			if ((board[i][0] == board[i][1]) && (board[i][0] == board[i][2]) && (board[i][0] != ' ')) {
				haveWinner = true;
				marker = board[i][0];
			}
		}
		// b. checks if there is 3 in a column
		for (int j = 0; j < COLUMNS; j++) {
			if ((board[0][j] == board[1][j]) && (board[0][j] == board[2][j]) && (board[0][j] != ' ')) {
				haveWinner = true;
				marker = board[0][j];
			}
		}
		// c. checks for winning diaginol 
 		if ((((board[0][0] == board[1][1]) && (board[0][0] == board[2][2]))
				|| ((board[0][2] == board[1][1]) && (board[0][2] == board[2][0]))) && (board[1][1] != ' ')) {
			haveWinner = true;
			marker = board[1][1];
		}

		if (haveWinner) {
			if (marker == humanMarker) {
				return HUMAN_WIN;
			} else {
				return COMPUTER_WIN;

			}
		}
		// d. determining if there is a free spot
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLUMNS; col++) {
				if (board[row][col] == ' ') {
					return IN_PROGRESS;
				}
			}
		}
		return TIE;
	}

	/**
	 * Switch the value of currentPlayer to the other player.
	 */
	private static void takeTurn() {
		   if(currentPlayer == COMPUTER){
	         currentPlayer = HUMAN;
	         }
	       else{
	         currentPlayer = COMPUTER;
	         }
		}

	/**
	 * Generate a random computer move and update the board.
	 */
	private static void computerMove() {
		Random rand = new Random();
		int row, col;
		do {
			col = rand.nextInt(COLUMNS);
			row = rand.nextInt(ROWS);
		} while (!isValidMove(row, col));

		board[row][col] = computerMarker;
	}

	/**
	 * Get a move from the player and update the board. The player enters the move
	 * as [letter][number] representing the row and column of the move.
	 */
	private static void humanMove() {
		int row, col;
		do {
			System.out.println("Enter move, for example A3:");
			String move = input.nextLine();
			row = (int) (move.charAt(0)) - 65;
			col = Integer.parseInt(move.substring(1)) - 1;
		} while (!isValidMove(row, col));

		board[row][col] = humanMarker;

	}

	/**
	 * Determine if a move is valid (is in row 1-3, column 1-3, and space is
	 * unoccupied).
	 */
	private static boolean isValidMove(int row, int col) {
		return (row >= 0 && row < ROWS && col >= 0 && col < COLUMNS && board[row][col] == ' ');
	}

	/**
	 * Print out the board to the screen.
	 */
	private static void printBoard() {
		System.out.print("  ");
		// Print the numbers across the top to indicate column number
		for (int col = 0; col < COLUMNS; col++) {
			System.out.print(" " + (col + 1) + "  ");
		}
		System.out.println();
		for (int row = 0; row < ROWS; row++) {
			// Print a letter to indicate the row
			System.out.print((char) (row + 65) + " ");
			// Print the cells of a row
			for (int col = 0; col < COLUMNS; col++) {
				System.out.print(" " + board[row][col] + " ");
				// Print a vertical line between cells
				if (col < COLUMNS - 1) {
					System.out.print("|");
				}
			}
			// print a horizontal line to separate rows
			System.out.println();
			if (row < ROWS - 1) {
				System.out.println("   -----------");
			}
		}
		System.out.println();
	}

	/**
	 * Initialize the array of chars to ' 's.
	 **/
	private static void initializeBoard() {
      for(int row = 0; row< board.length; row++) {
    	  for(int col = 0; col<board[row].length; col++) {
    		  board[row][col] = ' ';
    	  
    	  }
      }
     
	}

}
