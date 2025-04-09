import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] board = new char[3][3];

        // initializing the board with empty char
        //        for (int row = 0; row < board.length; row++) {
        //            for (int col = 0; col < board[row].length; col++) {
        //                board[row][col] = ' ';
        //            }
        //        }

        // To make the re-use of the code which is same here for initializing and resetting the board if it is full
        // THIS METHOD WILL BOTH INITIALIZE AS WELL AS RESET THE BOARD ( RESETTING THE GAME )
        resetGame(board);

        char player = 'X';
        boolean gameOver = false;

        while (!gameOver) {
            // Printing the board until now
            showBoard(board);

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
                    if(isAllCellsFull(board)){
                        System.out.println("Tie !! , game will reset now !!");
                        System.out.println("The player will change.");
                        resetGame(board);
                        player = changePlayer(player);
                        continue;
                    }
                    // Changing the player
                    // If player is 'X' then change  to 'O' else change to 'X'
                    // player = (player == 'X') ? 'O' : 'X';
                    // making the change of player into a function
                    player = changePlayer(player);
                }
            } else {
                System.out.println("Invalid Move");
            }

        }
        showBoard(board);
    }

    // THIS METHOD WILL CHECK IF THE PROVIDED PLAYER HAS WON THE GAME OR NOT
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

    // THIS METHOD WILL DISPLAY THE BOARD
    public static void showBoard ( char[][] board){

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }

    }

    // THIS METHOD WILL RESET/INITIALIZE THE GAME
    public static void resetGame(char[][] board){
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
    }

    // THIS METHOD WILL CHECK IF THE BOARD IS FULL AND THE GAME IS TIE
    public static boolean isAllCellsFull(char[][] board){
        boolean isfull = true;
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                if(board[row][col] == ' '){
                    return false;
                }
            }
        }
        return isfull;
    }

    // THIS METHOD WILL CHANGE THE CURRENT PLAYER
    public static char changePlayer(char player){
        return (player == 'X') ? 'O' : 'X';
    }
}

