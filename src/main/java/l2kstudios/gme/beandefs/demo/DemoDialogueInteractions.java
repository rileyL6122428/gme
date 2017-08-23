package l2kstudios.gme.beandefs.demo;

import java.util.LinkedList;

import l2kstudios.gme.model.dialogue.Dialogue;
import l2kstudios.gme.model.dialogue.DialogueInteraction;
import l2kstudios.gme.model.dialogue.Paragraph;

public class DemoDialogueInteractions extends DialogueInteraction {
	
	{
		dialogue = new Dialogue(){{
			
			 setParagraphs(new LinkedList<Paragraph>(){{
				add(new Paragraph(){{
					setContent("THIS IS A SAMPLE PARAGRAPH 1");
				}});
				
				add(new Paragraph(){{
					setContent("THIS IS A SAMPLE PARAGRAPH 2");
				}});
				
				add(new Paragraph(){{
					setContent("THIS IS A SAMPLE PARAGRAPH 3");
				}});
				
				add(new Paragraph(){{
					setContent("THIS IS A SAMPLE PARAGRAPH 4");
				}});
				
				add(new Paragraph(){{
					setContent("THIS IS A SAMPLE PARAGRAPH 5");
				}});
			}});
			
		}};
		
		
		
	}
	
}
