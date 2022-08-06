package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

import java.util.StringTokenizer;

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Boj3190 {
	static Deque<Point> snake = new ArrayDeque<>();
	static int[][] map;
	static int N,K,L, ans = 1, d;
	static int[] dx = { 0,1, 0, -1};
	static int[] dy = { 1, 0, -1, 0  };	
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		// 보드의 크기 N
		int N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		
		// 사과의 개수 K개
		K = Integer.parseInt(br.readLine());

		// 사과를 보드에 '1'로 표시
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			map[row][col] = 1;
		}
		// 뱀의 방향 변환 횟수 L
		L = Integer.parseInt(br.readLine());

		// 뱀의 첫 위치
		snake.add(new Point(1, 1));
		map[1][1] = 2;
		
		A: for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			String C = st.nextToken();
			while (true) {
				if (ans > X)
					break;
				Point p = snake.peekFirst();
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				if (nx < 1 || nx > N || ny < 1 || ny > N) {
					flag = true;
					break A;
				}
				if (map[nx][ny] == 2) {
					flag = true;
					break A;
				}
				if (map[nx][ny] == 1) {
					snake.offerFirst(new Point(nx, ny));
					map[nx][ny] = 2;
				} else {
					snake.offerFirst(new Point(nx, ny));
					map[nx][ny] = 2;
					Point last = snake.pollLast();
					map[last.x][last.y] = 0;
				}
				ans++;
			}
			if (C.equals("L"))
				d = (d + 3) % 4;
			else
				d = (d + 1) % 4;
		}
		
	
		while (!flag) {
			Point p = snake.peekFirst();
			int nx = p.x + dx[d];
			int ny = p.y + dy[d];

			// 범위벗어남

			if (nx < 1 || nx > N || ny < 1 || ny > N)
				break;
			// 몸박
			if (map[nx][ny] == 2)
				break;

			// 사과 만남 -> 사과먹고 뱀 길이 늘림
			if (map[nx][ny] == 1) {
				snake.offerFirst(new Point(nx, ny));
				map[nx][ny] = 2;
			}
			// 사과 아님 -> 뱀 위치 변경하고 뱀꼬리 0으로 변경해서 길이 유지
			else {
				snake.offerFirst(new Point(nx, ny));
				map[nx][ny] = 2;
				Point last = snake.pollLast();
				map[last.x][last.y] = 0;
			}
			ans++;
		}
		System.out.println(ans);
	}
}
