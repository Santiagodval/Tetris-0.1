package displayTests;

import javax.swing.*;

import pieces.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

	

	public class DisplayTest implements KeyListener{
	
		 JFrame f;
		 MyPanel p;
		 Container c;
		 
		 Piece thePiece = randomPiece();
		 //int y = 0;
		 //int x = 5;
		 private static boolean[][] slots = new boolean[15][10];
		 
		 public static boolean[][] getSlots() {
			 return slots;
		 }
		 public void setSlots(boolean[][] slots) {
			 DisplayTest.slots = slots;
		 }
		 
		 public DisplayTest(){
			 f = new JFrame();
			 // get the content area of Panel.
			 c = f.getContentPane();
			 // set the LayoutManager
			 c.setLayout(new BorderLayout());
			 
			 for (int i = 0; i < thePiece.getPieceDots().length; i++) { //initiates the piece position for future convenianse, and also just for doing it
				Dot actualDot = thePiece.getPieceDots()[i];
				slots[actualDot.getY()][actualDot.getX()] = true;
			 }
			 
			 p = new MyPanel();
			 // add MyPanel object into container
			 c.add(p);
			 // set the size of the JFrame, not sure how to adjust perfectly with the panel
			 f.setSize(508,780);
			 // make the JFrame visible
			 f.setVisible(true);
			 // make the window not resizable
			 f.setResizable(false);
			 // sets close behavior; EXIT_ON_CLOSE invokes System.exit(0) on closing the JFrame
			 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 //f.setFocusTraversalKeysEnabled(false);
			 f.addKeyListener(this);
			
			 Timer timer = new Timer();
				TimerTask task = new TimerTask() {
					
					public void run() {
						
						goDown();
					}
						
				};
				timer.schedule(task, 10, 500);
			
			
			
		 }
		
		 private void goDown() {
			 boolean goodToGo = true;
			 for (int i = 0; i < thePiece.getPieceDots().length; i++) {
				 Dot actualDot = thePiece.getPieceDots()[i];
				if(actualDot.getY() == 14 || slots[actualDot.getY() + 1][actualDot.getX()] == true && !thePiece.isThePiece(new Dot(actualDot.getY() +1, actualDot.getX()))) {	
				// get to the bottom      or             the next position is ocupied              and       is not the same piece 
					goodToGo = false;
					tetris();
					thePiece= randomPiece();
					break;
				}				
			}
			 if(goodToGo) {
			 for (int i = 0; i < thePiece.getPieceDots().length; i++) {
				 Dot actualDot = thePiece.getPieceDots()[i];
				//deletes the "last" position of the cube(do not have in count horizontal movement)
				slots[actualDot.getY()][actualDot.getX()] = false;
				
				
			 }	
			 thePiece.move(1,0);
			 for (int i = 0; i < thePiece.getPieceDots().length; i++) { //prints the piece in the boolean map
					Dot actualDot = thePiece.getPieceDots()[i];
					slots[actualDot.getY()][actualDot.getX()] = true;
				 }
			 }
					
			p.repaint();
			c.add(p);
			System.out.println("abajo");
			 
		 }
		 
		 
		 public static void main(String args[ ]){
			 DisplayTest t = new DisplayTest();
			 
		 }
		 
		 public Piece randomPiece() { //returns a random piece
			 
			
			 
			 int r = (int)(Math.random() * 7);
			 
			 switch(r){
			 case 0:
				 return new FootOne();
				 
			 case 1:
				 return new FootTwo();
				
			 case 2:
				 return new Stick();
				 
			 case 3:
				 return new Stair1();
				 
			 case 4:
				 return new Stair2();
				 
			 case 5:
				 return new Pyramid();
				 
			 case 6:
				 return new Square();
				 
			 
			 }
			return null;
		
		 }
		 
		 
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("boton precionado");
			int i = arg0.getKeyCode();
			switch (i) {
			case KeyEvent.VK_RIGHT://right key code
				boolean goodToGo = true;
				 for (int j = 0; j < thePiece.getPieceDots().length; j++) {
					 Dot actualDot = thePiece.getPieceDots()[j];
					if(actualDot.getX() == 9 || slots[actualDot.getY()][actualDot.getX() + 1] == true && !thePiece.isThePiece(new Dot(actualDot.getY(), actualDot.getX() + 1))) {	
					// get to the limit      or             the next position is ocupied              and       is not the same piece 
						goodToGo = false;
						break;
					}				
				}
				 if(goodToGo) {
				 for (int j = 0; j < thePiece.getPieceDots().length; j++) {
					 Dot actualDot = thePiece.getPieceDots()[j];
					//deletes the "last" position of the piece
					slots[actualDot.getY()][actualDot.getX()] = false;
					
					
				 }	
				 thePiece.move(0,1);
				 for (int j = 0; j < thePiece.getPieceDots().length; j++) { //prints the piece in the boolean map
						Dot actualDot = thePiece.getPieceDots()[j];
						slots[actualDot.getY()][actualDot.getX()] = true;
					 }
				 }
						
				p.repaint();
				c.add(p);
				System.out.println("abajo");
				break;
			case KeyEvent.VK_LEFT://left key code
				boolean goodToGo1 = true;
				 for (int j = 0; j < thePiece.getPieceDots().length; j++) {
					 Dot actualDot = thePiece.getPieceDots()[j];
					if(actualDot.getX() == 0 || slots[actualDot.getY()][actualDot.getX() - 1] == true && !thePiece.isThePiece(new Dot(actualDot.getY(), actualDot.getX() - 1))) {	
					// get to the limit      or             the next position is ocupied              and       is not the same piece 
						goodToGo1 = false;
						break;
					}				
				}
				 if(goodToGo1) {
				 for (int j = 0; j < thePiece.getPieceDots().length; j++) {
					 Dot actualDot = thePiece.getPieceDots()[j];
					//deletes the "last" position of the piece
					slots[actualDot.getY()][actualDot.getX()] = false;
					
					
				 }	
				 thePiece.move(0,-1);
				 for (int j = 0; j < thePiece.getPieceDots().length; j++) { //prints the piece in the boolean map
						Dot actualDot = thePiece.getPieceDots()[j];
						slots[actualDot.getY()][actualDot.getX()] = true;
					 }
				 }
						
				p.repaint();
				c.add(p);
				System.out.println("abajo");
				break;
			case KeyEvent.VK_DOWN:
				goDown();
				break;
			case KeyEvent.VK_UP:
				boolean goodToGo2 = true;
				Dot[] ifTurned = thePiece.nextRotationPosition();
				 for (int j = 0; j < ifTurned.length; j++) {
					 Dot actualDot = ifTurned[j];
					if(actualDot.getX() < 0 || actualDot.getX() > 9 || slots[actualDot.getY()][actualDot.getX()] == true && !thePiece.isThePiece(new Dot(actualDot.getY(), actualDot.getX()))) {	
					// get to the limit      or             the next position is ocupied              and       is not the same piece 
						goodToGo2 = false;
						break;
					}				
				}
				 if(goodToGo2) {
				 for (int j = 0; j < thePiece.getPieceDots().length; j++) {
					 Dot actualDot = thePiece.getPieceDots()[j];
					//deletes the "last" position of the piece
					System.out.println(actualDot.getY() + " " + actualDot.getX()); 
					slots[actualDot.getY()][actualDot.getX()] = false;
				 }
				 
				thePiece.setRotationPos(thePiece.getRotationPos()+1);
				 thePiece.setPieceDots(ifTurned);
				 
				 for (int j = 0; j < thePiece.getPieceDots().length; j++) { //prints the piece in the boolean map
						Dot actualDot = thePiece.getPieceDots()[j];
						slots[actualDot.getY()][actualDot.getX()] = true;
					 }
				 }
				 
						
				p.repaint();
				c.add(p);
				System.out.println("abajo");
				
				break;
			default:
				break;
			}
			
		}
		
		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void tetris() {
			boolean tetris = true;
			//int first = -1; int last = -1;
			
			for (int i = 0; i < slots.length; i++) {
				
				tetris = true;
				for (int j = 0; j < slots[i].length; j++) {
					
					if(slots[i][j] == false) { 
						tetris = false;break;}
						
				}
				if(tetris) {
					
					getDown(i);
						
				}	
			}
			
			
		}
		
		private void getDown(int line) {//gets down by one all points above the line
			
			for (int i = line; i > 0; i--) {
				
				for (int j = 0; j < slots[i].length; j++) {
					try {
						slots[i][j] = false;
						slots[i][j] = slots[i-1][j];
					}catch (Exception e) {
						slots[i][j] = false;
					}
				}
				
			}
			
		}


		
		
	}
