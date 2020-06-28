package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;


/**
 * Tests TicTacToe.
 */
class Tests {
    public Tests() {
    }
    @Test
    public void printBoard() {
        TicTacToeGame board = new TicTacToeGame();

        /**
         * tests if it prints the board
         */
        assertTrue(board.printBoard());
    }

    @Test
     public void testDoesTheGameContinue() {
        TicTacToeGame board = new TicTacToeGame();

        /**
         * tests if there's a 3 in a row win
         */
        board._placeholders[0][0].setPlayerToken("X");
        board._placeholders[1][0].setPlayerToken("X");
        board._placeholders[2][0].setPlayerToken("X");
        assertTrue(board.whoWon() == "X");

        /**
         * cleaning board for next win condition
         */
        board = new TicTacToeGame();

        /**
         * tests if there's a 3 in a column win
         */
        board._placeholders[0][0].setPlayerToken("X");
        board._placeholders[0][1].setPlayerToken("X");
        board._placeholders[0][2].setPlayerToken("X");
        assertTrue(board.whoWon() == "X");

        /**
         * cleaning board for next win condition
         */
        board = new TicTacToeGame();

        /**
         * tests if there's a diagonal win
         */
        board._placeholders[0][0].setPlayerToken("X");
        board._placeholders[1][1].setPlayerToken("X");
        board._placeholders[2][2].setPlayerToken("X");
        assertTrue(board.whoWon() == "X");

        /**
         * cleaning board for next condition
         */
        board = new TicTacToeGame();

        /**
         * tests board is not full
         */
        assertFalse(board.isBoardFull());
    }

    @Test
    public void testPlayToWin() {
        /**
                  X | X |
                -----------
                 O  |  |
                -----------
                 O |   |
         */
        TicTacToeGame game = new TicTacToeGame();
        game._placeholders[0][0].setPlayerToken("X");
        game._placeholders[0][1].setPlayerToken("X");
        game._placeholders[1][0].setPlayerToken("O");
        game._placeholders[2][0].setPlayerToken("O");
        game.playToWinOrBlock("X");
        assertTrue(game.whoWon() == "X");
        assertFalse(game.wasLastMachineMoveRandom);
    }

    @Test
    public void testPlayToBlock() {
        /**
         O | O |
         -----------
         X  |  |
         -----------
         X |   |
         */
        TicTacToeGame game = new TicTacToeGame();
        game._placeholders[0][0].setPlayerToken("O");
        game._placeholders[0][1].setPlayerToken("O");
        game._placeholders[1][0].setPlayerToken("X");
        game._placeholders[2][0].setPlayerToken("X");
        game.machineTurn();
        assertFalse(game.whoWon() == "X");
        assertFalse(game.whoWon() == "O");
        assertFalse(game.wasLastMachineMoveRandom);
    }


    @Test
    public void testPlayToBlock2() {
          /*
   |   |
-----------
 O | O |
-----------
   | X |
     */
        TicTacToeGame game = new TicTacToeGame();
        game._placeholders[1][0].setPlayerToken("O");
        game._placeholders[1][1].setPlayerToken("O");
        game._placeholders[2][1].setPlayerToken("X");
        game.machineTurn();
        assertTrue(game._placeholders[1][2].getPlayerToken() == "X");
        assertFalse(game.whoWon() == "X");
        assertFalse(game.whoWon() == "O");
        assertFalse(game.wasLastMachineMoveRandom);
    }

    @Test
    public void testPlayToBlock3() {
         /*
   | X |
-----------
   | O |
-----------
 O |   | X
     */
        TicTacToeGame game = new TicTacToeGame();
        game._placeholders[0][1].setPlayerToken("X");
        game._placeholders[1][1].setPlayerToken("O");
        game._placeholders[2][0].setPlayerToken("O");
        game._placeholders[2][2].setPlayerToken("X");
        game.machineTurn();
        assertTrue(game._placeholders[0][2].getPlayerToken() == "X");
        assertFalse(game.whoWon() == "X");
        assertFalse(game.whoWon() == "O");
        assertFalse(game.wasLastMachineMoveRandom);
    }
}