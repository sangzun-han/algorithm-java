package BaekJoon.Boj17144;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int R, C, T;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static List<Integer> air = new ArrayList<>();
	static int[][] map;
	static int[][] copyMap;

	static Queue<Point> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 격자 크기
		C = Integer.parseInt(st.nextToken()); // 격자 크기
		T = Integer.parseInt(st.nextToken()); // T초
		map = new int[R][C];
		copyMap = new int[R][C];
		
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < C; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == -1 ) {
						air.add(i);
					}
				}
			}

			while (T-- > 0) {
				dust(); // 미세먼지 확산
				air1(); // 공기청정기 작동
				air2();
				
			}
			
		int ans = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] > 0) {
					ans += map[i][j];
				}
			}
		}
		System.out.println(ans);

	}

	private static void air1() {
		int top = air.get(0);
		for(int r=top-1; r>=1; r--) map[r][0] = map[r-1][0];
		for(int c=0; c<=C-2; c++) map[0][c] = map[0][c+1];
		for(int r = 0; r<=top-1; r++) map[r][C-1] = map[r+1][C-1];
		for(int c=C-1; c>=2; c--) map[top][c] = map[top][c-1];
		map[top][1] = 0;
	}
	
	private static void air2() {
		 int bottom = air.get(1);
	     for (int r = bottom + 1; r <= R - 2; r++) map[r][0] = map[r+1][0];
	     for (int c = 0; c <= C - 2; c++) map[R-1][c] = map[R-1][c+1];
	     for (int r = R-1; r >= bottom + 1; r--) map[r][C-1] = map[r-1][C-1];
	     for (int c = C-1; c >= 2; c--) map[bottom][c] = map[bottom][c-1];
	     map[bottom][1] = 0;
	}

	// 미세 먼지 퍼트리기
	private static void dust() {
		copyMap = new int[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if (map[i][j] != -1 && map[i][j] != 0) {
					queue.offer(new Point(i, j));
				}
			}
		}
		
		if (queue.size() == 0) return;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int cnt = 0;
			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				// 경계체크,공기청정기,
				if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != -1) {
					cnt++;
					copyMap[nx][ny] += map[p.x][p.y] / 5;
				}
			}
			map[p.x][p.y] -= (map[p.x][p.y]/5) * (cnt);
		
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				map[i][j] += copyMap[i][j];
			}
		}
	}
}
