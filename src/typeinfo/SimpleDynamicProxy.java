package typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler{
	private Object proxied;
	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
		System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + ", args " + args);
		if(args != null) {
			for(Object arg : args)
				System.out.println(" " + arg);
		}
		//使用method.invoke将请求转发给被代理对象
		return method.invoke(proxied, args);
	}
}

public class SimpleDynamicProxy {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}
	public static void main(String[] args) {
		RealObject real = new RealObject();
		consumer(real);
		//通过Proxy.newProxyInstance实现动态代理
		Interface proxy = (Interface)Proxy.newProxyInstance(
				Interface.class.getClassLoader(), 
				new Class[] { Interface.class }, 
				new DynamicProxyHandler(real));
		consumer(proxy);
	}
}
