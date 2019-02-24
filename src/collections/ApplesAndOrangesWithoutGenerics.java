package collections;
//容器，未用到反省，程序运行会得到一个报错
import java.util.ArrayList;

class Apple{
	private static long counter;
	private final long id = counter++;
	public long id() {return id;}
}

class Orange {}

public class ApplesAndOrangesWithoutGenerics {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ArrayList apples = new ArrayList();
		for(int i = 0; i < 3; i++) {
			apples.add(new Apple());
		}
		apples.add(new Orange());
		for(int i = 0; i < apples.size(); i++) {
			((Apple)apples.get(i)).id();
		}
	}
}
