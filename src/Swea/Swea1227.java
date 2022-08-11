package Swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea1227 {
	// 상 우 하 좌
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static int N;
	static char map[][];
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = 100;

		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			ans = 0;
			map = new char[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			int x = 0;
			int y = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '2') {
						x = i;
						y = j;
						break;
					}
				}
			}
			

			bfs(x, y);
			
			sb.append("#").append(T).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);

	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { x, y });

		while (!queue.isEmpty()) {
			int location[] = queue.poll();
			x = location[0];
			y = location[1];
			visited[x][y] = true;
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
					if (map[nx][ny] == '0') {
						visited[nx][ny] = true;
						queue.offer(new int[] { nx, ny });
					}

					if (map[nx][ny] == '3') {
						ans = 1;
					}
				}
			}
		}

	}
}
