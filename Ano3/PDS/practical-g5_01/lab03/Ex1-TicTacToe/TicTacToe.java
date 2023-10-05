//package TicTacToe;
//package lab03;
import java.util.ArrayList;
import java.util.List;

public class TicTacToe implements JGaloInterface{

    private char[][] grid;
    private char currentPlayer;
   

    
    public TicTacToe(String[] args){
        this.grid = new char[3][3];
        currentPlayer = 'X';
        if(args.length > 0){
            System.out.println(args[0]);
        if (args[0].equals("X") || args[0].equals("O") || args[0].equals("x") || args[0].equals("o")){
            currentPlayer = Character.toUpperCase(args[0].charAt(0));
            
        }
    }
        
        
    }


    public char getActualPlayer(){
        return currentPlayer;
    }

    public boolean setJogada(int row, int col){
        if (this.grid[row-1][col-1] == '\u0000'){
            this.grid[row-1][col-1] = currentPlayer;
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            return true;
        }

        return false;
    }


    public char checkResult() {
        if (hasPlayerWon('X')) {
            return 'X';
        } else if (hasPlayerWon('O')) {
            return 'O';
        } 
        else {
            return ' ';
        }
    }

    public boolean isFinished() {
        return (hasPlayerWon('X') || hasPlayerWon('O') || getAvailablePositions().isEmpty());
    }

    private boolean hasPlayerWon(char player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == player && grid[i][1] == player && grid[i][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (grid[0][j] == player && grid[1][j] == player && grid[2][j] == player) {
                return true;
            }
        }

        // Check diagonals
        if (grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) {
            return true;
        }
        if (grid[0][2] == player && grid[1][1] == player && grid[2][0] == player) {
            return true;
        }

        return false;
    }


    private List<Integer> getAvailablePositions() {
        List<Integer> availablePositions = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == '\u0000') {
                    availablePositions.add(i*3 + j + 1);
                }
            }
        }
        return availablePositions;
    }


    
}
