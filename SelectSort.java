package Sort;
/**
 * @author LIn
 * 算法名称：选择排序
 * 算法描述：
 * 1.从待排序的数据元素中选出最小/最大的一个元素，存放在序列的起始位置
 * 2.以i=1...n重复步骤1
 *
 * 复杂度分析：
 * 1.平均时间复杂度：O(n^2)
 * 2.空间复杂度：O(1)(最值元素存储空间)
 */
public class SelectSort {
	
	public static void SelectSort(int[] a){
		for(int i = 0; i < a.length; i++){
			int min = i;
			for(int j = i + 1; j < a.length; j++){
				if (a[j] < a[min]) { //如果有小于当前最小值的元素
                    min = j;
                }
			}
			if (i != min){
				swap(a, i, min);
			}
		}
	}
	
	private static void swap(int[] a, int x, int y){
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

}
