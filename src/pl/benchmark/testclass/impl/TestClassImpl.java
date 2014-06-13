package pl.benchmark.testclass.impl;

import pl.benchmark.testclass.TestClass;

public class TestClassImpl implements TestClass{
	
	public String s = "Test";
	public int i = 10;
	
	private String privS = "Priv Test";
	private int privI = 11;
	
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public String getPrivS() {
		return privS;
	}
	public void setPrivS(String privS) {
		this.privS = privS;
	}
	public int getPrivI() {
		return privI;
	}
	public void setPrivI(int privI) {
		this.privI = privI;
	}

	public void testMethod(){
		int i = 0;
		i++;
	}

}
