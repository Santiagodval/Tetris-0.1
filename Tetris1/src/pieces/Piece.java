package pieces;

public  class Piece implements Cloneable{
	
	private Dot[] pieceDots;
	protected int rotationPos = 0;

	////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Dot[] getPieceDots() {
		return pieceDots;
	}

	public void setPieceDots(Dot[] pieceDots) {
		this.pieceDots = pieceDots;
	}	
	
	public int getRotationPos() {
		return rotationPos;
	}

	public void setRotationPos(int pos) {
			if(pos > 3)
			this.rotationPos = 0;
			else
			this.rotationPos = pos;
	}
	

	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void move(int y, int x) {
		Dot[] dots= getPieceDots();
		for (int i = 0; i < dots.length; i++) {
			dots[i].move(y,x);
		}
		setPieceDots(dots);
		
	}
	
	public boolean isThePiece(Dot theDot) {//comprovates if the given dot is from this piece
		
		for (int i = 0; i < pieceDots.length; i++) {
			Dot dot = pieceDots[i];
			if(dot.getX() == theDot.getX() && dot.getY() == theDot.getY()) {
				return true;
			}
			
		}return false;
	}
	
	public Dot[] nextRotationPosition() {
		
		return pieceDots;
	}

	public Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
	
	
	

}
