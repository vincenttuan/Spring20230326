package spring.core.session05.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class MySecurityAspect {
	@Pointcut(value = "execution(* spring.core.session05.aop.ComputerImpl.*(..))")
	public void pt() { }
	
	// 環繞通知
	
}
