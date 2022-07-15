package alg;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Boj1026 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] A = new int[n];
		Integer[] B = new Integer[n];

		int sum = 0;
		// 입력
		for (int i = 0; i < n; i++)
			A[i] = sc.nextInt();
		for (int i = 0; i < n; i++) 
			B[i] = sc.nextInt();


		// 계산
		Arrays.sort(A);
		Arrays.sort(B, Collections.reverseOrder());
		for (int i = 0; i < n; i++) 
			sum += A[i] * B[i];

		System.out.println(sum);
	}
}
