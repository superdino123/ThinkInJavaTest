package sortmethods;

public class SelectionSorts {

	public final static SelectionSorts single = new SelectionSorts();
	
	public int[] selectionSort(int[] n) {
		for(int i = 0; i < n.length - 1; i ++) {
			int min = i;
			for(int j = i+1; j < n.length; j ++) {
				if(n[j] < n[min])
					min = j;
			}
			int t = n[min];
			n[min] = n[i];
			n[i] = t;
		}
		return n;
	}
	public static void main(String[] args) {
		int[] n = {23, 1, 48, 92, 12, 42, 25};
		int[] r = single.selectionSort(n);
		for(int i : r){
			System.out.print(i + ". ");			
		}
	}
}
