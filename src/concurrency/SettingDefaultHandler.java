package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SettingDefaultHandler {
	public static void main(String[] args) {
		// 默认的未捕获异常处理器
		Thread.setDefaultUncaughtExceptionHandler(
				new MyUncaughtExceptionHandler());
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new ExceptionThread());
	}
}/* Output:
caught java.lang.RuntimeException
*///:~
