package sortmethods;

public class ShellSorts {

	public final static ShellSorts single = new ShellSorts();
	
	public int[] shellSort(int[] n, int num) {
		while(num != 0) {
			for(int i = num; i < n.length; i++) {
				for(int j = i; j >= num; j -= num) {
					if(n[j] < n[j - num]) {
						int temp = n[j];
						n[j] = n[j - num];
						n[j - num] = temp;
						System.out.println(n[0] + ", " + n[1] + ", " + n[2] + ", "
								 + n[3] + ", " + n[4] + ", " + n[5] + ", " + n[6]);
					}
				}
			}
			num = num / 2;
		}
		return n;
	}

	public static void main(String[] args) {
		int[] n = {23, 1, 48, 2, 12, 42, 25};
		int[] r = single.shellSort(n, n.length / 2);
		for(int i : r){
			System.out.print(i + ". ");			
		}
	}
}
