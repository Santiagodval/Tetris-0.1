package pieces;

public class Pyramid extends Piece{
	
	public Pyramid() {
		super.setPieceDots(new Dot[] {new Dot(0,4) ,new Dot(1,3) ,new Dot(1,4) ,new Dot(1,5)});
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
		
		System.out.println(temporal);
		
		switch(temporal) {
		case 0:
			puntos[0].move(-1, 1); puntos[1].move(-1, -1); puntos[3].move(1, 1);
			break; // put returns in every case is bad?
		case 1:
			puntos[0].move(1, 1); puntos[1].move(-1, 1); puntos[3].move(1, -1);
			break;
		case 2:
			puntos[0].move(1, -1); puntos[1].move(1, 1); puntos[3].move(-1, -1);
			break;
		case 3:
			puntos[0].move(-1, -1); puntos[1].move(1, -1); puntos[3].move(-1, 1);
			break;
		
		}return puntos;
		
	}

}
