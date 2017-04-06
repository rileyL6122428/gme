package l2kstudios.gme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import l2kstudios.gme.level.Level;
import l2kstudios.gme.level.LevelCtrl;
import l2kstudios.gme.level.LevelView;
import processing.core.PApplet;

public class App extends PApplet {
	
	@Autowired
	private Level level;
	
	private LevelView levelView;
	private LevelCtrl levelController;
	
    public static void main( String[] args ) {
    	ApplicationContext appContext = new ClassPathXmlApplicationContext("Beans.xml");
    	PApplet papplet = (PApplet) appContext.getBean("app");
    	papplet.runSketch(new String[]{ "PraxisLIVE" }, papplet);
    }
    
    public void settings() {
    	fullScreen();
    }
    
    public void setup() {
    	frameRate(30);
    	background(255, 255, 255);
    }
    
    public void draw() {
    	fill(0);
    	text("height = " + level.getGridHeight(), 100, 100);
    	text("width = " + level.getGridWidth(), 100, 200);
    }
}
