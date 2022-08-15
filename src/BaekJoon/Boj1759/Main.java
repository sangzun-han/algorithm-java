package BaekJoon.Boj1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L;
	static int C;
	static char[] word;
	static boolean[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		selected = new boolean[C];
		word = br.readLine().replace(" ", "").toCharArray();
		Arrays.sort(word);
		combination(0, 0);
	}

	public static void combination(int start, int cnt) {

		if (cnt == L) {
			int mo = 0;
			int ja = 0;
			for (int i = 0; i < C; i++) {
				if (selected[i]) {

					if (word[i] == 'a' || word[i] == 'e' || word[i] == 'i' || word[i] == 'o' || word[i] == 'u') {
						mo += 1;
					} else {
						ja += 1;
					}
				}
			}

			if (mo >= 1 && ja >= 2) {
				for (int i = 0; i < C; i++) {
					if (selected[i]) {
						System.out.print(word[i]);
					}
				}
				System.out.println();
			}
		}

		for (int i = start; i < C; i++) {
			selected[i] = true;
			combination(i + 1, cnt + 1);
			selected[i] = false;
		}

	}
}
