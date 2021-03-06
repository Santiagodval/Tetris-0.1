package pieces;

public class Stair1 extends Piece{
	
	public Stair1() {
		
		super.setPieceDots(new Dot[] {new Dot(0,5) ,new Dot(0,4) ,new Dot(1,4) ,new Dot(1,3)});
		//						      n0 and n1 are together                    n3 is apart
	}
	
	public void setRotationPos(int pos) {
		if(pos > 1)
		this.rotationPos = 0;
		else
		this.rotationPos = pos;
	}
	
	public Dot[] nextRotationPosition() {
		
		int temporal;
		Dot[] puntosTemp = this.getPieceDots();
		if(this.getRotationPos() == 1)
		temporal = 0;
		else
		temporal = this.getRotationPos() +1;
		
		Dot[] puntos = {new Dot(puntosTemp[0].getY(),puntosTemp[0].getX()), new Dot(puntosTemp[1].getY(),puntosTemp[1].getX()),
		  				new Dot(puntosTemp[2].getY(),puntosTemp[2].getX()), new Dot(puntosTemp[3].getY(),puntosTemp[3].getX())};
		
		switch(temporal) {
		case 0:
			puntos[0].move(-2, 0); puntos[1].move(-1, -1); puntos[3].move(1, -1);
			break; // put returns in every case is bad?
		case 1:
			puntos[0].move(2, 0); puntos[1].move(1, 1); puntos[3].move(-1, 1);
			break;
		
		}return puntos;
		
	}

}
