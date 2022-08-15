package BaekJoon.Boj16236;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int shark = 2;
	static int time = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		// 상어 위치
		int x = 0;
		int y = 0;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					x = i;
					y = j;
				}
			}
		}
		dfs(x, y);
		System.out.println(time);
	}

	private static void dfs(int x, int y) {
		if (check(x, y) && zeroCheck(x, y)) {
			time++;
			map[x][y] = 0;
			shark++;
			map[x][y] = shark;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx > 0 || ny > 0 || nx > N || ny > N)
				continue;
			dfs(nx, ny);

		}

	}

	private static boolean zeroCheck(int x, int y) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0)
					return true;
			}
		}
		return false;
	}

	private static boolean check(int x, int y) {
		for (int i = x; i < N; i++) {
			for (int j = y; j < N; j++) {
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];

					if (nx > 0 || ny > 0 || nx > N || ny > N)
						continue;
					if (map[nx][ny] <= shark)
						return true;
				}

			}
		}
		return false;

	}
}
