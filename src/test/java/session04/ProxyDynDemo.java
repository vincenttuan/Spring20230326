package session04;

import spring.core.session04.proxy.dyn.Calc;
import spring.core.session04.proxy.dyn.CalcImpl;
import spring.core.session04.proxy.dyn.DynProxy;
import spring.core.session04.proxy.sta.Man;
import spring.core.session04.proxy.sta.Person;

public class ProxyDynDemo {

	public static void main(String[] args) {
		// 透過動態代理來執行
		Person man = (Person)new DynProxy(new Man()).getProxy();
		man.work();
		
		Calc calc = (Calc)new DynProxy(new CalcImpl()).getProxy();
		System.out.println(calc.add(10, 5));
		System.out.println(calc.div(10, 5));
		System.out.println(calc.div(10, 0));
	}

}
