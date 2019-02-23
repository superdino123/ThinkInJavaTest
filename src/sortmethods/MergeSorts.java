package sortmethods;

public class MergeSorts {
	
	public final static MergeSorts single = new MergeSorts();
	
	public int[] mergeSort(int[] n, int first, int last) {
		if(first < last) {
			int middle = (first + last) / 2;
			n = mergeSort(n, first, middle);
			n = mergeSort(n, middle + 1, last);
			n = mergeMehtod(n, first, middle, last);
		}
		return n;
	}
	
	public int[] mergeMehtod(int[] n, int first, int middle, int last) {
		int[] t = new int[last - first + 1];
		int tempfirst = first;
		int tempmiddle = middle + 1;
		int k = 0;
		while(tempmiddle <= last && tempfirst <= middle) {
			if(n[tempfirst] > n[tempmiddle])
				t[k++] = n[tempmiddle++];
			else {
				t[k++] = n[tempfirst++];
			}
		}
		while(tempmiddle < last + 1)
			t[k++] = n[tempmiddle++];
		while(tempfirst < middle + 1)
			t[k++] = n[tempfirst++];
		for(k = 0, tempfirst = first; tempfirst < last + 1; k++, tempfirst++)
			n[tempfirst] = t[k];
		return n;
	}
	
	public static void main(String[] args) {
		int[] n = {23, 1, 48, 2, 12, 42, 25};
		int[] r = single.mergeSort(n, 0, n.length-1);
		for(int i : r){
			System.out.print(i + ". ");			
		}
	}
}
