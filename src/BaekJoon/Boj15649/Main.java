package BaekJoon.Boj15649;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] nums, ans;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		ans = new int[M];
		isSelected = new boolean[N];
		for (int i = 0; i < N; i++) {
			nums[i] = i + 1;
		}

		perm(0);
		System.out.print(sb);
	}

	private static void perm(int cnt) {
		boolean flag = true;
		if (cnt == M) {

			for (int i = 0; i < ans.length - 1; i++) {
				if (ans[i] > ans[i + 1]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				for (int i = 0; i < ans.length; i++) {

					sb.append(ans[i]).append(" ");
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			ans[cnt] = nums[i];
			perm(cnt + 1);
		}

	}

}
