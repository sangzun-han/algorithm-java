package alg;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Swea1974 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		int n = 9;
		int[][] matrix = new int[n][n];
		Set<Integer> set = new HashSet<Integer>();

		for (int tc = 0; tc < t; tc++) {
			int ans = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = scanner.nextInt();
				}
			}

			// 가로 검사
			for (int i = 0; i < n; i++) {
				set.clear();
				for (int j = 0; j < n; j++) {
					set.add(matrix[i][j]);
				}
				if (set.size() != n) {
					ans += 1;
				}
			}

			// 세로 검사
			for (int i = 0; i < n; i++) {
				set.clear();
				for (int j = 0; j < n; j++) {
					set.add(matrix[j][i]);
				}
				if (set.size() != n) {
					ans += 1;
				}
			}

			// 3*3 검사
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					set.clear();
					for (int k = 0; k < 3; k++) {
						for (int l = 0; l < 3; l++) {
							set.add(matrix[3 * i + k][3 * j + l]);
						
						}
					}
					if (set.size() != n) {
						ans += 1;
					}
				}
			}

			if (ans > 0)
				System.out.printf("#%d %d\n", tc + 1, 0);
			else
				System.out.printf("#%d %d\n", tc + 1, 1);
		}
	}
}
