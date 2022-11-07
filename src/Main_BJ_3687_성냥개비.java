import java.util.*;
import java.io.*;

public class Main_BJ_3687_성냥개비 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] nums = new int[8];
		nums[2] = 1;
		nums[3] = 7;
		nums[4] = 4;
		nums[5] = 2;
		nums[6] = 0;
		nums[7] = 8;
		long[] d = new long[101];
		Arrays.fill(d, Long.MAX_VALUE);
		d[2] = 1;
		d[3] = 7;
		d[4] = 4;
		d[5] = 2;
		d[6] = 6;
		d[7] = 8;
		d[8] = 10;
		// 가장 작은 수
		for (int j = 9; j <= 100; j++) {
			for (int k = 2; k <= 7; k++) {
				d[j] = Math.min(d[j], d[j - k] * 10 + nums[k]);
			}
		}

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			String max = "";

			// 가장 큰 수 짝수면 1다 붙이고 홀수면 7 붙이고 다 1
			if (N % 2 == 0) {
				for (int j = 0; j < N / 2; j++) {
					max += 1;
				}
			} else {
				max += 7;
				for (int j = 0; j < N / 2 - 1; j++) {
					max += 1;
				}
			}
			System.out.println(d[N] + " " + max);
		}

	}
}
