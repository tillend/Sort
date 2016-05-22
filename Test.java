package Sort;

public class Test {

	public static void main(String[] args) {
		int[] a = {5,4,9,8,7,6,0,1,3,2};
		ShellSort.ShellSort(a);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}

	}

}
