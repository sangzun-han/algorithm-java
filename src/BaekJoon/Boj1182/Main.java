package BaekJoon.Boj1182;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,S;
	static boolean[] isSelected;
	static int[] nums;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		nums = new int[N];
		isSelected = new boolean[N];
		ans = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		backtracking(0,0);
		if(S==0) System.out.println(ans-1);
		else System.out.println(ans);
	}
	
	private static void backtracking(int sum, int start) {
		if(start==N) {
			if(sum==S) {
				ans++;
			}
			return;
		}
		backtracking(sum+nums[start], start+1);
		backtracking(sum, start+1);
 	}
}
