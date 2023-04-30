package spring.core.session05.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 公用邏輯: 執行 Log 紀錄相關集中管理
// 切面程式 Aspect
@Component  // 可以被 Spring 來管理的物件
@Aspect  // 是一個切面程式
@Order(1)  // 數字越小,越先被執行 (若不配置此設定，預設值是 int 的最大值)
		   // Order 的使用情境與時機是在有多個切面程式在同一個橫切關注點要執行時	
public class MyLoggerAspect {
	// 建立一個切入點的方法
	@Pointcut(value = "execution(* spring.core.session05.aop.CalcImpl.*(..))")
	public void pt() { }
	@Pointcut(value = "execution(* spring.core.session05.aop.CalcImpl.div(..))")
	public void pt2() { }
	
	// 前置通知
	//@Before(value = "execution(public Integer spring.core.session05.aop.CalcImpl.add(Integer, Integer))") // 注入方法簽章
	//@Before(value = "execution(public Integer spring.core.session05.aop.CalcImpl.add(..))") // 不限方法參數
	//@Before(value = "execution(public Integer spring.core.session05.aop.CalcImpl.*(..))") // 不限方法名稱、方法參數
	//@Before(value = "execution(* spring.core.session05.aop.CalcImpl.*(..))") // 不限權限、回傳值、方法名稱、方法參數
	//@Before(value = "execution(* spring.core.session05.aop.*.*(..))") // 不限權限、回傳值、類別、方法名稱、方法參數
	//@Before(value = "execution(* *(..))") // 全部都攔截
	//@Before(value = "pt() && !pt2()") // 切入表達式支援 &&、||、!
	@Before(value = "pt()")
	public void beforeAdvice(JoinPoint joinPoint) { // JoinPoint 連接點
		String methodName = joinPoint.getSignature().getName(); // 得到連接點的方法名稱
		Object[] args = joinPoint.getArgs(); // 得到連接點的方法參數內容
		System.out.printf("呼叫前置通知 - 方法名稱：%s 方法參數：%s\n", methodName, Arrays.toString(args));
	}
	
	// 後製通知 (無論是否有拋出例外都會執行，所以後製通知在Spring-AOP機制上會自動放在 finally 區段中)
	@After(value = "pt()")
	public void afterAdvice() { // 或 afterAdvice(JoinPoint joinPoint)
		System.out.printf("呼叫後置通知\n");
	}
	
	// 異常通知 (可以設定 throwing 異常通知變數 ex)
	@AfterThrowing(value = "pt()", throwing = "ex")
	public void afterThrowingAdvice(Exception ex) { // 方法參數 ex 必須與 throwing = "ex" 內容名稱設定相同
		System.out.printf("呼叫異常通知 - ex：%s\n", ex);
	}
	
}
