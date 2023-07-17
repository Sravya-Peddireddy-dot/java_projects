import java.util.Scanner;

public class Tic_Tac_Toe {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	
		// TODO Auto-generated method stub
		char[][] board=new char[3][3];
		for (int row=0;row<board.length;row++) {
			for (int col=0;col<board[row].length;col++) {
				
				board[row][col]=' ';
				
			}
			
		}
		
		
		//player first enters 'X'
		System.out.println("enter the player you want to be ('X' or 'O' in capitals): ");
		char player=sc.next().charAt(0);
		boolean gameOver=false;
		
		
		
			
		
			while(!gameOver) {
				
				if(!boardfull(board)) {
					printBoard(board);
					System.out.println("Player "+player+" enter the value");
					System.out.println("enetr row :");
					int row=sc.nextInt();
					if(row >2) {
						System.out.println("you entered invalis so plaese enetr again:");
						do{
							//System.out.println("you entered invalis so plaese enetr again:");
							row=sc.nextInt();
						}while(row >2);
						
					}
					System.out.println("enetr col :");
					int col=sc.nextInt();
					if(col > 2) {
						System.out.println("you entered invalis so plaese enetr again:");
						do{
							col=sc.nextInt();
						}while(col >2);
					
					}
					
					if(board[row][col] == ' ') {
						board[row][col]=player;
						gameOver=haveWon(board,player);
						if(gameOver) {
							printBoard(board);
							System.out.println("Player "+player+" has won");
						}
						else {
							if(player=='X') {
								player='O';
							}
							else {
								player='X';
							}
						}
					}
					else {
						System.out.println("INVALID MOVE");
					}
			}
			
			
			else {
				System.out.println("TIE");
				System.out.println("do you want to continue:(Y or N)");
				char ch=sc.next().charAt(0);
				while(ch == 'Y'){
					
					for (int row=0;row<board.length;row++) {
						for (int col=0;col<board[row].length;col++) {
							
							board[row][col]=' ';
							
						}
					}
				}
				
			}
		
		}
		
		
	}	
	
	 public static void printBoard(char[][] board) {
	    for (int row = 0; row < board.length; row++) {
	      for (int col = 0; col < board[row].length; col++) {
	    	
	        System.out.print(board[row][col] + " | ");
	        
	      }
	      System.out.println();
	    }
	 }
	

//public static boolean hasWon(char[][] board,char player) {
	 public static boolean haveWon(char[][] board, char player) {
		    // check the rows
		    for (int row = 0; row < board.length; row++) {
		      if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
		        return true;
		      }
		    }

		    // check for col
		    for (int col = 0; col < board[0].length; col++) {
		      if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
		        return true;
		      }
		    }

		    // diagonal
		    if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
		      return true;
		    }

		    if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
		      return true;
		    }
		    return false;
		  }

	public static boolean boardfull(char[][] board) {
		int c=0;
		for (int row=0;row<board.length;row++) {
			for (int col=0;col<board[row].length;col++) {
				
				if(board[row][col]!=' ') {
					c++;
				}
				
			}
		}
		if(c == 9) {
			return true;
		}
		return false;
	}

}
