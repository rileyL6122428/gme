package l2kstudios.gme.model.grid.playinggrid;

import static org.junit.Assert.*;

import java.util.Iterator;

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
	
	@Ignore
	@Test
	public void pathToExists_spaceWithinUnitMoveRangeWithNoBlockers_returnsTrue() {
		Unit unit = newUnitWithEnergySetTo(3);
		playingGrid.place(unit, 0, 0);
		
		assertTrue(pathUtil.pathExistsToSpaceForUnit(playingGrid.getSpaceAt(3, 0), unit));		
	}
	
	@Ignore
	@Test
	public void pathToExists_spaceOutOfUnitMoveRange_returnsFalse() {
		Unit unit = newUnitWithEnergySetTo(3);
		playingGrid.place(unit, 0, 0);
		assertFalse(pathUtil.pathExistsToSpaceForUnit(playingGrid.getSpaceAt(4, 0), unit));		
	}
	
	@Ignore
	@Test
	public void pathToExists_spaceWithinUnitMoveRangeWithBlockers_returnsFalse() {
		Unit unit = newUnitWithEnergySetTo(3);
		playingGrid.place(unit, 0, 0);
		assertTrue(pathUtil.pathExistsToSpaceForUnit(playingGrid.getSpaceAt(3, 0), unit));		
	}
	
//	@Ignore
	@Test
	public void directPath_onlyOnePathExists_returnsOnlyPossibleDirectPath() {
		Unit unit = newUnitWithEnergySetTo(5);
		playingGrid.place(unit, 0, 0);
		
		Path path = pathUtil.directPathToSpaceForUnit(playingGrid.getSpaceAt(5, 0), unit);
		
		assertEquals(6, path.getLength());
		
		Iterator<Space> pathIterator = path.getIterator();
		assertEquals(playingGrid.getSpaceAt(0, 0),pathIterator.next());
		assertEquals(playingGrid.getSpaceAt(1, 0),pathIterator.next());
		assertEquals(playingGrid.getSpaceAt(2, 0),pathIterator.next());
		assertEquals(playingGrid.getSpaceAt(3, 0),pathIterator.next());
		assertEquals(playingGrid.getSpaceAt(4, 0),pathIterator.next());
		assertEquals(playingGrid.getSpaceAt(5, 0),pathIterator.next());
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
