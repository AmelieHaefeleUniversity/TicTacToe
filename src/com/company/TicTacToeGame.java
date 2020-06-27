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
    public String[][] _placeholders;

    /**
     * Constructing the board
     * */
    public TicTacToeGame() {
        _placeholders = new String[3][3];
    }

    /**
     * Checks if someone has won
     * */
    public boolean doesTheGameContinue(){
        for (int i = 0; i < _placeholders.length; i++) {
            /**
             *  Check if the O has won by getting 3 in a row
             *  */
            if ((_placeholders[i][0] == "X" ) && (_placeholders[i][1] == "X") && (_placeholders[i][2] == "X")) {
                System.out.println("You lose better luck next time!");
                return false;
            }
            /**
             *  Check if the X has won by getting 3 in a row
             *  */
            if((_placeholders[i][0] == "O") && ( _placeholders[i][1] == "O") && (_placeholders[i][2] == "O")){
                System.out.println("Congrats you won! Feel free to play again.");
                return false;
            }
            /**
             * Check if the X has won by getting 3 in a column
             * */
            if ((_placeholders[0][i] == "X" ) && (_placeholders[1][i] == "X") && (_placeholders[2][i] == "X" )) {
                System.out.println("You lose better luck next time!");
                return false;
            }
            /**
             *  Check if the O has won by getting 3 in a column
             *  */
            if ((_placeholders[0][i] =="O") && (_placeholders[1][i] == "O") && (_placeholders[2][i] == "O")) {
                System.out.println("Congrats you won! Feel free to play again.");
                return false;
            }
            /**
             * Check if X has won on the first diagonal
             * */
            if ((_placeholders[0][2]=="X") && (_placeholders[1][1] == "X" ) && (_placeholders[2][0] == "X" )) {
                System.out.println("You lose better luck next time!");
                return false;
            }
            /**
             * Check if O has won on the first diagonal
             * */
            if((_placeholders[0][2] == "O")&&(_placeholders[1][1] == "O") && (_placeholders[2][0] == "O")){
                System.out.println("Congrats you won! Feel free to play again.");
                return false;
            }
            /**
             * Check if X has won on the second diagonal
             */
            if((_placeholders[0][0]=="X") && (_placeholders[1][1] == "X" ) && (_placeholders[2][2] == "X" )){
                System.out.println("Congrats you won! Feel free to play again.");
                return false;
            }
            /**
             * Check if O has won on the second diagonal
             */
            if((_placeholders[0][0] == "O")&&(_placeholders[1][1] == "O") && (_placeholders[2][2] == "O")){
                System.out.println("Congrats you won! Feel free to play again.");
                return false;
            }
            /**
             * returning true if no one has won
             */
            else {
                return true;
            }
        }
        /**
         * returning true if no one has won
         */
        return true;
    }

    /**
     * plays the game
     */
    public void playGame() {
        /**
         * creating a scanner
         */
        Scanner sc = new Scanner(System.in);
        /**
         * creating a random
         */
        Random rand = new Random();

        /**
         * creating values to be used later
         */
        int machineRow = 0;
        int machineCol = 0;

        /**
         * creating the list of moves the computer can chose from
         */
        int[][] emptyMoves = new int[9][2];

        /**
         * creating a temporary boolean
         */
        boolean temp = true;

        /**
         * creating an int counter
         */
        int counter = 0;

        /**
         * runs the game
         */
        while (temp == true) {
            /**
             * print to instruct the user what to do
             */
            System.out.println("Where would you like to put your O?");

            /**
             * print to instruct the user to input the row's coordinate of their O
             */
            System.out.println("What is the Row position");

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
            System.out.println("What is the column position");

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
            if(_placeholders[rowPos][columnPos] == null){
            _placeholders[rowPos][columnPos] = "O";}
            else{
             /**
              * if it's already full the player will lose a turn
              */
                System.out.println("Space already taken you lose a turn");
            }

            /**
             * setting the counter to 0
             */
            counter = 0;

            /**
             * checking if a spot is empty so the machine doesn't take a spot that's already taken
             */
            for (int i = 0; i < _placeholders.length; i++) {
                /**
                 * going through I and J to check all values
                 */
                for (int j = 0; j < _placeholders.length; j++) {
                    /**
                     * checks if they're empty
                     */
                    if (_placeholders[i][j] == null || _placeholders[i][j] == "__") {
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
            int randomNumber = rand.nextInt(counter);
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
            _placeholders[machineRow][machineCol] = "X";
            printBoard();

            /**
             * checks if someone has won or not if won the game will end
             */
            temp = doesTheGameContinue();
        }
    }

    /**
     * prints out the board for the user to see
     */
    public boolean printBoard() {
        for (int i = 0; i < _placeholders.length; i++) {
            /**
             * goes through each row and prints them
             */
            System.out.println(getPrintableString(_placeholders[i][0])+"|"+ getPrintableString(_placeholders[i][1])+"|"+ getPrintableString(_placeholders[i][2]));

        }
        return true;
    }

    /** Returns __ if the space is not filled, else what the space holds (X or O)
     * @return*/
    String getPrintableString(String placeholders) {

        /**
         * no value it prints __ meaning its empty
         */
        String pos;
        if (placeholders == null) {
            pos = "__";


        /**
         * else it prints the value
         */
        } else {
            pos = placeholders;

        }

        /**
         * returns the outcome to be printed
         */
        return pos;

    }
}





