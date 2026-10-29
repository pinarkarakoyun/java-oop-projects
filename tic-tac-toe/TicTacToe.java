
// Pınar Karakoyun

import java.util.Scanner; //take input from the user.
import java.util.Random; //make random moves for the computer.

public class TicTacToe { //the beginning of the class containing the Tic-Tac-Toe game.
    
	private enum Cell { X, O, EMPTY } //an enum type representing the state of a cell.

    private Cell[][] board; //it represents the game board
    private Cell currentPlayer; //keep track of the current player
    private Cell humanPlayer; // stores the cell type (X or O) for the human player.
    private Cell computerPlayer; //stores the cell type (X or O) for the computer player.

    public TicTacToe() { //it initialize a new game board and sets the board to empty.
        board = new Cell[3][3]; //it create a 3x3 game board.
        initializeBoard(); //sets all the cells on the board to empty.
    }

    private void initializeBoard() { //this method starts the board and sets all cell to empty. 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Cell.EMPTY; //nested loops that set all cells to empty.
            }
        }
    }

    private void printBoard() { // the method that prints the game board.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] == Cell.EMPTY ? " " : board[i][j]);
                if (j < 2) 
                	System.out.print("|");
            }
            System.out.println();
            if (i < 2) 
            	System.out.println("-----"); 
            // nested loops to print the board in a formatted manner. 
            // it prints | and ----- to separate rows and columns. 
        }
    }

    private boolean makeMove(int row, int col, Cell player) { 
    	//the method that makes a move in specified row and column for the player.
        if (board[row][col] != Cell.EMPTY) {
            System.out.println("Cell already occupied.");
            return false; //checks if the cell is already occupied. if it is, prints error message and returns false
        }
        board[row][col] = player;
        return true; // sets the cell to the player's mark (X or O). if the move is successful returns true.
    }

    private Cell checkWinner() { //the method that checks if there is a winner.
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != Cell.EMPTY)
                return board[i][0];
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != Cell.EMPTY)
                return board[0][i];
            // loops to check rows and columns for a winner.
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != Cell.EMPTY)
            return board[0][0];
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != Cell.EMPTY)
            return board[0][2];
        // loops to check the diagonals for a winner.
        return null; // returns null if there is no winner.
    }

    private boolean isDraw() { // the method that checks if the game is a draw.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == Cell.EMPTY) {
                    return false; // nested loops to check if all cells are occupied.
                }
            }
        }
        return true; // returns true if the board is full and there is no winner, indicating a draw.
    }

    private void computerMove() { // the method that makes a random move for the computer.
        Random rand = new Random(); //it creates a random object to generate random numbers .
        int row, col;
        do {
            row = rand.nextInt(3);
            col = rand.nextInt(3);
        } 
        while (board[row][col] != Cell.EMPTY); 
        //generates random row and column indicates until an empty cell is found.
        board[row][col] = computerPlayer; // sets the cell to the computer's mark.
    }

    public void play() { // the method that runs the game.
        Scanner scanner = new Scanner(System.in); //to take user input.
        System.out.print("Who is going to start game? (1 = Human, 2 = Computer): ");
        int choice = scanner.nextInt(); // asks the user who will start the game and takes input

        if (choice == 1) {
            humanPlayer = Cell.X;
            computerPlayer = Cell.O;
            currentPlayer = humanPlayer;
        } 
        else {
            humanPlayer = Cell.O;
            computerPlayer = Cell.X;
            currentPlayer = computerPlayer;
        }
        // sets the player types based on the user's choice and decides the starting player.

        while (true) {
            printBoard(); // the game loop starts and prints the board each run.
            if (currentPlayer == humanPlayer) {
                System.out.print("Enter row (0, 1, 2): ");
                int row = scanner.nextInt();
                System.out.print("Enter column (0, 1, 2): ");
                int col = scanner.nextInt();
                if (makeMove(row, col, humanPlayer)) {
                    currentPlayer = computerPlayer;
                }
            } 
            else {
                computerMove();
                currentPlayer = humanPlayer;
            } // executes the current player's move. if it's the human player's turn, it takes input for the row and column.
              // if it's the computer's turn, the computer makes a move.

            Cell winner = checkWinner();
            if (winner != null) {
                printBoard();
                System.out.println("Player " + winner + " won!");
                break;
            } // after each move, checks if there's a winner. if there is, prints the board and announces the winner

            if (isDraw()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            } // checks if the game is a draw. if it is, prints the board and announces the draw.
        }
        scanner.close(); //closes the scanner object.
    }
}

