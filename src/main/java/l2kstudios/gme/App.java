package l2kstudios.gme;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import l2kstudios.gme.ctrl.Controller;
import l2kstudios.gme.model.level.Level;
import l2kstudios.gme.view.LevelView;
import l2kstudios.gme.view.View;
import processing.core.PApplet;

public class App extends PApplet implements InitializingBean {
	
	@Autowired
	private Config config;
	
	@Autowired
	private AssetLoader assetLoader;
	
	private Level level;
	
	private View<Level> levelView;
	
	private Controller controller;
	
    @SuppressWarnings("resource")
	public static void main( String[] args ) {
    	ApplicationContext appContext = new ClassPathXmlApplicationContext("Beans.xml");
    	App game = (App) appContext.getBean("app");
    	PApplet.runSketch(new String[]{ "PraxisLIVE" }, game);
    }
    
    public void settings() {
    	config.settings();
    }
    
    public void setup() {
    	config.setup();
    	assetLoader.loadAssets();
    }
    
    public void draw() {
    	levelView.draw();
    	level.update();
    }
    
    public void keyPressed() {
    	getController().keyPressed();
    }

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public View<Level> getLevelView() {
		return levelView;
	}

	public void setLevelView(LevelView levelView) {
		this.levelView = levelView;
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		levelView.setDrawingContext(this);
		levelView.setModel(level);
		
		getController().setControlContext(this);
		getController().setInteractable(level);
	}
}
