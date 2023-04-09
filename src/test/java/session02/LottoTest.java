package session02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session02.bean.Lotto;

public class LottoTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config2.xml");
		Lotto lotto1 = ctx.getBean("lotto", Lotto.class);
		Lotto lotto2 = ctx.getBean("lotto", Lotto.class);
		System.out.println(lotto1);
		System.out.println(lotto2);

	}

}
