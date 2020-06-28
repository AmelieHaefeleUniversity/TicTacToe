package com.company;

/**
 * Represents a square on the board. Knows its position, and which token/character is
 * held currently.
 */
public class BoardSquare {
    private int row;
    private int col;
    private String playerToken;

    public BoardSquare(int row, int col) {
        this.row = row;
        this.col = col;
        this.playerToken = TicTacToeGame.BLANK;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String getPlayerToken() {
        return playerToken;
    }

    /**
     * Sets a play piece on the board.
     * @param playerToken
     */
    public void setPlayerToken(String playerToken) {
        assert playerToken == "X" || playerToken == "O" || playerToken == TicTacToeGame.BLANK;
        this.playerToken = playerToken;
    }
}
