package l2kstudios.gme.model.unit;

import org.springframework.beans.factory.InitializingBean;
import static java.lang.Math.*;

public class Stat implements InitializingBean {
	
	private String name;
	private long maxCap;
	private long cap;
	private long val;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getVal() {
		return val;
	}
	public void setVal(long currentVal) {
		this.val = currentVal;
	}
	
	public long getCap() {
		return cap;
	}
	public void setCap(long cap) {
		this.cap = cap;
	}
	
	public void afterPropertiesSet() throws Exception {
		val = cap;	
	}
	public long getMaxCap() {
		return maxCap;
	}
	public void setMaxCap(long maxCap) {
		this.maxCap = maxCap;
	}
	
	public void decreaseVal(long amount) {
		val = max(0, val - amount);
	}
	
	public void increaseVal(long amount) {
		val = min(cap, val + amount);
	}
}
