package l2kstudios.gme.swing;

public class GameUpdateThread extends Thread {
	
	private int frameRate = 30;
	private GamePanel gamePanel;
	
	private boolean initialized;
	
	public void run() {
		
		while(true) {
			try {
				Thread.sleep(1000/frameRate);
				gamePanel.update();
				gamePanel.repaint();
				
				if(!initialized) { 
					initialized = true;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
}
