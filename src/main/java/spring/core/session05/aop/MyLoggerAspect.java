package spring.core.session05.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 公用邏輯: 執行 Log 紀錄相關集中管理
// 切面程式 Aspect
@Component  // 可以被 Spring 來管理的物件
@Aspect  // 是一個切面程式
@Order(1)  // 數字越小,越先被執行 (若不配置此設定，預設值是 int 的最大值)
		   // Order 的使用情境與時機是在有多個切面程式在同一個橫切關注點要執行時	
public class MyLoggerAspect {
	
	// 前置通知
	@Before(value = "execution(public Integer spring.core.session05.aop.CalcImpl.add(Integer, Integer))") // 注入方法簽章
	public void beforeAdvice(JoinPoint joinPoint) { // JoinPoint 連接點
		String methodName = joinPoint.getSignature().getName(); // 得到連接點的方法名稱
		Object[] args = joinPoint.getArgs(); // 得到連接點的方法參數內容
		System.out.printf("呼叫前置通知 - 方法名稱：%s 方法參數：%s\n", methodName, Arrays.toString(args));
	}
	
}
