package spring.core.session05.aop_lab;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Component // 若 AOPConfig 有針對此類設定 @Bean，則此行可以不用配置
@Aspect // 觀眾：切面程式
public class Audience {
	
	@Pointcut(value = "execution(* spring.core.session05.aop_lab.Performance.perform(..))")
	public void pt() { }
	
	@Before(value = "pt()")
	public void slienceCellPhone() {
		System.out.println("觀眾-將手機設為靜音");
	}
	
	@Before(value = "pt()")
	public void takeSeats() {
		System.out.println("觀眾-找到座位");
	}
	
	@After(value = "pt()")
	public void exit() {
		System.out.println("觀眾-拍手鼓掌");
	}
	
	@AfterReturning(value = "pt()")
	public void applause() {
		System.out.println("觀眾-離開表演會場");
	}
	
	@AfterThrowing(value = "pt()", throwing = "ex") 
	public void exception(Throwable ex) { // 發生例外
		System.out.println("觀眾-加油加油~噓聲..." + ex);
	}
}
