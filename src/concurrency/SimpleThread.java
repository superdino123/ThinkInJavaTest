package concurrency;

public class SimpleThread extends Thread {
	
	private int countDown = 5;
	private static int threadCount = 0;
	public SimpleThread() {
		super(Integer.toString(++threadCount));
		start();
	}
	public String toString() {
		return "#" + getName() + "(" + countDown + "),";
	}
	public void run() {
		while(true) {
			System.out.println(this);
			if(--countDown == 0)
				return;
		}
	}
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++)
			new SimpleThread();
	}	
}/* Output:
#3(5),
#3(4),
#5(5),
#4(5),
#2(5),
#1(5),
#2(4),
#4(4),
#5(4),
#3(3),
#5(3),
#4(3),
#2(3),
#2(2),
#2(1),
#1(4),
#1(3),
#1(2),
#1(1),
#4(2),
#5(2),
#3(2),
#5(1),
#4(1),
#3(1),
*///:~
