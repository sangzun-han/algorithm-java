package BaekJoon.Boj15656;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] nums;
	static int[] ans;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		ans = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] =  Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
	
		perm(0);
		System.out.println(sb);
	}

	private static void perm(int cnt) {
		if(cnt==M) {
			for(int i=0; i<M; i++) {				
				sb.append(ans[i]).append(" ");
			}			
			sb.append("\n");
			return;
		}
		for(int i=0; i<N; i++) {
			ans[cnt] = nums[i];
			perm(cnt+1);
			
		}
	}
}
