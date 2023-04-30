package spring.core.session05.aop_lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 本次範例使用 Java 配置取代 xml 配置
@Configuration // 此為配置檔
@EnableAspectJAutoProxy // 讓 Spring AOP 切面自動代理
//@ComponentScan(basePackages = {"spring.core.session05.aop_lab"}) // 啟動元件掃描
@ComponentScan() // 啟動元件掃描(掃描當前路徑)
public class AOPConfig {
	
	@Bean(name = "dancer") // 若 name 的名稱與方法名相同，可以忽略不寫
	public Performance dancer() {
		Dancer dancer = new Dancer();
		return dancer;
	}
}
