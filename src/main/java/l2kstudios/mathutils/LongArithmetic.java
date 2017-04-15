package l2kstudios.mathutils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LongArithmetic {
	
	public static long lcm(List<Long> nums) {
		List<Long> uniqueNums = new ArrayList<Long>(new HashSet<Long>(nums));
		long lcm = product(uniqueNums);
		
		for(long num = 2; num < Math.sqrt(lcm); num++) {
			while(lcm % num == 0 && divisibleByAll((lcm / num), uniqueNums)) {
				lcm /= num;
			}
		}
		
		return lcm;
	}
	
	private static boolean divisibleByAll(long num, List<Long> divisors) {
		for(Long divisor : divisors) {
			if(num % divisor != 0) return false;
		}
		
		return true;
	}
	
	private static long product(List<Long> nums) {
		long numsProduct = 1;
		
		for(Long num : nums) {
			numsProduct *= num;
		}
		
		return numsProduct;
	}

	public static List<Long> invertDivisors(Long num, List<Long> divisors) {
		List<Long> invertedDivisors = new ArrayList<Long>(divisors.size());
		
		for(Long divisor : divisors) {
			invertedDivisors.add(num / divisor);
		}
		
		return invertedDivisors;
	}
}
