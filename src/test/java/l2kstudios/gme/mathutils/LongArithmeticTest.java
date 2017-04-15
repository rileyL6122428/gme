package l2kstudios.gme.mathutils;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
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
	
	List<InvertDivisorsTestData> invertDivisorsTestData = new ArrayList<InvertDivisorsTestData>() {{
		
	}};
	
	@Ignore
	@Test
	public void invertDivisors__returnsTheExpectedInvertedDivisors() {
		
	}
}
