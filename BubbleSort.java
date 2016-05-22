package Sort;
/**
 * @author LIn
 * 算法名称：冒泡排序(单向)
 * 算法描述：
 * 1.从第一个元素开始，依次比较相邻两个元素，将较大/较小元素通过交换放在数组的后方
 *   每次冒泡效果为将一个最大/最小元素"上浮"到数组第i位(i=n...1)
 * 2.重复步骤1
 * 
 * 复杂度分析：
 * 1.平均时间复杂度：O(n^2)
 * 2.空间复杂度：O(1)(临时数据交换空间)
 *
 */
public class BubbleSort {
	
	public static void BubbleSort(int[] a){
		for(int i = a.length-1; i > 0; i--){
			for(int j = 0; j < i; j++){
				if(a[j] > a[j+1]){
					swap(a,j,j+1);
				}
			}
		}
	}
	
	private static void swap(int[] a, int x, int y){
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

}
