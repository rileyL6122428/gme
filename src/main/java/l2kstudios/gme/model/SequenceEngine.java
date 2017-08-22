package l2kstudios.gme.model;

import java.awt.Graphics;
import java.util.LinkedList;

import l2kstudios.gme.model.interaction.Input;
import l2kstudios.gme.model.interaction.Interface;

public class SequenceEngine implements Interface {
	
	protected LinkedList<Interaction> interactionSequence;
	
	public void update() {
		if(getCurrentInteraction().isFinished()) 
			interactionSequence.removeFirst();
	}
	
	@Override
	public void draw(Graphics drawingCtx) {
		getCurrentInteraction().draw(drawingCtx);
	}

	@Override
	public void receiveInput(Input input) {
		getCurrentInteraction().receiveInput(input);
	}
	
	private Interaction getCurrentInteraction() {
		return interactionSequence.getFirst();
	}

	public LinkedList<Interaction> getInterationSequence() {
		return interactionSequence;
	}

	public void setInterationSequence(LinkedList<Interaction> interationSequence) {
		this.interactionSequence = interationSequence;
	}
	
}
