package Sort;
/**
 * @author LIn
 * 算法名称：快速排序
 * 算法描述：
 * 1.通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小
 * 2.重复步骤1对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 * 算法改进：
 * 1.三数中值分割法选择基准点/枢纽元
 * 2.选择截止范围(cutoff range)以加快排序(当数组较小时，插入排序比快速排序快)
 *
 * 复杂度分析：
 * 1.平均时间复杂度：O(nlogn)
 * 2.空间复杂度：O(logn)(最值元素存储空间)
 */
public class QuickSortX {
	private final static int CUTOFF = 0;  //截断范围
	
	public static void QuickSort(int[] a, int left, int right){
		if(left + CUTOFF <= right){
			int pivot = median3(a, left, right);
			
			//开始划分
			int i = left, j = right - 1;
			for( ; ; ){
				while(i < j && a[++i] < pivot){}
				while(i < j && a[--j] > pivot){}
				if(i < j){
					swap(a, i, j);
					
				}
				else{
					break;
				}
			}
			
			swap(a, i, right-1);    //储存基准点
			
			QuickSort(a, left, i - 1);    //将较小元素排序
			QuickSort(a, i + 1, right);   //将较大元素排序
		}
		else{   //在子数组里调用插入排序
			InsertSort.InsertSort(a, left, right);
		}
	}
	
	/**
	 * 将三个数排序且隐藏基准点
	 * 返回三个数的中值
	 */
	private static int median3(int[] a, int left, int right) {
		int center = (left + right) / 2;
		if(a[center] < a[left]){
			swap(a, left, center);
		}
		if(a[right] < a[left]){
			swap(a, left, right);
		}
		if(a[right] < a[center]){
			swap(a, center, right);
		}
		
		//将基准点放置在right-1位置上
		swap(a, center, right - 1);
		return a[right-1];
	}

	private static void swap(int[] a, int x, int y){
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

}
