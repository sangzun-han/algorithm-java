import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_12015_가장긴증가하는부분수열2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int[] C = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int size = 0;
		
		for(int i=0; i<N; i++) {
			int idx = Arrays.binarySearch(C, 0, size, nums[i]);
			
			if(idx >= 0) continue;
			else {
				idx = Math.abs(idx) - 1;
				C[idx] = nums[i];
				if(size==idx)size++;
			}
		}
		System.out.println(size);
		
	}
}
