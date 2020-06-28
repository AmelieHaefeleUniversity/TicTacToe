package com.company;

/**
 * This represents a line on the board that is a win.
 */
public class Line {
    private BoardSquare point1;
    private BoardSquare point2;
    private BoardSquare point3;

    /**
     * Pass in pointers to the actual Squares on the board.
     *
     * @param point1
     * @param point2
     * @param point3
     */
    public Line(BoardSquare point1, BoardSquare point2, BoardSquare point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    /**
     * How many of a character appear in this line.
     * @param character
     * @return
     */
    public int countOfCharacter(String character){
        int count = 0;
        if (point1.getPlayerToken().equals(character)){
            count = count + 1;
        }
        if(point2.getPlayerToken().equals(character)){
            count = count + 1;
        }
        if (point3.getPlayerToken().equals(character)){
            count = count + 1;
        }
        return count;
    }

    /**
     * Returns the player token has won
     * @return
     */
    public String hasPlayerWon() {
        if (point1.getPlayerToken() == point2.getPlayerToken() &&
                point2.getPlayerToken() == point3.getPlayerToken()) {
            return point1.getPlayerToken();
        }
        return TicTacToeGame.BLANK;
    }

    /**
     * Returns square that is blank
     */
    public BoardSquare whichIsBlank(){
        if(point1.getPlayerToken() == TicTacToeGame.BLANK) {
            return point1;
        }
        if(point2.getPlayerToken() == TicTacToeGame.BLANK){
            return point2;
        }
        if(point3.getPlayerToken() == TicTacToeGame.BLANK){
            return point3;
        }
        return null;
    }
}
