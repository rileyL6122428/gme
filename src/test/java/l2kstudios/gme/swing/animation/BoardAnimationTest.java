package l2kstudios.gme.swing.animation;

import static org.junit.Assert.*;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.unit.Unit;
import static l2kstudios.gme.swing.view.GridConstants.*;

public class BoardAnimationTest {
	
	private BoardAnimation boardAnimation;
	
	private Unit unit;
	private Position unitPosition;
	
	private Graphics drawingCtx;
	
	private ArrayList<Frame> idleFrames;
	private Frame frame1;
	private Frame frame2;
	private Frame frame3;
	
	@Before
	public void setup() {
		initializeUnit();
		initializeDrawingContext();
		initializeFrames();
		
		boardAnimation = new BoardAnimation(){{
			setUnit(unit);
			setIdleFrames(idleFrames);
		}};
	}

	private void initializeUnit() {
		unit = mock(Unit.class);
		unitPosition = new Position(2, 3);
		when(unit.getPosition()).thenReturn(unitPosition);
	}
	
	private void initializeDrawingContext() {
		drawingCtx = mock(Graphics.class);
	}
	
	private void initializeFrames() {
		frame1 = new Frame(){{
			setImage(ImageLoader.getBoardSprite("Asbel-Frame-1.png", 0, 0));
			setDuration(1);
		}};
		
		frame2 = new Frame(){{
			setImage(ImageLoader.getBoardSprite("Asbel-Frame-2.png", 0, 0));
			setDuration(2);
		}};
		
		frame3 = new Frame(){{
			setImage(ImageLoader.getBoardSprite("Asbel-Frame-3.png", 0, 0));
			setDuration(3);
		}};
		
		idleFrames = new ArrayList<Frame>();
		idleFrames.add(frame1);
		idleFrames.add(frame2);
		idleFrames.add(frame3);
	}

	@Test
	public void run_singleAnimationLoop_showsAppropriateFramesAtCorrespondingTimes() {
		for(Frame frame : idleFrames) {
			runBoardAnimation(frame.getDuration());
			verifyImageDrawn(frame.getImage(), frame.getDuration());						
		}
	}
	
	@Test
	public void run_multipleAnimationLoops_animationLoops() {
		for(Frame frame : idleFrames) {
			runBoardAnimation(frame.getDuration());
			verifyImageDrawn(frame.getImage(), frame.getDuration());						
		}
		
		for(Frame frame : idleFrames) {
			runBoardAnimation(frame.getDuration());
			verifyImageDrawn(frame.getImage(), frame.getDuration() * 2);						
		}
	}
	
	private void runBoardAnimation(int numberOfFrames) {
		for(int runCount = 1; runCount <= numberOfFrames; runCount++) {
			boardAnimation.run(drawingCtx);			
		}
	}
	
	private void verifyImageDrawn(Image image, int timesDrawn) {
		Mockito.verify(drawingCtx, times(timesDrawn)).drawImage(
			image, 
			unitPosition.getX() * SPACE_WIDTH, 
			unitPosition.getY() * SPACE_HEIGHT, 
			null
		);
	}

}
