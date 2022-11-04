import java.util.*;
import java.io.*;

public class Main_BJ_5557_1학년 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		long[][] dp = new long[N+1][21];
		dp[1][nums[1]] = 1;
		
		for(int i=2; i<N; i++) {
			for(int j=0; j<=20; j++) {
				if(dp[i-1][j]==0) continue;
				if(j+nums[i] <=20) dp[i][j+nums[i]] += dp[i-1][j];
				if(j-nums[i] >= 0) dp[i][j-nums[i]] += dp[i-1][j];
			}
		}
		System.out.println(dp[N-1][nums[N]]);
	}
}
