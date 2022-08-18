package BaekJoon.Boj2961;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Taste {
	int s;
	int b;

	Taste(int s, int b) {
		this.s = s;
		this.b = b;
	}
}

public class Main {
	static boolean[] isSelected;
	static int sum, ans, N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 재료의 갯수
		isSelected = new boolean[N];
		sum = 0;
		ans = Integer.MAX_VALUE;

		Taste[] t = new Taste[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			t[i] = new Taste(S, B);
		}
		subset(t, 0);
		System.out.println(ans);
	}

	private static void subset(Taste[] t,  int index) {
		if (index == N) {
			int sour = 1;
			int bitter = 0;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					cnt++;
					sour *= t[i].s;
					bitter += t[i].b;
				}
			}
			if(cnt == 0) return;
			int sum = Math.abs(sour - bitter);
			if (ans > sum) ans = sum;
			return;
		}

		isSelected[index] = true;
		subset(t,index + 1);

		isSelected[index] = false;
		subset(t,index + 1);
	}

}
