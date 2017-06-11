package l2kstudios.gme.model.turn;

import org.springframework.beans.factory.InitializingBean;

import l2kstudios.gme.model.interaction.Interactable;

public interface Turn extends Interactable, InitializingBean {
	
	public boolean readyToCommit();
	
	public void commit();
	
	public void update();
	
}
