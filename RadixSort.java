package Sort;
/**
 * @author LIn
 * 算法名称：基数排序
 * 算法描述：变长字符串的基数排序，使用ArrayList
 * 效果：如同字典中索引排序
 * 
 * 复杂度分析：
 * 1.平均时间复杂度：O(p(n+r)),其中p是趟数/位数，n是待排元素个数，r是基数/桶的个数
 * 2.空间复杂度：O(n+r*p)(临时数据交换空间及桶的空间)
 */
import java.util.ArrayList;

public class RadixSort {
	
	public static void RadixSort(String[] a, int maxLen){
		final int BUCKETS = 256;
		
		ArrayList<String>[] wordsByLength = new ArrayList[maxLen + 1];
		ArrayList<String>[] buckets = new ArrayList[BUCKETS];
		
		//初始化数组列表
		for(int i = 0; i < wordsByLength.length; i++){
			wordsByLength[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < BUCKETS; i++){
			buckets[i] = new ArrayList<>();
		}
		//根据字符串长度加入对应的桶中
		for(String s:a){
			wordsByLength[s.length()].add(s);
		}
		//将桶中元素加入依序数组
		int idx = 0;
		for(ArrayList<String> wordList:wordsByLength){
			for(String s:wordList){
				a[idx++] = s;
			}
		}
		/*根据字符串长度从大到小查看pos位置上的字符，加入buckets调整后，再入数组*/
		int startingIndex = a.length;
		for(int pos = maxLen - 1; pos >= 0; pos --){
			startingIndex -= wordsByLength[pos + 1].size();
			
			for(int i = startingIndex; i < a.length; i++){
				buckets[a[i].charAt(pos)].add(a[i]);
			}
			
			idx = startingIndex;
			for(ArrayList<String> thisBucket:buckets){
				for(String s:thisBucket){
					a[idx++] = s;
				}
				thisBucket.clear();
			}
		}
	}

}
