package sortmethods;

public class QuickSorts {
	
	public final static QuickSorts single = new QuickSorts();
	
	public int[] quickSort(int[] n, int first, int last) {
		if(first >= last)
			return n;
		int tempfirst = first;
		int templast = last;
		int key = n[first];
		while(first < last) {
			while(n[last] >= key && last > first) {
				last--;
			}
			n[first] = n[last];
			while(n[first] <= key && last > first) {
				first++;
			}
			n[last] = n[first];
		}
		n[first] = key;
		
		int[] left = quickSort(n, tempfirst, first - 1);
		int[] right = quickSort(n, first+1, templast);
		for(int i = tempfirst; i < first; i++) {
			n[i] = left[i];
		}
		for(int i = first + 1; i <= templast; i++) {
			n[i] = right[i];
		}
		return n;
	}
	public static void main(String[] args) {
		int[] n = {23, 1, 48, 2, 12, 42, 25};
		int[] r = single.quickSort(n, 0, n.length-1);
		for(int i : r){
			System.out.print(i + ". ");			
		}
	}
	/*
	 * {12, 1,23, 2, 48, 42, 25}
	 * 12,1
	 * */
}
