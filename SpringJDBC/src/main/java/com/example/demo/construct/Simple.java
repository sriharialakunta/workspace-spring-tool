package com.example.demo.construct;

import org.springframework.stereotype.Component;

@Component
public class Simple {
	
	private String sname;

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Simple() {
		super();
	}
	public Simple(String sname) {
		super();
		this.sname = sname;
	}

	@Override
	public String toString() {
		return "Simple [sname=" + sname + "]";
	}
	

}
