package alg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Boj1914 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger m = new BigInteger("2");
		int n = Integer.parseInt(br.readLine());
		if(n<=20) {
			System.out.println((m.pow(n).subtract(BigInteger.ONE)));
			hanoi(n,1,2,3);
		}
		else System.out.println((m.pow(n).subtract(BigInteger.ONE)));
		
	}

	private static void hanoi(int n, int start, int temp, int end) {

		if (n == 1) {
			System.out.println(start + " " + end);
			return;
		} else {
			hanoi(n - 1, start, end, temp);
			hanoi(1, start, temp, end);
			hanoi(n - 1, temp, start, end);

		}

	}

}
