package spring.core.session05.aop_lab;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Introductor {
	
	// 定義從哪個類要轉成哪個類(橫向轉型設定) ?
	// Performance -> Singer
	// + 表示該類與其子類
	@DeclareParents(
			value = "spring.core.session05.aop_lab.Performance+",
			defaultImpl = BackSinger.class
	)
	public Singer singer;
	
}
