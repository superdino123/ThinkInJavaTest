package sortmethods;

public class BubbleSorts {
	
	public final static BubbleSorts single = new BubbleSorts();
	
	public int[] bubbleSort(int[] n) {
		for(int i = 0; i < n.length; i++) {
			for(int j = 0; j < (n.length - 1 - i); j++) {
				if(n[j] > n[j + 1]) {
					int t = n[j];
					n[j] = n[j + 1];
					n[j + 1] = t;
				}
			}
		}
		return n;
	}
	public static void main(String[] args) {
		int[] n = {23, 1, 48, 92, 12, 42, 25};
		int[] r = single.bubbleSort(n);
		for(int i : r){
			System.out.print(i + ". ");			
		}
	}
}
