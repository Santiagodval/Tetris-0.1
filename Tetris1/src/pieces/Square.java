package pieces;

public class Square extends Piece{
	
	public Square() {
		super.setPieceDots(new Dot[] {new Dot(0,4) ,new Dot(0,5) ,new Dot(1,4) ,new Dot(1,5)});
	}
	
	public Dot[] nextRotationPosition() {
		
		return this.getPieceDots();
		
	}
	
}
