package Sort;
/**
 * @author LIn
 * 算法名称：选择排序(简单工厂实现升序或降序)
 * 算法描述：
 * 1.从待排序的数据元素中选出最小/最大的一个元素，存放在序列的起始位置
 * 2.以i=1...n重复步骤1
 *
 * 复杂度分析：
 * 1.平均时间复杂度：O(n^2)
 * 2.空间复杂度：O(1)(最值元素存储空间)
 */

/*数据比较接口*/
interface IntCompare{
	public boolean cmp(int x,int y);
}
/*升序*/
class Cmp1 implements IntCompare{
	public boolean cmp(int x,int y){
		if(x > y){
			return true;
		}else{
			return false;
		}
	}
}
/*降序*/
class Cmp2 implements IntCompare{
	public boolean cmp(int x,int y){
		if(x > y){
			return false;
		}else{
			return true;
		}
	}
}
//选择排序实现
public class SelectSortX {

	public static void SelectSort(int[] a, IntCompare cmp){
		for(int i = 0; i < a.length; i++){
			int min = i;
			for(int j = i + 1; j < a.length; j++){
				if(cmp.cmp(a[min], a[j])){
					min = j;
				}
				if (i != min){
					swap(a, i, min);
				}
			}
		}
	}
	
	public static void swap(int[] a, int x, int y){
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	
	public static void main(String[] args) {
		int[] array = {4,2,1,6,3,6,0,-5,1,1};
//		SelectSort(array, new Cmp1());      //升序排序
		SelectSort(array, new Cmp2());      //降序排序
		for(int i = 0; i < array.length; i++){
			System.out.printf("%d ",array[i]);
		}

	}

}
