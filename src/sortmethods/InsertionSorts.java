package sortmethods;

import java.awt.List;
import java.util.ArrayList;

public class InsertionSorts {
	
	public final static InsertionSorts single = new InsertionSorts();
	
	public int[] insertionSort(int[] n) {
		for(int i = 1; i < n.length; i++) {
			for(int j = i; j >= 1; j --) {
				if(n[j] < n[j - 1]) {
					int t = n[j];
					n[j] = n[j - 1];
					n[j - 1] = t;
				}
					
			}
		}
		return n;
	}
	
	public static void main(String[] args) {
		int[] n = {23, 1, 48, 92, 12, 42, 25};
		int[] r = single.insertionSort(n);
		for(int i : r){
			System.out.print(i + ". ");			
		}
	}
}
