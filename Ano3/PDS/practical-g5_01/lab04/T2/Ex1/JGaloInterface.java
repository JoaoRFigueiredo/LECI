<<<<<<< HEAD
// package Ex1;
=======
//package Ex1

>>>>>>> 0031b8c6947045583c7ba859f34c76b0a7aca4bd
public interface JGaloInterface {
	public char getActualPlayer(); // 'O' or 'X'
	public boolean setJogada(int lin, int col);
	public boolean isFinished();   // someone wons, or no empty positions
	public char checkResult();	// who wons?
}