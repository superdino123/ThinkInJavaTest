package concurrency;

public class MoreBasicThreads {
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++)
			new Thread(new LiftOff()).start();
		System.out.println("Waiting for LiftOff");
	}
}/* Output:
Waiting for LiftOff
#1(9), #0(9), #3(9), #2(9), #1(8), #0(8), #4(9), #3(8), #1(7), #2(8), #0(7), #4(8), #3(7), #1(6), #0(6), #2(7), #4(7), #3(6), #1(5), #0(5), #2(6), #4(6), #3(5), #1(4), #0(4), #4(5), #2(5), #3(4), #0(3), #4(4), #1(3), #2(4), #3(3), #4(3), #1(2), #0(2), #3(2), #2(3), #4(2), #1(1), #3(1), #2(2), #0(1), #4(1), #1(Liftoff!), #3(Liftoff!), #2(1), #0(Liftoff!), #4(Liftoff!), #2(Liftoff!), 
*///:~
