package BaekJoon.Boj7576;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static Queue<int[]> queue = new ArrayDeque<>();
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					queue.offer(new int[] { i, j });
				}
			}
		}
		System.out.println(bfs());
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		
	}
	
	private static int bfs() {
		int ans = -1;
		while (!queue.isEmpty()) {
			int[] xy = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nx = xy[0] + dx[d];
				int ny = xy[1] + dy[d];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0) {
					map[nx][ny] = map[xy[0]][xy[1]] + 1;
					queue.offer(new int[] { nx, ny });
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					return -1;
				}
				ans = Math.max(ans, map[i][j]);
			}
		}

		if (ans == 1)
			return 0;
		else
			return ans - 1;
	}

}
