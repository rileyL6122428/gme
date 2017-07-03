package l2kstudios.gme.swing.animation;

import static l2kstudios.gme.swing.view.GridConstants.SPACE_HEIGHT;
import static l2kstudios.gme.swing.view.GridConstants.SPACE_WIDTH;

import java.awt.Graphics;
import java.util.ArrayList;

import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.unit.Unit;

public class BoardAnimation {
	
	private Unit unit;
	private int currentFrameIdx;
	private int currentFrameElapsedTime;
	private ArrayList<Frame> idleFrames;
	
	public void animate(Graphics drawingCtx) {
		Frame currentFrame = getCurrentFrame();
		Position position = unit.getPosition();
		
		drawingCtx.drawImage(
			currentFrame.getImage(), 
			position.getX() * SPACE_WIDTH + 12, 
			position.getY() * SPACE_HEIGHT + 5, 
			null
		);
		
		currentFrameElapsedTime++;
	}
	
	private Frame getCurrentFrame() {		
		Frame previousFrame = idleFrames.get(currentFrameIdx);
		
		if(currentFrameElapsedTime == previousFrame.getDuration()) {
			incrementCurrentFrameIdx();
			currentFrameElapsedTime = 0;
		}
		
		Frame currentFrame = idleFrames.get(currentFrameIdx);
		
		return currentFrame;
	}
	
	private void incrementCurrentFrameIdx() {
		currentFrameIdx++;
		
		if(currentFrameIdx == idleFrames.size())
			currentFrameIdx = 0;
	}

	public void setIdleFrames(ArrayList<Frame> idleFrames) {
		this.idleFrames = idleFrames;
	}
	
}
