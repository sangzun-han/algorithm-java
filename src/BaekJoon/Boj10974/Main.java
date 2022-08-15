package BaekJoon.Boj10974;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] nums;
	static boolean[] isSelected;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			nums[i] = i + 1;
		}
		perm(0);
		System.out.println(sb);
	}

	private static void perm(int cnt) {
		if(cnt == N) {
			for(int i=0; i<nums.length; i++) {
				sb.append(nums[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<nums.length; i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			nums[cnt] = i+1;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}

}
