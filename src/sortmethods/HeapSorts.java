package sortmethods;

public class HeapSorts {

	public final static HeapSorts single = new HeapSorts();
	
	public int[] heapSort(int[] n, int top) {
		if(n.length == 1)
			return n;
		int[] topNode = new int[top];
		for(int i = n.length / 2 - 1; i >= 0; i--) {
			n = heapAdjust(n, i, n.length);
		}
		for(int i = n.length - 1; i >= n.length - top; i--) {
			int temp = n[0];
			n[0] = n[i];
			n[i] = temp;
			topNode[n.length - 1 - i] = temp;
			n = heapAdjust(n, 0, i);
		}
		return topNode;
	}
	
	private int[] heapAdjust(int[] n, int parent, int length) {
		int temp = n[parent];
		int child = 2 * parent + 1;
		while(child < length) {
			if(child + 1 < length && n[child] < n[child + 1])
				child++;
			if(temp >= n[child])
				break;
			n[parent] = n[child];
			parent = child;
			child = 2 * parent + 1;
		}
		n[parent] = temp;
		return n;
	}

	public static void main(String[] args) {
		int[] n = {23, 1, 48, 2, 12, 42, 25};
		int[] r = single.heapSort(n, n.length);
		for(int i : r){
			System.out.print(i + ". ");			
		}
	}
}
