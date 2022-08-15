package BaekJoon.Boj1934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(a*b/GCD(a,b));
		}

	}

	public static int GCD(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return GCD(b, a % b);
		}
	}
}