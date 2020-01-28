package pieces;

public class Dot implements Cloneable{

	private int y;
	private int x;
	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	
	public Dot(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
	public void move(int y, int x) {
		
		this.y += y;
		this.x += x;
		
	}
	public Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
	
	
	
}
