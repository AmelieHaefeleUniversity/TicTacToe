package com.company;
/**
 * importing the scanner
 */
import java.util.Scanner;
/**
 * importing Randoms
 */
import java.util.Random;

/**
 * Class to play tic-tac-toe.
 */
public class TicTacToeGame {
    static public String BLANK = " ";
    /**
     * creating a random for use
     */
    private Random _rand = new Random();
    /**
     * Used to test - make sure a win/block move was not random.
     */
    boolean wasLastMachineMoveRandom = false;

    public BoardSquare[][] _placeholders;
    private Line[] LINES;

    /**
     * Constructing the board
     * */
    public TicTacToeGame() {
        _placeholders = new BoardSquare[3][3];
        // Initialize the array to blank.
        for (int i=0; i < 3; i++)
            for (int j=0; j < 3; j++)
                _placeholders[i][j] = new BoardSquare(i, j);
       LINES = new Line[]
               {    // Rows
                       new Line(_placeholders[0][0],_placeholders[0][1], _placeholders[0][2]),
                    new Line(_placeholders[1][0],_placeholders[1][1], _placeholders[1][2]),
                   new Line(_placeholders[2][0],_placeholders[2][1], _placeholders[2][2]),
                    // Cols
                    new Line(_placeholders[0][0],_placeholders[0][ 1], _placeholders[0][2]),
                    new Line(_placeholders[1][0],_placeholders[1][1], _placeholders[2][2]),
                    new Line(_placeholders[2][0],_placeholders[2][ 1], _placeholders[2][2]),
                    // Diagonals
                    new Line(_placeholders[0][0],_placeholders[1][ 1], _placeholders[2][2]),
                    new Line(_placeholders[2][0],_placeholders[1][ 1], _placeholders[0][2])
        };
    }


    /**
     * Return token of winner, or blank if no winner
     * @return
     */
    String whoWon() {
        for (int l=0; l < LINES.length; l++) {
            String winner = LINES[l].hasPlayerWon();
            if(winner.equals("X")){
                System.out.println("Sorry you lost.");
            }
            if (winner.equals("O")){
                System.out.println("Congrats you won!");
            }
            if (winner != BLANK) {
                return winner;
            }
            if(isBoardFull() == true && winner.equals(BLANK)){
                System.out.println("It's a tie!");
            }
        }
        return BLANK;
    }

    /**
     * Checks if the board is completely full.
     * @return
     */
    boolean isBoardFull(){
        for (int i=0; i < 3; i++)
            for (int j=0; j < 3; j++)
                if (_placeholders[i][j].getPlayerToken() == BLANK) {
                    return false;
                }
        return true;
    }

    /**
     * Plays the game - main method.
     */
    public void playGame() {
        /**
         * runs the game
         */
        boolean isPlayerNext = true; // Human gets to start.
        while (whoWon() == BLANK && !isBoardFull()) {
            if (isPlayerNext) {
                playerTurn();
            } else {
                machineTurn();
                printBoard();
            }
            isPlayerNext = !isPlayerNext;  // Switch
        }
        // Print out a winner or draw1
    }

    /**
     * Machine takes a turn, placing an X. Will look to win if can, block if it needs to, else play
     * a random square.
     */
    void machineTurn() {
        /**
         * checking if a spot is empty so the machine doesn't take a spot that's already taken
         */

        // Don't know if the move is random or not.
        wasLastMachineMoveRandom = false;

        // Win if you can
        if (playToWinOrBlock("X")) {
            return;
        }

        // Block if you can
        if (playToWinOrBlock("O")) {
            return;
        }

        int machineRow;
        int machineCol;

        /**
         * creating the list of moves the computer can chose from
         */
        int[][] emptyMoves = new int[9][2];


        /**
         * setting the counter to 0
         */
        int counter = 0;

        // Randonmly pick a square
        for (int i = 0; i < _placeholders.length; i++) {
            /**
             * going through I and J to check all values
             */
            for (int j = 0; j < _placeholders.length; j++) {
                /**
                 * checks if they're empty
                 */
                if (_placeholders[i][j].getPlayerToken() == BLANK) {
                    /**
                     * if they're empty sets it as a value to be able to be taken by the random picker
                     */
                    emptyMoves[counter][0] = i;
                    emptyMoves[counter][1] = j;
                    /**
                     * counter to know where put the empty column and row position
                     */
                    counter = counter + 1;
                }
            }
        }
        /**
         * picks a random empty spot to place an X
         */
        int randomNumber = _rand.nextInt(counter);
        wasLastMachineMoveRandom = true;
        /**
         * sets the empty row value for the machines move
         */
        machineRow = emptyMoves[randomNumber][0];
        /**
         * sets the empty column value for the machines move
         */
        machineCol = emptyMoves[randomNumber][1];

        /**
         * adds the X to the board
         */
        _placeholders[machineRow][machineCol].setPlayerToken("X");
    }

    /**
     * Allow player to input row and column. 0 is first row / column.
     */
    void playerTurn() {
        /**
         * creating a scanner
         */
        Scanner sc = new Scanner(System.in);
        /**
         * print to instruct the user what to do
         */
        System.out.println("Where would you like to put your O?");

        /**
         * print to instruct the user to input the row's coordinate of their O
         */
        System.out.println("What is the Row position (first row is 0)");

        /**
         * getting the user's input from the row
         */
        String xPosString = sc.nextLine();

        /**
         * setting the row integer from the user's input
         */
        int rowPos = Integer.parseInt(xPosString);

        /**
         * print to instruct the user to input the column's coordinate of their O
         */
        System.out.println("What is the column position (first column is 0)");

        /**
         * getting the user's input from the column
         */
        String yPosString = sc.nextLine();

        /**
         * setting the column integer from the user's input
         */
        int columnPos = Integer.parseInt(yPosString);


        /**
         * if its empty this is will set the O's value on the board
         */
        if(_placeholders[rowPos][columnPos].getPlayerToken() == BLANK){
            _placeholders[rowPos][columnPos].setPlayerToken("O");
        }
        else{
         /**
          * if it's already full the player will lose a turn
          */
            System.out.println("Space already taken you lose a turn");
        }
    }

    /**
     * Plays to block or win. If we play a character, return true, else false
     *
     * @param character
     * @return
     */
    public boolean playToWinOrBlock(String character){
        for(int i =0; i < LINES.length; i++ ){
           int temp = LINES[i].countOfCharacter(character);
           if(temp == 2){
               BoardSquare emptySquare = LINES[i].whichIsBlank();
               if (emptySquare != null) {
                   emptySquare.setPlayerToken("X");  // machine only plays X
                   return true;
               }
           }
        }
        return false;
    }


    /**
     * Prints out the board for the user to see
     */
    boolean printBoard() {
        for (int i = 0; i < _placeholders.length; i++) {
            /**
             * goes through each row and prints them
             */
            System.out.println(" "+_placeholders[i][0].getPlayerToken()+" | "+
                    _placeholders[i][1].getPlayerToken() +" | "+ _placeholders[i][2].getPlayerToken());
            if (i !=  _placeholders.length - 1) {
                System.out.println("-----------");
            }

        }
        return true;
    }

}





