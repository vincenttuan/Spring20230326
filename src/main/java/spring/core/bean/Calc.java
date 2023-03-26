package spring.core.bean;

public class Calc {
	
	private int result;
	
	public void add(int x, int y) {
		result = x + y;
	}
	
	public int getResult() {
		return result;
	}
	
}
