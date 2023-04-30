package spring.core.session5.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 公用邏輯: 執行 Log 紀錄相關集中管理
// 切面程式 Aspect
@Component  // 可以被 Spring 來管理的物件
@Aspect  // 是一個切面程式
@Order(1)  // 數字越小,越先被執行 (若不配置此設定，預設值是 int 的最大值)
		   // Order 的使用情境與時機是在有多個切面程式在同一個橫切關注點要執行時	
public class MyLoggerAspect {
	
}
