package test.test4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("computer")
public class Computer {
	private String cpu;
	private String ram;
	private String hdd;
	@Autowired
	private Monitor monitor;
	
	public String getCpu() {
		return cpu;
	}

	@Autowired
	@Qualifier("cpu1")
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	@Autowired
	@Qualifier("ram1")
	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getHdd() {
		return hdd;
	}

	public void setHdd(String hdd) {
		this.hdd = hdd;
	}

	@Override
	public String toString() {
		return "Computer [cpu=" + cpu + ", ram=" + ram + ", hdd=" + hdd + ", monitor=" + monitor + "]";
	}


}
