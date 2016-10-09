package Sort;
/**
 * @author LIn
 * 算法名称：快速排序
 * 算法描述：
 * 1.通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小
 * 2.重复步骤1对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 *
 * 复杂度分析：
 * 1.平均时间复杂度：O(nlogn)
 * 2.空间复杂度：O(logn)(最值元素存储空间)
 */
public class QuickSort {
	
	public static void quickSort(int[] a){
		quickSort(a, 0, a.length);
	}

	private static void quickSort(int[] a, int left, int right){
		int pivotpos;  //划分后基准的位置
		if(left < right){
			pivotpos = Partition(a, left ,right);
			quickSort(a, left, pivotpos);
			quickSort(a, pivotpos+1, right);
		}
	}
	
	/**
	 * 普通选择基准
	 */
	private static int Partition(int[] a, int i, int j){
		//调用Partition(a,left,right)时，对a[left...right]做划分
		//并返回基准记录的位置
		int flag = i;
		int pivot = a[i];  //用区间的第一个记录作为基准
		
		while (true) {
			while (i < j && a[--j] >= pivot)
				;
			while (i < j && a[++i] <= pivot)
				;
			if (i < j) {
				swap(a, i, j);
			} else {
				break;
			}
		}
		
		swap(a, i, flag);
		return i;
	}
	
	public static int find_K_Max(int[] a, int k){
		int low = 0, high = a.length;
		int target = 0;
		while(low < high){
			int pivot = Partition(a, low, high);
			if(k - 1 == pivot){
				target =  a[pivot];
				break;
			}else if(pivot > k - 1){
				high = pivot;
			}else{
				low = pivot + 1;
			}
			
		}
		
		return target;
	}
	

	private static void swap(int[] a, int x, int y){
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

}
