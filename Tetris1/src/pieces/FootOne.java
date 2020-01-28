package pieces;

public class FootOne extends Piece{
	
	public FootOne() {
		
		super.setPieceDots(new Dot[] {new Dot(0,3) ,new Dot(1,3) ,new Dot(1,4) ,new Dot(1,5)});
		//                            n0 and n1 are together                    n3 is apart
	}
	
	public Dot[] nextRotationPosition() {
		
		int temporal;
		Dot[] puntosTemp = this.getPieceDots();
		if(this.getRotationPos() == 3)
		temporal = 0;
		else
		temporal = this.getRotationPos() +1;
		
		Dot[] puntos = {new Dot(puntosTemp[0].getY(),puntosTemp[0].getX()), new Dot(puntosTemp[1].getY(),puntosTemp[1].getX()),
		  				new Dot(puntosTemp[2].getY(),puntosTemp[2].getX()), new Dot(puntosTemp[3].getY(),puntosTemp[3].getX())};
		
		switch(temporal) {
		case 0:
			puntos[0].move(-2, 0); puntos[1].move(-1, -1); puntos[3].move(1, 1);
			return puntos; // put returns in every case is bad?
		case 1:
			puntos[0].move(0, 2); puntos[1].move(-1, 1); puntos[3].move(1, -1);
			return puntos;
		case 2:
			puntos[0].move(2, 0); puntos[1].move(1, 1); puntos[3].move(-1, -1);
			return puntos;
		case 3:
			puntos[0].move(0, -2); puntos[1].move(1, -1); puntos[3].move(-1, 1);
			return puntos;
		
		}return puntos;
		
	}
	
	

}
