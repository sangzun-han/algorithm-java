package alg;

import java.util.Scanner;

public class Solution1959 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int t = scanner.nextInt();

		for (int tc = 0; tc < t; tc++) {
			int max = 0;
			int n = scanner.nextInt();
			int m = scanner.nextInt();

			int[] A = new int[n];
			int[] B = new int[m];

			for (int i = 0; i < n; i++) A[i] = scanner.nextInt();
			for (int i = 0; i < m; i++) B[i] = scanner.nextInt();
			
			if (m > n) {
				for (int i = 0; i < m - n + 1; i++) {
					int result = 0;
					for (int j = 0; j < n; j++) {
						result = result + A[j] * B[i + j];
					}
					max = Math.max(result, max);
				}
			}

			if (m < n) {
				for (int i = 0; i < n - m + 1; i++) {
					int result = 0;
					for (int j = 0; j < m; j++) {
						result = result + A[i + j] * B[j];
					}
					max = Math.max(result, max);
				}
			} else {
				int result = 0;
				for (int i = 0; i < n; i++) {
					result = result + A[i] * B[i];
				}
				max = Math.max(result, max);
			}
			System.out.printf("#%d %d\n", tc + 1, max);
		}
		scanner.close();
	}
}