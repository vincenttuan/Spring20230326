package spring.core.session04.proxy.sta;

// 靜態代理
// 代理物件就是代理執行任務
public class PersonProxy implements Person {
	
	// 代理對象
	private Person person;
	
	public PersonProxy(Person person) { // person 可能是 Man、Woman 的實例
		this.person = person;
	}
	
	@Override
	public void work() {
		// 公用邏輯
		System.out.println("出門戴口罩");
		
		// 代理執行代理對象的業務方法
		person.work();
		
		// 公用邏輯
		System.out.println("回家脱口罩");
	}

}
