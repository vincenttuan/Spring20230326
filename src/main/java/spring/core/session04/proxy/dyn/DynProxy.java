package spring.core.session04.proxy.dyn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 動態代理
public class DynProxy {
	
	// 被代理對象
	private Object object;
	
	public DynProxy(Object object) {
		this.object = object;
	}
	
	// 取得代理對象
	public Object getProxy() {
		Object proxyObj = null;
		// 1. 類別載入器
		ClassLoader loader = object.getClass().getClassLoader();
		// 2. 被代理對象所實作的介面
		Class<?>[] interfaces = object.getClass().getInterfaces();
		// 3. 處理代理的實現
		// InvocationHandler 是一個接口，該接口只有一個方法 invoke()，用於處理代理對象方法的調用。
		// 當動態代理生成代理類別後，當代理對象的方法被調用時，實際上是通過 InvocationHandler 的 invoke() 方法來執行的。
        InvocationHandler handler = (Object proxy, Method method, Object[] args) -> {
        	Object result = null;
        	
        	// before: 前置通知-公用方法
        	System.out.println("before: 前置通知-公用方法");
        	
        	try {
	        	// 調用被代理物件的-業務方法
	        	result = method.invoke(object, args); // object: 被代理物件, args: 方法參數
	        	
        	} catch(Exception e) {
        		// exception: 例外通知-公用方法 
        		System.out.println("exception: 例外通知-公用方法");
        	} finally {
        		// end: 後置通知-公用方法
            	System.out.println("end: 後置通知-公用方法");
			}
        	
        	return result;
        };
		
        // 取得代理對象
		proxyObj = Proxy.newProxyInstance(loader, interfaces, handler);
		return proxyObj;
	}
}
