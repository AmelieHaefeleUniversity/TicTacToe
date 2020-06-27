package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;


class movesOnBoardTest {
    public movesOnBoardTest() {
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
        board._placeholders[0][0] = "X";
        board._placeholders[1][0] = "X";
        board._placeholders[2][0] = "X";
        assertFalse(board.doesTheGameContinue());

        /**
         * cleaning board for next win condition
         */
        board = new TicTacToeGame();

        /**
         * tests if there's a 3 in a column win
         */
        board._placeholders[0][0] = "X";
        board._placeholders[0][1] = "X";
        board._placeholders[0][2] = "X";
        assertFalse(board.doesTheGameContinue());

        /**
         * cleaning board for next win condition
         */
        board = new TicTacToeGame();

        /**
         * tests if there's a diagonal win
         */
        board._placeholders[0][0] = "X";
        board._placeholders[1][1] = "X";
        board._placeholders[2][2] = "X";
        assertFalse(board.doesTheGameContinue());

        /**
         * cleaning board for next condition
         */
        board = new TicTacToeGame();

        /**
         * tests if no one has won
         */
        assertTrue(board.doesTheGameContinue());


    }
    @Test
    public void testGetPrintableString() {
        TicTacToeGame board = new TicTacToeGame();

        /**
         * creating test values
         */
        board._placeholders[1][2] = "X";
        board._placeholders[0][0] = "O";

        /**
         * creating X test values
         */
        String tempX = board._placeholders[1][2];
        String testTempX = board.getPrintableString(tempX);

        /**
         * testing true assert
         */
        assertEquals("X",testTempX);

        /**
         * creating O test values
         */
        String tempO = board._placeholders[0][0];
        String testTempO = board.getPrintableString(tempO);

        /**
         * testing true assert
         */
        assertEquals("O",testTempO);

        /**
         * creating Null test values
         */
        String tempNull = board._placeholders[2][2];
        String testTempNull = board.getPrintableString(tempNull);

        /**
         * testing true assert
         */
        assertEquals("__",testTempNull);
    }
}