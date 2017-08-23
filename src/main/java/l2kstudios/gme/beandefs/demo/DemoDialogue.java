package l2kstudios.gme.beandefs.demo;

import java.util.LinkedList;
import java.util.List;

import l2kstudios.gme.model.dialogue.BaseDialogue;
import l2kstudios.gme.model.dialogue.Paragraph;

public class DemoDialogue extends BaseDialogue {
	
	{
		paragraphs = new LinkedList<Paragraph>(){{
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
		}};
		
	}
	
}
