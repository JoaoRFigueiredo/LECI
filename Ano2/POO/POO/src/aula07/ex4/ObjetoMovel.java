package aula07.ex4;

public class ObjetoMovel {
    private int x, y, dist = 0;
	private double maxv;
	
	//Constructor
	
	public ObjetoMovel(int x, int y, double maxv) {
		this.x = x; this.y = y; this.maxv = maxv;
	}
	
	//Getters & Setters
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDist() {
		return dist;
	}

	public double getMaxv() {
		return maxv;
	}

	public void setMaxv(double maxv) {
		this.maxv = maxv;
	}
	
	//Outras funções

	public void move(int x, int y) {
		this.x+=x; this.y+=y; dist+=(x+y);
	}
}
