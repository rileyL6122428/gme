package l2kstudios.gme.model.dialogue;

import java.util.LinkedList;

public class Dialogue {
	
	private LinkedList<Paragraph> paragraphs;
	
	public Paragraph getCurrentParagraph() {
		return getParagraphs().getFirst();
	}
	
	public void advanceParagraph() {
		getParagraphs().removeFirst();
	}
	
	public boolean isFinished() {
		return getParagraphs().isEmpty();
	}

	public LinkedList<Paragraph> getParagraphs() {
		return paragraphs;
	}

	public void setParagraphs(LinkedList<Paragraph> paragraphs) {
		this.paragraphs = paragraphs;
	}

}
