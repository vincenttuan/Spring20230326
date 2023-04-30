package spring.core.session5.aop;

public class CalcImpl implements Calc {

	@Override
	public Integer add(Integer x, Integer y) {
		int result = x + y;
		return result;
	}

	@Override
	public Integer div(Integer x, Integer y) {
		int result = x / y;
		return result;
	}
	
}
