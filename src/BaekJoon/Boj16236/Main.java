package BaekJoon.Boj16236;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	int dist; // 상어의 이동 거리

	Point(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}

public class Main {
	static int INF = 401;
	static int N;
	static int[][] map;
//	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int sharkX, sharkY;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		sharkX = 0;
		sharkY = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 상어의 위치 저장해둔뒤 0으로 변경
				if (map[i][j] == 9) {
					sharkX = i;
					sharkY = j;
					map[i][j] = 0;
				}
			}
		}

		int ans = bfs(sharkX, sharkY);
		System.out.println(ans);

	}

	private static int bfs(int x, int y) {
		int ret = 0;
		int size = 2;
		int cnt = 2;
		Point minPt = new Point(x, y, 0);

		while (minPt.dist != INF) {
			boolean[][] visited = new boolean[20][20];
			Queue<Point> queue = new ArrayDeque<>();
			visited[minPt.x][minPt.y] = true;
			queue.offer(new Point(minPt.x, minPt.y, 0));
			minPt.dist = INF;

			while (!queue.isEmpty()) {
				Point curr = queue.poll();
				if (curr.dist > minPt.dist)
					break;

				// 못먹는 물고기
				if (map[curr.x][curr.y] > size)
					continue;
				// 먹을 수 있는 물고기라면
				if (map[curr.x][curr.y] != 0 && map[curr.x][curr.y] < size) {
					if (curr.dist < minPt.dist) {
						minPt = curr;
					} else if (curr.dist == minPt.dist) {
						if (curr.x < minPt.x)
							minPt = curr;
						else if (curr.x == minPt.x && curr.y < minPt.y)
							minPt = curr;
					}
					continue;
				}

				for (int d = 0; d < 4; d++) {
					int nx = curr.x + dx[d];
					int ny = curr.y + dy[d];

					if (nx < 0 || nx >= N || ny < 0 || ny >= N)
						continue;
					if (visited[nx][ny])
						continue;

					visited[nx][ny] = true;
					queue.offer(new Point(nx, ny, curr.dist + 1));
				}
			}

			if (minPt.dist != INF) {
				ret += minPt.dist;
				cnt--;
				if (cnt == 0) {
					size++;
					cnt = size;
				}
				map[minPt.x][minPt.y] = 0;
			}
		}

		return ret;
	}

}