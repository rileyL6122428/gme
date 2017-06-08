package l2kstudios.gme.model.grid.playinggrid;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.model.unit.ConsummableStat;
import l2kstudios.gme.model.unit.Unit;
import l2kstudios.gme.testutils.SpacesFactory;

public class PathUtilTest {
	
	private PathUtil pathUtil;
	private PlayingGrid playingGrid;

	@Before
	public void setup() {
		playingGrid = new PlayingGrid();
		playingGrid.setSpaces(SpacesFactory.emptyGridSpaces(12, 12));
		
		pathUtil = new PathUtil();
		pathUtil.setPlayingGrid(playingGrid);
	}
	
	@Test
	public void moveablePaths_unitHasZeroEnergy_canOnlyMoveablePathIsToCurrentPosition() {
		Unit unit = newUnitWithEnergySetTo(0);
		playingGrid.place(unit, 5, 5);
		
		Map<Space, Path> moveablePaths = pathUtil.moveablePaths(unit);
		
		assertEquals(1, moveablePaths.keySet().size());
		
		Path onlyPath = moveablePaths.get(unit.getOccupiedSpace());
		assertEquals(1, onlyPath.getLength());
		assertEquals(unit.getOccupiedSpace(), onlyPath.getStart());
		assertEquals(unit.getOccupiedSpace(), onlyPath.getEnd());
	}
	
	@Test
	public void moveablePaths_unitHasThreeEnergyNoBlockers_moveablePathExistForAllSpacesWithinThreeSpaces() {
		Unit unit = newUnitWithEnergySetTo(3);
		playingGrid.place(unit, 5, 5);
		
		Map<Space, Path> moveablePaths = pathUtil.moveablePaths(unit);
		
		assertEquals(25, moveablePaths.keySet().size());
		
		new ArrayList<Space>(){{
			add(playingGrid.getSpaceAt(5, 2));
			
			add(playingGrid.getSpaceAt(4, 3));
			add(playingGrid.getSpaceAt(5, 3));
			add(playingGrid.getSpaceAt(6, 3));
			
			add(playingGrid.getSpaceAt(3, 4));
			add(playingGrid.getSpaceAt(4, 4));
			add(playingGrid.getSpaceAt(5, 4));
			add(playingGrid.getSpaceAt(6, 4));
			add(playingGrid.getSpaceAt(7, 4));
			
			add(playingGrid.getSpaceAt(2, 5));
			add(playingGrid.getSpaceAt(3, 5));
			add(playingGrid.getSpaceAt(4, 5));
			add(playingGrid.getSpaceAt(5, 5));
			add(playingGrid.getSpaceAt(6, 5));
			add(playingGrid.getSpaceAt(7, 5));
			add(playingGrid.getSpaceAt(8, 5));
			
			add(playingGrid.getSpaceAt(3, 6));
			add(playingGrid.getSpaceAt(4, 6));
			add(playingGrid.getSpaceAt(5, 6));
			add(playingGrid.getSpaceAt(6, 6));
			add(playingGrid.getSpaceAt(7, 6));
			
			add(playingGrid.getSpaceAt(4, 7));
			add(playingGrid.getSpaceAt(5, 7));
			add(playingGrid.getSpaceAt(6, 7));
			
			add(playingGrid.getSpaceAt(5, 8));
			
		}}.forEach( (space) -> assertNotNull(moveablePaths.get(space)) );
	}
	
	@Test
	public void moveablePaths_unitHasThreeEnergyHasBlockers_moveablePathExistForAllUnblockedSpacesWithinThreeSpaces() {
		Unit unit = newUnitWithEnergySetTo(3);
		unit.setTeam(Unit.Team.ALLY);
		
		Unit enemyUnit = new Unit();
		enemyUnit.setTeam(Unit.Team.ENEMY);
		
		playingGrid.place(unit, 5, 5);
		playingGrid.place(enemyUnit, 5, 4);
		
		Map<Space, Path> moveablePaths = pathUtil.moveablePaths(unit);
		
		assertEquals(22, moveablePaths.keySet().size());
		
		new ArrayList<Space>(){{
			add(playingGrid.getSpaceAt(4, 3));
			add(playingGrid.getSpaceAt(6, 3));
			
			add(playingGrid.getSpaceAt(3, 4));
			add(playingGrid.getSpaceAt(4, 4));
			add(playingGrid.getSpaceAt(6, 4));
			add(playingGrid.getSpaceAt(7, 4));
			
			add(playingGrid.getSpaceAt(2, 5));
			add(playingGrid.getSpaceAt(3, 5));
			add(playingGrid.getSpaceAt(4, 5));
			add(playingGrid.getSpaceAt(5, 5));
			add(playingGrid.getSpaceAt(6, 5));
			add(playingGrid.getSpaceAt(7, 5));
			add(playingGrid.getSpaceAt(8, 5));
			
			add(playingGrid.getSpaceAt(3, 6));
			add(playingGrid.getSpaceAt(4, 6));
			add(playingGrid.getSpaceAt(5, 6));
			add(playingGrid.getSpaceAt(6, 6));
			add(playingGrid.getSpaceAt(7, 6));
			
			add(playingGrid.getSpaceAt(4, 7));
			add(playingGrid.getSpaceAt(5, 7));
			add(playingGrid.getSpaceAt(6, 7));
			
			add(playingGrid.getSpaceAt(5, 8));
			
		}}.forEach( (space) -> assertNotNull(moveablePaths.get(space)) );
	}
	
