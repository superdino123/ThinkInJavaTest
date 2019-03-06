package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff {
	public void run() {
		try {
			while(countDown-- > 0) {
				System.out.println(status());
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch(InterruptedException e) {
			System.err.println("Interrupted");
		}
	}
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < 5; i++)
			exec.execute(new SleepingTask());
		exec.shutdown();
	}
}/* Output:
#1(9), 
#3(9), 
#2(9), 
#0(9), 
#4(9), 
#1(8), 
#2(8), 
#3(8), 
#4(8), 
#0(8), 
#4(7), 
#2(7), 
#3(7), 
#1(7), 
#0(7), 
#2(6), 
#4(6), 
#1(6), 
#3(6), 
#0(6), 
#4(5), 
#2(5), 
#3(5), 
#1(5), 
#0(5), 
#2(4), 
#4(4), 
#3(4), 
#1(4), 
#0(4), 
#2(3), 
#4(3), 
#1(3), 
#3(3), 
#0(3), 
#4(2), 
#2(2), 
#1(2), 
#3(2), 
#0(2), 
#4(1), 
#2(1), 
#1(1), 
#3(1), 
#0(1), 
#4(Liftoff!), 
#2(Liftoff!), 
#1(Liftoff!), 
#3(Liftoff!), 
#0(Liftoff!), 
*///:~
