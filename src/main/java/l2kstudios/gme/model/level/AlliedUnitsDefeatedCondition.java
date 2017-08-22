package l2kstudios.gme.model.level;

public class AlliedUnitsDefeatedCondition extends LevelFinishedCondition {

	public AlliedUnitsDefeatedCondition(Level level) {
		super(level);
	}

	@Override
	public boolean getAsBoolean() {
		return playingGrid.getAlliedUnits().size() == 0;
	}

}
