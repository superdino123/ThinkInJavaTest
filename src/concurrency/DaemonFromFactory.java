package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonFromFactory implements Runnable {
	
	public void run() {
		try {
			while(true) {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread() + " " + this);
			}
		} catch(InterruptedException e) {
			System.out.println("Interrupted");
		}
	}
	public static void main(String[] args) throws Exception{
		ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
		for(int i = 0; i < 10; i++) {
			exec.execute(new DaemonFromFactory());
		}
		System.out.println("All daemons started");
		TimeUnit.MILLISECONDS.sleep(500);
	}
}/* Output:
All daemons started
Thread[Thread-1,5,main] concurrency.DaemonFromFactory@2b0a5613
Thread[Thread-4,5,main] concurrency.DaemonFromFactory@15547dba
Thread[Thread-5,5,main] concurrency.DaemonFromFactory@50f7270b
Thread[Thread-2,5,main] concurrency.DaemonFromFactory@58bbe46a
Thread[Thread-0,5,main] concurrency.DaemonFromFactory@3812167c
Thread[Thread-3,5,main] concurrency.DaemonFromFactory@70c680f2
Thread[Thread-7,5,main] concurrency.DaemonFromFactory@45619639
Thread[Thread-8,5,main] concurrency.DaemonFromFactory@7810014f
Thread[Thread-9,5,main] concurrency.DaemonFromFactory@4d13cc6d
Thread[Thread-6,5,main] concurrency.DaemonFromFactory@2c87f1ce
Thread[Thread-1,5,main] concurrency.DaemonFromFactory@2b0a5613
Thread[Thread-4,5,main] concurrency.DaemonFromFactory@15547dba
Thread[Thread-5,5,main] concurrency.DaemonFromFactory@50f7270b
Thread[Thread-9,5,main] concurrency.DaemonFromFactory@4d13cc6d
Thread[Thread-8,5,main] concurrency.DaemonFromFactory@7810014f
Thread[Thread-7,5,main] concurrency.DaemonFromFactory@45619639
Thread[Thread-2,5,main] concurrency.DaemonFromFactory@58bbe46a
Thread[Thread-3,5,main] concurrency.DaemonFromFactory@70c680f2
Thread[Thread-0,5,main] concurrency.DaemonFromFactory@3812167c
Thread[Thread-6,5,main] concurrency.DaemonFromFactory@2c87f1ce
Thread[Thread-1,5,main] concurrency.DaemonFromFactory@2b0a5613
Thread[Thread-4,5,main] concurrency.DaemonFromFactory@15547dba
Thread[Thread-7,5,main] concurrency.DaemonFromFactory@45619639
Thread[Thread-8,5,main] concurrency.DaemonFromFactory@7810014f
Thread[Thread-2,5,main] concurrency.DaemonFromFactory@58bbe46a
Thread[Thread-9,5,main] concurrency.DaemonFromFactory@4d13cc6d
Thread[Thread-5,5,main] concurrency.DaemonFromFactory@50f7270b
Thread[Thread-6,5,main] concurrency.DaemonFromFactory@2c87f1ce
Thread[Thread-0,5,main] concurrency.DaemonFromFactory@3812167c
Thread[Thread-3,5,main] concurrency.DaemonFromFactory@70c680f2
Thread[Thread-1,5,main] concurrency.DaemonFromFactory@2b0a5613
Thread[Thread-4,5,main] concurrency.DaemonFromFactory@15547dba
Thread[Thread-9,5,main] concurrency.DaemonFromFactory@4d13cc6d
Thread[Thread-8,5,main] concurrency.DaemonFromFactory@7810014f
Thread[Thread-7,5,main] concurrency.DaemonFromFactory@45619639
Thread[Thread-5,5,main] concurrency.DaemonFromFactory@50f7270b
Thread[Thread-2,5,main] concurrency.DaemonFromFactory@58bbe46a
Thread[Thread-0,5,main] concurrency.DaemonFromFactory@3812167c
Thread[Thread-3,5,main] concurrency.DaemonFromFactory@70c680f2
Thread[Thread-6,5,main] concurrency.DaemonFromFactory@2c87f1ce
*///:~
