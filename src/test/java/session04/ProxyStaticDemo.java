package session04;

import spring.core.session04.proxy.sta.Man;
import spring.core.session04.proxy.sta.Person;
import spring.core.session04.proxy.sta.Woman;

public class ProxyStaticDemo {

	public static void main(String[] args) {
		// 不透過代理直接執行
		Person man = new Man();
		Person woman = new Woman();
		man.work();
		woman.work();

	}

}
