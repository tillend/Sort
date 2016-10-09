package Sort;
/**
 * @author LIn
 * 算法名称：堆排序
 * 算法描述：
 * 1.以线性时间建立一个堆
 * 2.调整堆/下滤（每次将最大/最小元素"上浮"至堆顶）
 * 3.将堆中的最后元素与堆顶元素交换，然后将堆的大小缩减1并进行步骤2
 * 
 * 复杂度分析：
 * 1.平均时间复杂度：O(nlogn)
 * 2.空间复杂度：O(1)(临时数据交换空间)
 * 
 */
public class HeapSort {
	/**
	 * 描述：堆排序
	 * @param a  需排序的项目的数组
	 */
	public static void HeapSort(int[] a){
		int i;
		int len = a.length;
		for(i = len / 2 - 1; i >= 0; i--){  /*初始堆*/
			adjustMinHeap(a, i, len);  
		}
		for(i = len - 1; i > 0; i--){
			swap(a, 0, i);                    /*删除最大值*/
			adjustMinHeap(a, 0, i);         /*调整堆*/ 
		}
	}
	
	/**
	 * 描述：返回左孩子
	 * @param i  堆中的元素的下标
	 * @return   左孩子的下标
	 */
	private static int leftChild(int i){
		return 2 * i + 1;
	}
	
	/**
	 * 描述：调整小顶堆
	 * @param a  需比较的项目的数组
	 * @param i  堆调整的序号
	 * @param n  堆的大小
	 */
	private static void adjustMinHeap(int[] a,int i,int n){
		int temp;
		int child;
		
		for(temp = a[i]; leftChild(i) < n; i = child){
			child = leftChild(i);
			if(child != n - 1 && a[child] < a[child+1]){
				child++;
			}
			if(a[child] > temp){
				a[i] = a[child];
			}else{
				break;
			}
		}
		a[i] = temp;
	}
	/**
	 * 交换堆中的值
	 * @param a
	 * @param x
	 * @param y
	 */
	private static void swap(int[] a, int x, int y){
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
}
