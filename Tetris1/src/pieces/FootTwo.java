package pieces;

public class FootTwo extends Piece implements Cloneable{

	public FootTwo() {
		
		super.setPieceDots(new Dot[] {new Dot(0,5) ,new Dot(1,5) ,new Dot(1,4) ,new Dot(1,3)});
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
			
			/*Dot[] temporalDots = {new Dot(puntos[0].getY(),puntos[0].getX()+2), new Dot(puntos[1].getY()+1,puntos[1].getX()+1),
								  new Dot(puntos[2].getY(),puntos[2].getX()), new Dot(puntos[3].getY()-1,puntos[3].getX()-1)};
			*/
			
			puntos[0].move(0, 2); puntos[1].move(1, 1); puntos[3].move(-1, -1);
			return puntos;
			 // put returns in every case is bad?
		case 1:
			/*Dot[] temporalDots1 = {new Dot(puntos[0].getY()+2,puntos[0].getX()), new Dot(puntos[1].getY()+1,puntos[1].getX()-1),
					  			  new Dot(puntos[2].getY(),puntos[2].getX()), new Dot(puntos[3].getY()-1,puntos[3].getX()+1)};
			*/
			puntos[0].move(2, 0); puntos[1].move(1, -1); puntos[3].move(-1, 1);
			return puntos;
			
		case 2:
			/*Dot[] temporalDots2 = {new Dot(puntos[0].getY(),puntos[0].getX()-2), new Dot(puntos[1].getY()-1,puntos[1].getX()-1),
		  			  			   new Dot(puntos[2].getY(),puntos[2].getX()), new Dot(puntos[3].getY()+1,puntos[3].getX()+1)};
			*/
			
			puntos[0].move(0, -2); puntos[1].move(-1, -1); puntos[3].move(1, 1);
			return puntos;
		
		case 3:
			/*Dot[] temporalDots3 = {new Dot(puntos[0].getY()-2,puntos[0].getX()), new Dot(puntos[1].getY()-1,puntos[1].getX()+1),
		  			  			   new Dot(puntos[2].getY(),puntos[2].getX()), new Dot(puntos[3].getY()+1,puntos[3].getX()-1)};
			*/
			
			puntos[0].move(-2, 0); puntos[1].move(-1, 1); puntos[3].move(1, -1);
			return puntos;
			
		
		}return puntos;
		
	}
	
	public Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
}
