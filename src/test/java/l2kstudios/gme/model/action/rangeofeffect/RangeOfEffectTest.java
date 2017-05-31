package l2kstudios.gme.model.action.rangeofeffect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import l2kstudios.gme.model.grid.PlayingGrid;
import l2kstudios.gme.model.grid.Position;
import l2kstudios.gme.model.grid.Space;
import l2kstudios.gme.testutils.SpacesFactory;

@RunWith(PowerMockRunner.class)
public class RangeOfEffectTest {
	
	private RangeOfEffect rangeOfEffect;
	
	private PlayingGrid playingGrid;
	
	@Before
	public void setup() {
		rangeOfEffect = new RangeOfEffect(){{
			deltas = new ArrayList<Delta>(){{
				add(new Delta(0,0));
				add(new Delta(1,0));
				add(new Delta(-1,0));
				add(new Delta(0,1));
				add(new Delta(0,-1));
			}};
		}};
		
		playingGrid = new PlayingGrid();
		playingGrid.setSpaces(SpacesFactory.emptyGridSpaces(8, 8));
		
		rangeOfEffect.setPlayingGrid(playingGrid);
	}
	
	@Test
	public void affectedSpaces_allSpacesDerivedFromDeltasInBounds_returnsAllSpacesDerivedFromDeltas() {
		List<Space> spaces = rangeOfEffect.affectedSpaces(new Position(3, 3));
		
		assertEquals(5, spaces.size());
		assertListContainsSpaceWithCoordsSetTo(3, 3, spaces);
		assertListContainsSpaceWithCoordsSetTo(4, 3, spaces);
		assertListContainsSpaceWithCoordsSetTo(2, 3, spaces);
		assertListContainsSpaceWithCoordsSetTo(3, 2, spaces);
		assertListContainsSpaceWithCoordsSetTo(3, 4, spaces);
	}
	
	@Test
	public void affectedSpaces_NotAllSpacesDerivedFromDeltasInBounds_returnedSpacesExcludeOutOfBoundSpaces() {
		List<Space> spaces = rangeOfEffect.affectedSpaces(new Position(0, 0));
		
		assertEquals(3, spaces.size());
		assertListContainsSpaceWithCoordsSetTo(0, 0, spaces);
		assertListContainsSpaceWithCoordsSetTo(1, 0, spaces);
		assertListContainsSpaceWithCoordsSetTo(0, 1, spaces);
	}
	
	private void assertListContainsSpaceWithCoordsSetTo(int x, int y, List<Space> spaces) {
		for(Space space : spaces) {
			Position position = space.getPosition();
			if(position.getX() == x && position.getY() == y) return;
		}
		
		fail("Spaces list did not contain space with coords x=" + x + ", y=" + y);
	}

}
