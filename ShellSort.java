package Sort;
/**
 * @author LIn
 * 算法名称：希尔排序
 * 算法介绍:
 * 1.希尔排序(Shell Sort)是插入排序的一种。也称缩小增量排序，是直接插入排序算法的一种更高效的改进版本。
 * 算法描述：
 * 1.希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序。
 * 2.随着增量逐渐减少，每组包含的关键词越来越多，直至增量减至1。
 * 
 * 复杂度分析：
 * 1.平均时间复杂度：O(nlogn)
 * 2.空间复杂度：O(1)(临时数据交换空间)
 */
public class ShellSort {
	
	public static void ShellSort(int[] a){
		int gap, i, j;
		for(gap = a.length / 2; gap > 0; gap /= 2){
			for(i = gap; i < a.length; i++){
				int temp = a[i];
				for(j = i; j >= gap && temp < a[j - gap]; j -= gap){
					a[j] = a[j - gap];
				}
				a[j] = temp;
			}
		}
	}

}
