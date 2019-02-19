package exceptions;
//自定义参数标识符
class MyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -644046887201829916L;
	public MyException() {}
	public MyException(String msg) { super(msg); }
}

public class FullConstructors {
	public static void f() throws MyException {
		System.out.println("Throwing MyException from f()");
		throw new MyException();
	}
	public static void g() throws MyException {
		System.out.println("Throwing MyException from g()");
		throw new MyException("originated in g()");
	}
	public static void main(String[] args) {
		try {
			f();
		} catch (MyException e) {
			// 打印"从方法调出处知道异常抛出处"的方法调用序列
			e.printStackTrace(System.out);
		}
		try {
			g();
		} catch(MyException e) {
			e.printStackTrace(System.out);
		}
	}
}
