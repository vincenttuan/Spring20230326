package spring.core.session04.proxy.sta;

public class Child implements Person {

	@Override
	public void work() {
		// 業務邏輯
		System.out.println(getClass().getSimpleName() + "去學校上課");
		// ... 其他必要程序 ...
	}

}
