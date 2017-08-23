package l2kstudios.gme.beandefs.demo;

import java.util.LinkedList;

import l2kstudios.gme.model.Interaction;
import l2kstudios.gme.model.SequenceEngine;

public class DemoSequenceEngine extends SequenceEngine {
	
	{
		interactionSequence = new LinkedList<Interaction>();
		
		interactionSequence.add(new DemoDialogueInteractions());
		interactionSequence.add(new DemoLevelInteraction());
	}
	
}