	@Test
	public void moveablePaths_unitIsEnclosedByEnemyUnits_unitCannotMoveToNewSpace() {
		Unit unit = newUnitWithEnergySetTo(3);
		unit.setTeam(Unit.Team.ALLY);
		
		Unit topEnclosing = new Unit();
		topEnclosing.setTeam(Unit.Team.ENEMY);
		
		Unit rightEnclosing = new Unit();
		rightEnclosing.setTeam(Unit.Team.ENEMY);
		
		Unit leftEnclosing = new Unit();
		leftEnclosing.setTeam(Unit.Team.ENEMY);
		
		Unit bottomEnclosing = new Unit();
		bottomEnclosing.setTeam(Unit.Team.ENEMY);
		
		playingGrid.place(unit, 5, 5);
		playingGrid.place(topEnclosing, 5, 4);
		playingGrid.place(rightEnclosing, 6, 5);
		playingGrid.place(bottomEnclosing, 5, 6);
		playingGrid.place(leftEnclosing, 4, 5);
		
		Map<Space, Path> moveablePaths = pathUtil.moveablePaths(unit);
		assertEquals(1, moveablePaths.keySet().size());
		assertNotNull(moveablePaths.get(playingGrid.getSpaceAt(5, 5)));
	}
	
	@Test
	public void moveablePaths_unitHasFourEnergyWithBlockers_moveablePathExistForAllNonBlockedSpacesWithinFourSpaces() {
		Unit unit = newUnitWithEnergySetTo(4);
		unit.setTeam(Unit.Team.ALLY);
		
		Unit blockerAtFiveFour = new Unit();
		blockerAtFiveFour.setTeam(Unit.Team.ENEMY);
		
		Unit blockerAtSixFour = new Unit();
		blockerAtSixFour.setTeam(Unit.Team.ENEMY);
		
		Unit blockerAtNineFive = new Unit();
		blockerAtNineFive.setTeam(Unit.Team.ENEMY);
		
		Unit blockerAtEightSix = new Unit();
		blockerAtEightSix.setTeam(Unit.Team.ENEMY);
		
		Unit blockerAtThreeFive = new Unit();
		blockerAtThreeFive.setTeam(Unit.Team.ENEMY);
		
		Unit blockerAtThreeSeven = new Unit();
		blockerAtThreeSeven.setTeam(Unit.Team.ENEMY);
		
		playingGrid.place(unit, 5, 5);
		playingGrid.place(blockerAtFiveFour, 5, 4);
		playingGrid.place(blockerAtSixFour, 6, 4);
		playingGrid.place(blockerAtNineFive, 9, 5);
		playingGrid.place(blockerAtThreeFive, 3, 5);
		playingGrid.place(blockerAtThreeSeven, 3, 7);
		playingGrid.place(blockerAtEightSix, 8, 6);
		
		Map<Space, Path> moveablePaths = pathUtil.moveablePaths(unit);
		
		assertEquals(29, moveablePaths.keySet().size());
		
		new ArrayList<Space>(){{
			add(playingGrid.getSpaceAt(4, 2));
			
			add(playingGrid.getSpaceAt(3, 3));
			add(playingGrid.getSpaceAt(4, 3));
			add(playingGrid.getSpaceAt(5, 3));
			add(playingGrid.getSpaceAt(7, 3));
			
			add(playingGrid.getSpaceAt(2, 4));
			add(playingGrid.getSpaceAt(3, 4));
			add(playingGrid.getSpaceAt(4, 4));
			add(playingGrid.getSpaceAt(7, 4));
			add(playingGrid.getSpaceAt(8, 4));
			
			add(playingGrid.getSpaceAt(4, 5));
			add(playingGrid.getSpaceAt(5, 5));
			add(playingGrid.getSpaceAt(6, 5));
			add(playingGrid.getSpaceAt(7, 5));
			add(playingGrid.getSpaceAt(8, 5));
			
			add(playingGrid.getSpaceAt(2, 6));
			add(playingGrid.getSpaceAt(3, 6));
			add(playingGrid.getSpaceAt(4, 6));
			add(playingGrid.getSpaceAt(5, 6));
			add(playingGrid.getSpaceAt(6, 6));
			add(playingGrid.getSpaceAt(7, 6));
			
			add(playingGrid.getSpaceAt(4, 7));
			add(playingGrid.getSpaceAt(5, 7));
			add(playingGrid.getSpaceAt(6, 7));
			add(playingGrid.getSpaceAt(7, 7));
			
			add(playingGrid.getSpaceAt(4, 8));
			add(playingGrid.getSpaceAt(5, 8));
			add(playingGrid.getSpaceAt(6, 8));
			
			add(playingGrid.getSpaceAt(5, 9));
			
		}}.forEach( (space) -> assertNotNull(moveablePaths.get(space)) );
	}
	
	private Unit newUnitWithEnergySetTo(long energyVal) {
		return new Unit(){{
			setEnergy(new ConsummableStat(){{
				setCap(energyVal);
				setVal(energyVal);
			}});
		}};
	}

}
