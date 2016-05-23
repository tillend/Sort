package Sort;
/**
 * @author LIn
 * 算法名称：二分排序(折半插入排序)
 * 算法描述：当直接插入排序进行到某一趟时，前i-1个记录已有序，此时
 *        不用直接插入排序，而改为二分折半查找，找到后再插入
 * 算法改进：将比较次数减少至O(nlogn)，但移动 次数仍未O(n^2)
 * 
 * 复杂度分析：
 * 1.平均时间复杂度：O(n^2)
 * 2.空间复杂度：O(1)(临时数据交换空间)
 */
public class BinarySort {

	public static void BinarySort(int[] a){
		int low,high,mid;
		int temp;
		for(int i = 0; i < a.length; i++){
			temp = a[i];
			low = 0;
			high = i - 1;
			while(low <= high){
				mid = (low + high) / 2;
				if(a[mid] > temp){
					high = mid - 1;
				}else{
					low = mid + 1;
				}
			}
			for(int j = i-1; j > high; j--){
				a[j+1] = a[j];
			}
			a[high+1] = temp;
		}
	}

}
