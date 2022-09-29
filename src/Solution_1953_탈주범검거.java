import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {
	static int N, M, R, C, L, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			ans = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs(R, C);
			sb.append("#").append(tc).append(" ").append(ans+1).append("\n");

		}
		System.out.println(sb);
	}

	private static void bfs(int r, int c) {
		Queue<Point> queue = new ArrayDeque<>();
		visited[r][c] = true;
		queue.offer(new Point(r, c));
		int time = 1;
		while (!queue.isEmpty()) {
			int qSize = queue.size();
			if (time++ == L) return;
			for (int i = 0; i<qSize; i++) {
				Point p = queue.poll();
				int me = map[p.x][p.y];
				
				for (int d = 0; d < 4; d++) {
					int nx = p.x + dx[d];
					int ny = p.y + dy[d];
					if (nx < 0 || nx >= N || ny < 0 || ny >= M)
						continue;
					if (visited[nx][ny] || map[nx][ny] == 0)
						continue;

					int type = map[nx][ny];
					
					if (d == 0) {
						if ((type == 1 || type == 2 || type == 5 || type == 6) && (me == 1 || me == 2 || me == 4 || me == 7)) {
							visited[nx][ny] = true;
							queue.offer(new Point(nx, ny));
							ans++;
						}
					} else if (d == 1) {
						if ((type == 1 || type == 3 || type == 6 || type ==7) && (me == 1 || me == 3 || me == 4 || me == 5)) {
							visited[nx][ny] = true;
							queue.offer(new Point(nx, ny));
							ans++;
						}
					} else if (d == 2) {
						if ((type == 1 || type == 2 || type == 4 || type == 7) && (me == 1 || me == 2 || me == 5 || me == 6)) {
							visited[nx][ny] = true;
							queue.offer(new Point(nx, ny));
							ans++;
						}
					} else if (d == 3) {
						if ((type == 1 || type == 3 || type == 4 || type == 5) && (me == 1 || me == 3 || me == 6 || me == 7)) {
							visited[nx][ny] = true;
							queue.offer(new Point(nx, ny));
							ans++;
						}
					}
				}
			}
		}
	}
}
