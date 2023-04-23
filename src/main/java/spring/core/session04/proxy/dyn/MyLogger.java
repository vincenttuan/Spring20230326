package spring.core.session04.proxy.dyn;

// 集中公用邏輯
// Aspect 切面程式
public class MyLogger {
	// before: 前置通知-公用方法
	public static void before() {
		System.out.println("before: 前置通知-公用方法");
	}
	
	// exception: 例外通知-公用方法
	public static void throwing() {
		System.out.println("exception: 例外通知-公用方法");
	}

	// end: 後置通知-公用方法
	public static void end() {
		System.out.println("end: 後置通知-公用方法");
	}
}
