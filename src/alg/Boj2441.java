package alg;

import java.util.Scanner;

public class Boj2441 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			for (int k = 0; k < i; k++) {

				System.out.print(" ");

			}

			for (int j = 1; j <= n - i; j++) {

				System.out.print("*");

			}

			System.out.println();

		}

	}
}
