package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Swea1861 {
	public static int[][] map;
	public static int n;
	public static int cnt;
	public static int max;
	public static int value;
	public static Queue<Point> queue;
	public static int[] dx = { 0, -1, 0, 1 };
	public static int[] dy = { 1, 0, -1, 0 };
	public static boolean[][] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {

			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			max = -1;
			value = 0;
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					cnt = 0;
					isSelected = new boolean[n][n];
					bfs(i, j);
					if(max < cnt) {
						max = cnt;
						value = map[i][j];
					}
	
					if (max == cnt && value > map[i][j]) {
						value = map[i][j];
					}
				}
			}
			System.out.println("#"+(tc+1)+" "+ value+" "+max);
		}
	}

	private static void bfs(int x, int y) {
		queue = new LinkedList<>();
		isSelected[x][y] = true;
		queue.offer(new Point(x, y));

		while (!queue.isEmpty()) {
			cnt++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Point p = queue.poll();

				for (int d = 0; d < 4; d++) {
					int nx = p.x + dx[d];
					int ny = p.y + dy[d];

					if (nx >= 0 && ny >= 0 && nx < n && ny < n && isSelected[nx][ny] == false
							&& (map[nx][ny] - map[p.x][p.y] == 1)) {
						queue.offer(new Point(nx, ny));
						isSelected[nx][ny] = true;
					}
				}
			}
		}

	}
}
