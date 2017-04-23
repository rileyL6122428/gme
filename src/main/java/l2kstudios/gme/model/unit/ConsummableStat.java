package l2kstudios.gme.model.unit;

import org.springframework.beans.factory.InitializingBean;

public class ConsummableStat implements InitializingBean {
	
	private long cap;
	private long val;
	
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
}
