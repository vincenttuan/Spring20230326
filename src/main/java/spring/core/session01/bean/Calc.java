package spring.core.session01.bean;

public class Calc {
	
	private int result;
	
	public void add(int x, int y) {
		result = x + y;
	}
	
	public int getResult() {
		return result;
	}
	
}
