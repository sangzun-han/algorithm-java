import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 각 종류 색종이 5개씩 있음
// make(x) : x번째 칸에 색종이 붙이기 x = i*10+j

public class Main_BJ_17136_색종이붙이기 {
	static int N = 10;
	static int[][] map = new int[N][N];
	static int[] paper = { 5, 5, 5, 5, 5 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(make(0));
	}

	// 색종이를 다 붙여봤는데 1이 있으면 -1
	private static int make(int k) {
		if (k == N * N) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1)
						return -1;
				}
			}
			return 0;
		}

		int x = k / N;
		int y = k % N;

		if (map[x][y] == 0) {
			return make(k + 1);
		}

		int ans = -1;
		// 색종이가 1개 이상 남아있고, 범위를 넘어가지 않는다면
		for (int d = 0; d < 5; d++) {
			if (paper[d] > 0) {
				if (x + d - 1 < N && y + d - 1 < N) {
					boolean flag = true;

					// 종이를 붙이려면 모두 1이어야 한다. 0을 만나면 종이를 붙일수 없으므로 flag 변경
					for (int i = x; i < x + d; i++) {
						paper:for (int j = y; j < y + d; j++) {
							if (map[i][j] == 0) {
								flag = false;
								break paper;
							}
						}
						
					}

					// 종이를 붙이려는 공간이 모두 1이므로 종이를 붙이고 0으로 변경
					if (flag) {
						for (int i = x; i < x + d; i++) {
							for (int j = y; j < y + d; j++) {
								map[i][j] = 0;
							}
						}

						// 색종이 하나 감소
						paper[d] -= 1;
						// 다음번 채워보기
						int temp = make(k + 1);

						// 색종이 원래대로 되돌리기
						paper[d] += 1;
						if (temp != -1) {
							if (ans == -1 || ans > temp + 1) {
								ans = temp + 1;
							}
						}

						for (int i = x; i < x + d; i++) {
							for (int j = y; j < y + d; j++) {
								map[i][j] = 1;
							}
						}
					}
				}
			}
		}
		return ans;
	}
}
