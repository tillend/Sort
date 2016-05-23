package Sort;

public class CountingRadixSort {
	
	public static void CountingRadixSort(String[] a, int stringLen){
		final int BUCKETS = 256;
		
		int n = a.length;
		String[] buffer = new String[n];
		
		String[] in = a;
		String[] out = buffer;
		
		for(int pos = stringLen - 1; pos >= 0; pos--){
			int[] count = new int[BUCKETS + 1];
			
			for(int i = 0; i < n; i++){
				count[in[i].charAt(pos) + 1]++;
			}
			
			for(int b = 1; b <= BUCKETS; b++){
				count[b] += count[b - 1];
			}
			
			for(int i = 0; i < n; i++){
				out[ count[ in[i].charAt(pos) ]++ ] = in[i];
			}
			
			//将in和out互换
			String[] temp = in;
			in = out;
			out = temp;
		}
		
		/*  当字符串最长的长度是偶数，out最后引用的是a，排序结束
		 *  当字符串最长的长度是奇数，需要把in复制至out
		 * */
		if(stringLen % 2 == 1){
			for(int i = 0; i < a.length; i++){
				out[i] = in[i];
			}
		}
	}
}
