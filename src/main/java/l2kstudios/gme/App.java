package l2kstudios.gme;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import processing.core.PApplet;

public class App extends PApplet {
    public static void main( String[] args ) {
    	ApplicationContext appContext = new ClassPathXmlApplicationContext("Beans.xml");
    	PApplet papplet = (PApplet) appContext.getBean("app");
    	papplet.runSketch(new String[]{ "PraxisLIVE" }, papplet);
    }
    
    public void settings() {
    	
    }
    
    public void setup() {
    	
    }
    
    public void draw() {
    	
    }
}
