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
        InvocationHandler handler = (Object proxy, Method method, Object[] args) -> {
        	Object result = null;
        	
        	// 調用被代理物件的業務方法
        	result = method.invoke(object, args); // object: 被代理物件, args: 方法參數
        	
        	return result;
        };
		
        // 取得代理對象
		proxyObj = Proxy.newProxyInstance(loader, interfaces, handler);
		return proxyObj;
	}
}
