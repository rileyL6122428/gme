package l2kstudios.gme.swing.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.swing.model.SwingUnit;

import static l2kstudios.gme.swing.view.GridConstants.*; 

public class CharacterView {
	
//	private Image image1;
//	private Image image2; 
//	private Image image3; 
	
	{
//		try {
////			String filePath = getClass().getClassLoader().getResource("Asbel-Attempt-2.png").getFile();
////			String filePathImage1 = getClass().getClassLoader().getResource("Asbel-Sketch.png").getFile();
//			String filePathImage1 = getClass().getClassLoader().getResource("Asbel-Frame-1.png").getFile();
//			image1 = ImageIO.read(new File(filePathImage1));
//			image1 = image1.getScaledInstance(SPACE_WIDTH - 25, SPACE_HEIGHT - 10, Image.SCALE_DEFAULT);
//			
//			String filePathImage2 = getClass().getClassLoader().getResource("Asbel-Frame-2.png").getFile();
//			image2 = ImageIO.read(new File(filePathImage2));
//			image2 = image2.getScaledInstance(SPACE_WIDTH - 25, SPACE_HEIGHT - 10, Image.SCALE_DEFAULT);
//			
//			String filePathImage3 = getClass().getClassLoader().getResource("Asbel-Frame-3.png").getFile();
//			image3 = ImageIO.read(new File(filePathImage3));
//			image3 = image3.getScaledInstance(SPACE_WIDTH - 25, SPACE_HEIGHT - 10, Image.SCALE_DEFAULT);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	private SwingUnit unit;
//	private int animationIdx = 0;
	
	public void draw(Graphics drawingCtx) {
		unit.runBoardAnimation(drawingCtx);
		
//		animationIdx++;
		
//		Position position = unit.getPosition();
		
//		Color unitColor = unit.getTeam() == Unit.Team.ALLY ? Color.blue : Color.red;
		
//		drawingCtx.setColor(unitColor);
//		drawingCtx.fillOval(position.getX() * SPACE_WIDTH, position.getY() * SPACE_HEIGHT, SPACE_WIDTH, SPACE_HEIGHT);
//		if(animationIdx % 60 < 15) {
//			drawingCtx.drawImage(image1, position.getX() * SPACE_WIDTH + 12, position.getY() * SPACE_HEIGHT + 5, null);
//		} else if(animationIdx % 60 < 30){
//			drawingCtx.drawImage(image2, position.getX() * SPACE_WIDTH + 12, position.getY() * SPACE_HEIGHT + 5, null);			
//		} else if(animationIdx % 60 < 45) {
//			drawingCtx.drawImage(image3, position.getX() * SPACE_WIDTH + 12, position.getY() * SPACE_HEIGHT + 5, null);
//		} else {
//			drawingCtx.drawImage(image2, position.getX() * SPACE_WIDTH + 12, position.getY() * SPACE_HEIGHT + 5, null);
//		}
		
//		drawingCtx.setColor(Color.green);
//		drawingCtx.drawString(unit.getName(), position.getX() * SPACE_WIDTH, position.getY() * SPACE_HEIGHT + SPACE_HEIGHT / 2);
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = (SwingUnit)unit;
	}
	
}
