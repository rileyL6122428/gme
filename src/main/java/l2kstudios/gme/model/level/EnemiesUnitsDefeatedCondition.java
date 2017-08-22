package l2kstudios.gme.model.level;

public class EnemiesUnitsDefeatedCondition extends LevelFinishedCondition {

	public EnemiesUnitsDefeatedCondition(Level level) {
		super(level);
	}

	@Override
	public boolean getAsBoolean() {
		return playingGrid.getEnemyUnits().size() == 0;
	}

}
