import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] board = new char[3][3];

        // initializing the board with empty char
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;

        while (!gameOver) {
            // Printing the board until now
            shoeBoard(board);

            // Asking the player to make his move
            System.out.println("Player " + player + " enter your move: ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            //checking if the move is valid or not
            if (board[row][col] == ' ') {
                board[row][col] = player;

                // Checking if any player has won the game
                gameOver = hasWonTheGame(board, player);
                if (gameOver) {
                    System.out.println("Player " + player + " has won");
                    break;
                } else {
                    // Changing the player
                    // If player is 'X' then change  to 'O' else change to 'X'
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid Move");
            }

        }
        shoeBoard(board);
    }


    public static boolean hasWonTheGame ( char[][] board, char player){

        // Checking in rows
        for(int row = 0; row < board.length; row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }

        //Checking for columns
        for(int col = 0; col < board[0].length; col++){
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }

        //Checking diagonals
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }

        if(board[0][2] == player && board[1][1] == player && board[2][0] == player ){
            return true;
        }

        return false;
    }


    public static void shoeBoard ( char[][] board){

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }

    }
}

