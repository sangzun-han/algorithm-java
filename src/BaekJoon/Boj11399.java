package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class Boj11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] p = new int[n];
		int[] ans = new int[n];

		int answer = 0;

		int sum = 0;

		for (int i = 0; i < n; i++) {

			p[i] = sc.nextInt();

		}

		Arrays.sort(p);

		for (int i = 0; i < n; i++) {

			sum += p[i];

			ans[i] = sum;

		}

		for (int i = 0; i < n; i++) {

			answer += ans[i];

		}

		System.out.print(answer);
	}
}
