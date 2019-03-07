package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class ExceptionThread2 implements Runnable{
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("run() by " + t);
		System.out.println(
				"eh = " + t.getUncaughtExceptionHandler()
		);
		throw new RuntimeException();
	}
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
	//该方法会在线程因未捕获的异常而临近死亡时被调用
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("caught " + e);
	}
}

class HandlerThreadFactory implements ThreadFactory{
	public Thread newThread(Runnable r) {
		System.out.println(this + " creating new Thread");
		Thread t = new Thread(r);
		System.out.println("created " + t);
		t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		System.out.println("eh = " + t.getUncaughtExceptionHandler());
		return t;
	}
}

public class CaptureUncaughtException {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
		exec.execute(new ExceptionThread2());
	}
}/* Output:
concurrency.HandlerThreadFactory@5c647e05 creating new Thread
created Thread[Thread-0,5,main]
eh = concurrency.MyUncaughtExceptionHandler@33909752
run() by Thread[Thread-0,5,main]
eh = concurrency.MyUncaughtExceptionHandler@33909752
concurrency.HandlerThreadFactory@5c647e05 creating new Thread
created Thread[Thread-1,5,main]
eh = concurrency.MyUncaughtExceptionHandler@15547dba
caught java.lang.RuntimeException
*///:~
