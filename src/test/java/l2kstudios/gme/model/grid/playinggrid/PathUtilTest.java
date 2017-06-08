package l2kstudios.gme.model.grid.playinggrid;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
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
	
//	@Ignore
	@Test
	public void moveablePaths_unitHasZeroEnergy_canOnlyMoveablePathIsToCurrentPosition() {
		Unit unit = newUnitWithEnergySetTo(0);
		
		playingGrid.place(unit, 5, 5);
		
		Map<Space, Path> moveablePaths = pathUtil.moveablePaths(unit);
		
		assertEquals(1, moveablePaths.keySet().size());
		Path onlyPath = moveablePaths.get(unit.getOccupiedSpace());
		assertEquals(unit.getOccupiedSpace(), onlyPath.getStart());
//		assertEquals()
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
