package Sort;
/**
 * @author LIn
 * 算法名称：插入排序
 * 算法描述：
 * 1.对第i趟排序，数组前i-1项元素为已排序，将第i项元素插入已排序数组
 * 2.找到合适的位置后，更大/更小的元素向右移动一个位置，插入当前数据
 * 3.以i=1...n重复执行步骤1和2
 * 
 * 复杂度分析：
 * 1.平均时间复杂度：O(n^2)
 * 2.空间复杂度：O(1)(临时数据交换空间)
 */
public class InsertSort {
	
	public static void InsertSort(int[] a){
		int j;
		for(int i = 1; i < a.length; i++){
			int temp = a[i];
			for(j = i; j > 0 && temp < a[j-1]; j--){
				a[j] = a[j-1];
			}
			a[j] = temp;
		}
	}
	
	//数组局部排序
	public static void InsertSort(int[] a, int left, int right){
		int j;
		for(int i = left + 1; i < right; i++){
			int temp = a[i];
			for(j = i; j > 0 && temp < a[j-1]; j--){
				a[j] = a[j-1];
			}
			a[j] = temp;
		}
	}
}
