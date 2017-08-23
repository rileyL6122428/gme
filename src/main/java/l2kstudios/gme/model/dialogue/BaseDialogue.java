package l2kstudios.gme.model.dialogue;

import java.awt.Graphics;
import java.util.LinkedList;

import l2kstudios.gme.model.interaction.Input;

public class BaseDialogue implements Dialogue {
	
	protected LinkedList<Paragraph> paragraphs;

	@Override
	public void draw(Graphics drawingCtx) {
		drawingCtx.drawString(
			getCurrentParagraph().getContent(), 
			20, 
			20
		);
	}

	@Override
	public void receiveInput(Input input) {
		advanceParagraph();
	}

	@Override
	public boolean isFinished() {
		return paragraphs.isEmpty();
	}
	
	private Paragraph getCurrentParagraph() {
		return paragraphs.getFirst();
	}
	
	private void advanceParagraph() {
		paragraphs.removeFirst();
	}

}
