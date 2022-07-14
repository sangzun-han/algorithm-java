package alg;

import java.util.Scanner;

public class Swea2001 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		
		for(int tc=0; tc<t; tc++) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int[][] matrix = new int[n][n];
			int max = 0;
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					matrix[i][j] = scanner.nextInt();
				}
			}
			
			
			for (int i=0; i<n-m+1; i++) {
				for (int j=0; j<n-m+1; j++) {
					int sum = 0;
					for (int k=0; k<m; k++) {
						for (int l=0; l<m; l++) {
							sum += matrix[k+i][l+j];
						}
					}
				max = Math.max(max, sum);
				}
			}
			System.out.printf("#%d %d",tc+1,max);
		}
	}

}
