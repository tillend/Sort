package Sort;
/**
 * @author LIn
 * 算法名称：归并排序
 * 算法描述：
 * 1.将数组分为n等份(算法中为2)，对各子数组递归调用归并排序
 * 2.等分为2份时为2路归并，最后子数组排序结束后，将元素合并起来，复制回原数组
 * 
 * 复杂度分析：
 * 1.平均时间复杂度：O(nlogn)
 * 2.空间复杂度：O(n)(临时数据储存空间)
 */
public class MergeSort {
	
	/*public型的mergeSort是private型递归方法mergeSort的驱动程序*/
	public static void mergeSort(int[] a){
		int[] tempArray = new int[a.length];   //若数组元素为对象类型，需创建Comparable类的数组，再强转为该对象类型
		
		mergeSort(a, tempArray, 0, a.length - 1);
	}
	
	/**
	 * 递归调用归并排序
	 */
	private static void mergeSort(int[] a, int[] tempArray, int left, int right){
		if(left < right){
			int center = (left + right) / 2;
			mergeSort(a, tempArray, left, center);
			mergeSort(a, tempArray, center + 1, right);
			merge(a, tempArray, left, center + 1, right);   //子数组排序结束后，将子数组合并
		}
	}
	
	/**
	 * 合并左右的半分子数组
	 * @param a          需排序数组
	 * @param tempArray  临时存储数组
	 * @param leftPos    左半子数组开始的下标
	 * @param rightPos   右半子数组开始的下标
	 * @param rightEnd   右半子数组结束的下标
	 */
	private static void merge(int[] a, int[] tempArray, int leftPos, int rightPos, int rightEnd) {
		int leftEnd = rightPos - 1;
		int tempPos = leftPos;
		int num = rightEnd - leftPos + 1;
		
		//主循环
		while(leftPos <= leftEnd && rightPos <= rightEnd){
			if(a[leftPos] <= a[rightPos]){
				tempArray[tempPos++] = a[leftPos++];
			}else{
				tempArray[tempPos++] = a[rightPos++];
			}
		}
		/*比较结束后，只会有一个子数组元素未完全被合并*/
		while(leftPos <= leftEnd){        //复制左半子数组剩余的元素
			tempArray[tempPos++]  = a[leftPos++];
		}
		while(rightPos <= rightEnd){      //复制右半子数组剩余的元素
			tempArray[tempPos++]  = a[rightPos++];
		}
		
		//将元素从临时数组赋值回原数组
		for(int i = 0; i < num; i++, rightEnd--){
			a[rightEnd] = tempArray[rightEnd];
		}
		
	}

}
