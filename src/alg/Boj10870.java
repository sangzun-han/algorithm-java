package alg;

import java.util.Scanner;

public class Boj10870 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fibo(n));
	}

	private static int fibo(int n) {
		if (n==0) return 0;
		else if (n==1) return 1;
		else if (n==2) return 1;
		else return fibo(n-1) + fibo(n-2);
		
	}
}
