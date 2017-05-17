package l2kstudios.gme;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import l2kstudios.gme.ctrl.Controller;
import l2kstudios.gme.ctrl.LevelCtrl;
import l2kstudios.gme.model.level.Level;
import l2kstudios.gme.view.LevelView;
import l2kstudios.gme.view.View;
import processing.core.PApplet;

public class App extends PApplet implements InitializingBean {
	
	@Autowired
	private Config config;
	
	private Level level;
	
	private View<Level> levelView;
	
	private Controller<Level> levelController;
	
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
    }
    
    public void draw() {
    	getLevelView().draw();
    }
    
    public void keyPressed() {
    	getLevelController().keyPressed();
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

	public Controller<Level> getLevelController() {
		return levelController;
	}

	public void setLevelController(LevelCtrl levelController) {
		this.levelController = levelController;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		GameModelService.setGame(this);
		
		levelView.setDrawingContext(this);
		levelView.setModel(level);
		
		levelController.setControlContext(this);
		levelController.setModel(level);
	}
}
