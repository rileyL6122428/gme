package l2kstudios.gme.model.turn;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PhaseSequenceTest {
	
	private PhaseSequence phaseSequence;
	
	private boolean advanceFlag1;
	private boolean advanceFlag2;
	private boolean advanceFlag3;
	
	@Before
	public void setup() {
		advanceFlag1 = false;
		advanceFlag2 = false;
		advanceFlag3 = false;
		
		phaseSequence = new PhaseSequence();
		
		phaseSequence.add(new Phase(){{
			setAdvanceCallback( () -> advanceFlag1 = true );
		}});
		
		phaseSequence.add(new Phase(){{
			setAdvanceCallback( () -> advanceFlag2 = true );
			setRegressionCallback( () -> advanceFlag1 = false );
		}});
		
		phaseSequence.add(new Phase() {{
			setAdvanceCallback( () -> advanceFlag3 = true );
			setRegressionCallback( () -> advanceFlag2 = false );
		}});
	}
	
	@Test
	public void advance__callsAdvanceCallbacksInOrder() {
		assertAdvanceFlagsMatch(false, false, false);
		
		phaseSequence.advance();
		assertAdvanceFlagsMatch(true, false, false);
		
		phaseSequence.advance();
		assertAdvanceFlagsMatch(true, true, false);
		
		phaseSequence.advance();
		assertAdvanceFlagsMatch(true, true, true);
	}
	
	@Test
	public void regress__callsRegressionCallbacks() {
		assertAdvanceFlagsMatch(false, false, false);
		
		phaseSequence.advance();
		assertAdvanceFlagsMatch(true, false, false);
		
		phaseSequence.regress();
		assertAdvanceFlagsMatch(false, false, false);
		
		phaseSequence.advance();
		assertAdvanceFlagsMatch(true, false, false);
		
		phaseSequence.advance();
		assertAdvanceFlagsMatch(true, true, false);
		
		phaseSequence.regress();
		assertAdvanceFlagsMatch(true, false, false);
	}
	
	@Ignore
	@Test
	public void isFinished_allPhasesNotCompleted_returnsFalse() {
		
	}
	
	@Ignore
	@Test
	public void isFinished_allPhasesCompleted_returnsTrue() {
		
	}
	
	private void assertAdvanceFlagsMatch(boolean flag1Expected, boolean flag2Expected, boolean flag3Expected) {
		assertEquals(flag1Expected, advanceFlag1);
		assertEquals(flag2Expected, advanceFlag2);
		assertEquals(flag3Expected, advanceFlag3);
	}

}
