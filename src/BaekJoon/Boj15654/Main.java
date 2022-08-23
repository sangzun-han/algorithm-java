package BaekJoon.Boj15654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] nums;
	static int[] ans;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		isSelected = new boolean[N];
		ans = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		comb(0,0);
		System.out.print(sb);
	}

	private static void comb(int cnt, int start) {
		if(cnt==M) {
			for(int i=0; i<M; i++) {
				sb.append(ans[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0; i<N; i++) {
			if(isSelected[i]) continue;
			ans[cnt] = nums[i];
			isSelected[i] = true;
			comb(cnt+1, i+1);
			isSelected[i] = false;
		}
	}
}