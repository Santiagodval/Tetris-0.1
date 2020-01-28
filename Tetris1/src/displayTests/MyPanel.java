package displayTests;

import java.awt.*;
import javax.swing.*;

public class MyPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	public void paintComponent(Graphics g) {
		
		//clears the previous paint
		super.paintComponent(g);
		
		// cast from graphics to graphics2D
		Graphics g2 = (Graphics2D) g;
		g2.setColor(Color.black);// sets the graphic´s color
		
		// paints the vertical and horizontal lines
		for (int i = 0; i < 10; i++) {
			g2.drawRect(i * 50, 0, 50, 750); // posx, posy, width, height 
			
		}
		for (int i = 0; i < 15; i++) {
			g2.drawRect(0, i * 50, 500, 50);
			
		}
		
		if(DisplayTest.getSlots()[0].length <= 15 && DisplayTest.getSlots()[1].length <= 10)
			for (int i = 0; i < DisplayTest.getSlots().length; i++) {
				for (int j = 0; j < DisplayTest.getSlots()[1].length; j++) {
					if(DisplayTest.getSlots()[i][j]) {
						
						g2.setColor(Color.blue);
						g2.fillRect(j*50,i*50,50,50);
						
					}
					
				}
				
			}
		 
		
	}
	

}
