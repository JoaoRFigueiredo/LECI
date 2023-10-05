<<<<<<< HEAD
// package lab03;
=======
//package lab03;
>>>>>>> 0031b8c6947045583c7ba859f34c76b0a7aca4bd

public class JGaloLogic implements JGaloInterface {
    private char current_player;
    private char[][] board = new char[3][3];
    private char winner;

    public JGaloLogic() { // no 1st player specified
        this.current_player = 'X';
        this.winner = ' ';
    }

    public JGaloLogic(char first_player) { // 1st player specified
        this.current_player = first_player;
    }

    @Override
    public char getActualPlayer() {
        // returns once 'X' and then 'O'
        this.current_player = (this.current_player == 'X') ? 'O' : 'X';
        return current_player;
    }

    @Override
    public boolean setJogada(int lin, int col) {
        // updates the board with the current player play
        this.board[lin-1][col-1] = this.current_player;
        return true;
    }

    @Override
    public boolean isFinished() {
        for (int i = 0; i < 3; i++) {
            // check vertical 
            if (this.board[i][0] == this.board[i][1] && this.board[i][1] == this.board[i][2] && this.board[i][0] != '\0') {
                this.winner = this.board[i][0];
                return true;
            }
        }
            // check horizontal
        for (int i = 0; i < 3; i++) {
            if (this.board[0][i] == this.board[1][i] && this.board[1][i] == this.board[2][i] && this.board[0][i] != '\0') {
                this.winner = this.board[0][i];
                return true;
            }
        }
        // check other diagonal
        if (this.board[0][0] == this.board[1][1] && this.board[1][1] == this.board[2][2] && this.board[0][0] != '\0') {
            this.winner = this.board[0][0];
            return true;
        }
        //check other diagonal
        if (this.board[0][2] == this.board[1][1] && this.board[1][1] == this.board[2][0] && this.board[0][2] != '\0') {
            this.winner = this.board[0][2];
            return true;
        }
        int count = 0;
        // check if all spaces have been filled
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.board[i][j] != '\0') {
                    count++;
                }
            }
        }
        if (count == 9) return true;
        return false;
    }

    @Override
    public char checkResult() {
        // returns the winner
        return this.winner;
    }

    
}
