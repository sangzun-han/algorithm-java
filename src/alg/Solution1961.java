package alg;

import java.util.Scanner;

public class Solution1961 {
	public static int[][] rotate(int matrix[][], int n) {
		int[][] new_matrix = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				new_matrix[i][j] = matrix[n-1-j][i];
			}
		}
		return new_matrix;
	}
		
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		
		for(int tc=0; tc<t; tc++) {
			int n = scanner.nextInt();
			int[][] matrix = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					matrix[i][j] = scanner.nextInt();
				}
			}
			
			int[][] rotate90 = rotate(matrix,n);
			int[][] rotate180 = rotate(rotate90,n);
			int[][] rotate270 = rotate(rotate180,n);
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.print(rotate90[i][j] + "");
				}
				System.out.print(" ");
				for(int j=0; j<n; j++) {
					System.out.print(rotate180[i][j] + "");
				}
				System.out.print(" ");
				for(int j=0; j<n; j++) {
					System.out.print(rotate270[i][j] + "");
				}
				System.out.println();
			}
			
			
		}
	}
}
