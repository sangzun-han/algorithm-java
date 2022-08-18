package BaekJoon.Boj13458;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); // 시험장 개수
		int[] person = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			person[i] = Integer.parseInt(st.nextToken()); // 응시자 수
		}
		long cnt = 0;
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken()); // 총감독관 B명 감시가능
		int C = Integer.parseInt(st.nextToken()); // 부감독관 C명 감시가능

		for (int i = 0; i < N; i++) {
			person[i] -= B;
			cnt++;
		}

		for (int i = 0; i < N; i++) {
			if (person[i] > 0) {
				if (person[i] % C != 0) {
					cnt += (person[i] / C) + 1;
				} else {
					cnt += (person[i] / C);
				}
			}
		}
		System.out.println(cnt);
	}
}

