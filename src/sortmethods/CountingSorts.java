package sortmethods;

public class CountingSorts {

	public final static CountingSorts single = new CountingSorts();
	
	public int[] countingSort(int[] n) {
		int[] b= new int[n.length];
		int max = n[0];
		int min = n[0];
		for(int item : n) {
			if(max < item) {
				max = item;
			}
			if(min > item) {
				min = item;
			}
		}
		int k = max - min + 1;
		int[] c = new int[k];
		for(int i = 0; i < n.length; i++) {
			c[n[i] - min] += 1;
		}
		for(int i = 1; i < c.length; i++) {
			c[i] = c[i] + c[i-1];
		}
		for(int i = n.length - 1; i >=0; i--) {
			b[--c[n[i] - min]] = n[i];
		}
		return b;
	}

	public static void main(String[] args) {
		int[] n = {23, 1, 48, 2, 12, 42, 25};
		int[] r = single.countingSort(n);
		for(int i : r){
			System.out.print(i + ". ");			
		}
	}
}