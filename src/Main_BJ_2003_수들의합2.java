import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_2003_수들의합2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] nums = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 0;
		int sum = nums[0];
		int ans = 0;
		
		
		
		while(left <= right && right < N) {
			if(sum > M) {
				sum -=nums[left];
				left++;

				if(left > right) {
					right = left;
					sum = nums[right];
				}
			} else if (sum==M) {
				ans++;
				right++;
				sum += nums[right];
			} else if (sum < M) {
				right++;
				sum += nums[right];
			}
		}
		System.out.println(ans);
	}		
}
