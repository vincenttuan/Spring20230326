package spring.core.session05.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
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
	// 注意：要進行環繞通知測試前，請先將其他 XX 通知關閉
	@Around(value = "pt()")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
		// 建立返回值變數
		Object result = null;
		try {
			// 1. 前置通知
			
			// 代理執行業務邏輯方法(重要！)
			result = joinPoint.proceed();
			
			// 2. 返回通知
			
		} catch (Throwable ex) {
			// 3. 例外通知
			
		} finally {
			// 4. 後置通知
			
		}
		
		return result;
	}
}
