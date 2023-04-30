package session05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.core.session05.aop_lab.AOPConfig;
import spring.core.session05.aop_lab.Dancer;
import spring.core.session05.aop_lab.Performance;
import spring.core.session05.aop_lab.Singer;

public class AOPLabTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AOPConfig.class);
		Performance dancer = ctx.getBean("dancer", Performance.class);
		
		try {
			dancer.perform(); // 執行表演
		} catch (Exception e) {
			System.out.println(e); // 例外發生了
			// 轉換跑道
			// 透過 introductor(經紀人) 協助轉換跑道
			// 改行去唱歌
			System.out.println("舞者 dancer 轉歌者 back singer");
			Singer singer = (Singer)dancer;
			singer.sing();
			System.out.println("轉型成功");
		}
	}

}
