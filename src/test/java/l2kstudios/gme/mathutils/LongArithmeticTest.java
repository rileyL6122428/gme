package l2kstudios.gme.mathutils;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import l2kstudios.mathutils.LongArithmetic;

public class LongArithmeticTest {

	static class LCMTestData {
		private List<Long> nums;
		private long expectedLCM;
		
		public long getExpectedLCM() {
			return expectedLCM;
		}
		public void setExpectedLCM(long expectedLCM) {
			this.expectedLCM = expectedLCM;
		}
		public List<Long> getNums() {
			return nums;
		}
		public void setNums(List<Long> nums) {
			this.nums = nums;
		}
	}
	
	LCMTestData[] lcmTestData = new LCMTestData[]{
		new LCMTestData(){{ 
			setNums(new ArrayList<Long>(){{ 
				add(11l); 
				add(7l); 
				add(3l);
			}});
			
			setExpectedLCM(231l);
		}},
		
		new LCMTestData(){{ 
			setNums(new ArrayList(){{ 
				add(2l); 
				add(2l); 
			}});
			
			setExpectedLCM(2l);
		}},
		
		new LCMTestData(){{ 
			setNums(new ArrayList<Long>() {{
				add(2l);
				add(4l);
				add(8l);
			}});
			
			setExpectedLCM(8l);
		}},
		
		new LCMTestData(){{ 
			setNums(new ArrayList<Long> () {{
				add(2l);
				add(4l);
				add(5l);
			}});
			
			setExpectedLCM(20l);
		}}
	};
	
	@Test
	public void lcm__calculatesTheExpectedLCM() {		
		Arrays.asList(lcmTestData).forEach((dataSet) -> {
			assertEquals(dataSet.getExpectedLCM(), LongArithmetic.lcm(dataSet.getNums()));
		});
		
	}
	
	class InvertDivisorsTestData {
		private List<Long> divisors;
		private long num;
		private List<Long> expectedInvertedDivisors;
		public List<Long> getDivisors() {
			return divisors;
		}
		public void setDivisors(List<Long> divisors) {
			this.divisors = divisors;
		}
		public long getNum() {
			return num;
		}
		public void setNum(long num) {
			this.num = num;
		}
		public List<Long> getExpectedInvertedDivisors() {
			return expectedInvertedDivisors;
		}
		public void setExpectedInvertedDivisors(List<Long> expectedInvertedDivisors) {
			this.expectedInvertedDivisors = expectedInvertedDivisors;
		}
	}
	
	private List<InvertDivisorsTestData> invertDivisorsTestData = new ArrayList<InvertDivisorsTestData>() {{
		add(new InvertDivisorsTestData(){{
			setNum(12);
			setDivisors(new ArrayList<Long>() {{
				add(12l);
				add(6l);
				add(4l);
				add(3l);
				add(2l);
				add(1l);
			}});
			
			setExpectedInvertedDivisors(new ArrayList<Long>() {{
				add(1l);
				add(2l);
				add(3l);
				add(4l);
				add(6l);
				add(12l);
			}});
		}});
	}};
	
	@Test
	public void invertDivisors__returnsTheExpectedInvertedDivisors() {
		invertDivisorsTestData.forEach((data) -> {
			List<Long> invertedDivisors = LongArithmetic.invertDivisors(data.getNum(), data.getDivisors());
			List<Long> expectedInvertedDivisors = data.getExpectedInvertedDivisors();
			
			assertEquals(expectedInvertedDivisors.size(), invertedDivisors.size());
			for(int idx = 0; idx < invertedDivisors.size(); idx++) {
				assertEquals(expectedInvertedDivisors.get(idx), invertedDivisors.get(idx));
			}
		});
	}
	
	@Test
	public void deliberatelyBrokenTest() {
		assertTrue(false);
	}
}
