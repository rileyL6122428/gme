package l2kstudios.gme.swing.gameinterface.turn;

import l2kstudios.gme.model.level.Level;

public class ComputerPlayerFactory {
	
	public static ComputerPlayer newComputerPlayer(Level level) {
		ComputerPlayer computerPlayer = new ComputerPlayer();
		
		computerPlayer.setActingUnit(level.getActingUnit());
		computerPlayer.setPlayingGrid(level.getPlayingGrid());
		
		return computerPlayer;
	}

}
