/**
 * 1. 빙산의 수 세기
 * 2. 빙산의 수가 0 또는 2 이상이면 종료
 * 3. 빙산의 수가 1개라면 빙산 녹이기
 */
package BaekJoon.Boj2573;

import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int year = 0;
		while (true) {
			int count = countIce(map);
			// 빙산이 모두 0
			if (count == 0) {
				System.out.println(0);
				break;
			}

			// 빙산이 2개 이상 나누어짐
			else if (count >= 2) {
				System.out.println(year);
				break;
			}

			// 빙산이 나누어지지 않았음 -> 빙산 녹이기
			else if (count == 1) {
				map = melt(map);
				year++;
			}
		}
	}

	// 빙산 녹이기
	private static int[][] melt(int[][] map) {
		int[][] copyMap = new int[N][M]; // 똑같은 크기의 map만들어서 map에 넣기위한 변수

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					int cnt = 0;
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] != 0) continue;
						cnt++;
					}
					copyMap[i][j] = (map[i][j] - cnt > 0) ? map[i][j]-cnt : 0;
				}
			}
		}
		return copyMap;
	}
	
	// 빙산의 개수
	private static int countIce(int[][] map) {
		boolean[][] visited = new boolean[N][M];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					visited[i][j] = true;
					cnt++;
					Queue<int[]> queue = new ArrayDeque<>();

					queue.offer(new int[] { i, j });

					while (!queue.isEmpty()) {
						int[] xy = queue.poll();
					
						for (int d = 0; d < 4; d++) {
							int nx = xy[0] + dx[d];
							int ny = xy[1] + dy[d];
							
							if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || map[nx][ny] == 0)
								continue;

							// 경계도 아니고 방문하지 않았고 0이 아니디.

							visited[nx][ny] = true;
							queue.offer(new int[] { nx, ny });

						}
					}
				}
			}
		}
		return cnt;
	}

}
