package alg;

import java.util.Scanner;

public class Swea1979 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		
		for(int tc=0; tc<t; tc++) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			int ans = 0;
			int count = 0;
			int[][] matrix = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					matrix[i][j] = scanner.nextInt();
				}
			}
			for(int i=0; i<n; i++) {
				count = 0;
				for(int j=0; j<n; j++) {
					if (matrix[i][j] == 1) count += 1;
					else if (matrix[i][j] == 0) {
						if (count == k) {
							ans += 1;
							count = 0;
						}
						else count = 0;
						
					}
				}
				if (count == k) ans += 1;
				else count = 0;
			}
		
		
			for(int i=0; i<n; i++) {
				count = 0;
				for(int j=0; j<n; j++) {
					if (matrix[j][i] == 1) count += 1;
					else if (matrix[j][i] == 0) {
						if (count == k) {
							ans += 1;
							count = 0;
						}
						else count = 0;
					}
				}
				
				if (count == k) ans += 1;
				else count = 0;
			}
			System.out.printf("#%d %d\n",tc+1, ans);
			scanner.close();
			
		}
	}
}
