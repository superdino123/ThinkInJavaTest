package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < 5; i++)
			exec.execute(new LiftOff());
		exec.shutdown();
	}
}/* Output:
#2(9), #1(9), #4(9), #3(9), #0(9), #2(8), #1(8), #3(8), #4(8), #2(7), #0(8), #1(7), #3(7), #4(7), #0(7), #2(6), #1(6), #3(6), #4(6), #0(6), #2(5), #1(5), #3(5), #4(5), #0(5), #2(4), #1(4), #3(4), #4(4), #0(4), #2(3), #1(3), #3(3), #4(3), #0(3), #2(2), #1(2), #3(2), #4(2), #0(2), #2(1), #1(1), #3(1), #4(1), #0(1), #2(Liftoff!), #1(Liftoff!), #3(Liftoff!), #4(Liftoff!), #0(Liftoff!), 
*///:~
