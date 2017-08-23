package l2kstudios.gme.model.dialogue;

import java.awt.Graphics;

import l2kstudios.gme.model.Interaction;
import l2kstudios.gme.model.interaction.Input;

public class DialogueInteraction implements Interaction {
	
	protected Dialogue dialogue;

	@Override
	public void draw(Graphics drawingCtx) {
		Paragraph paragraph = getDialogue().getCurrentParagraph();
		
		drawingCtx.drawString(
			paragraph.getContent(), 
			20, 
			20
		);
	}

	@Override
	public void receiveInput(Input input) {
		getDialogue().advanceParagraph();
	}

	@Override
	public boolean isFinished() {
		return getDialogue().isFinished();
	}

	public Dialogue getDialogue() {
		return dialogue;
	}

	public void setDialogue(Dialogue dialogue) {
		this.dialogue = dialogue;
	}

}
