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

	public static void QuickSort(int[] a, int left, int right){
		int pivotpos;  //划分后基准的位置
		if(left < right){
			pivotpos = Partition(a, left ,right);
			QuickSort(a, left, pivotpos-1);
			QuickSort(a, pivotpos+1, right);
		}
	}
	
	/**
	 * 普通选择基准
	 */
	private static int Partition(int[] a, int i, int j){
		//调用Partition(a,left,right)时，对a[left...right]做划分
		//并返回基准记录的位置
		int pivot = a[i];  //用区间的第一个记录作为基准
		
		while(i < j){  //从区间两端交替向中间扫描，直至i=j为止
			while(i < j && a[j] >= pivot){   //pivot相当于在位置i上
				j--;
			}
			if(i < j){   //表示找到a[j]<pivot,交换a[i]和a[j]
				a[i++] = a[j];
			}
			while(i < j && a[i] <= pivot){ //pivot相当于在位置j上
				i++;     //从左到右扫描，查找第一个大于pivot的数组元素
			}
			if(i < j){   //表示找到a[i]>pivot,交换a[i]和a[j]
				a[j--] = a[i];
			}	
		}
		
		a[i] = pivot;
		return i;
	}
	
	public static void main(String[] args) {
		int[] a = {4,2,1,6,3,6,0,-5,1,1};
		QuickSort(a,0,a.length-1);
		
		for(int i = 0; i < a.length; i++){
			System.out.printf("%d ",a[i]);
		}

	}

}
