package typeinfo;

import java.lang.reflect.Method;

import typeinfo.packageaccess.HiddenC;

public class HiddenImplementation {
	public static void main(String[] args) throws Exception{
		A a = HiddenC.makeA();
		a.f();
		System.out.println(a.getClass().getName());
		CallHiddenMethod(a, "g");
		CallHiddenMethod(a, "u");
		CallHiddenMethod(a, "v");
		CallHiddenMethod(a, "w");
	}
	
	static void CallHiddenMethod(Object a, String methodName) throws Exception {
		Method g = a.getClass().getDeclaredMethod(methodName);
		g.setAccessible(true);
		g.invoke(a);
	}
}/* Output:
public C.f()
typeinfo.packageaccess.C
public C.g()
package C.u()
protected C.v()
private C.w()
*///:~
