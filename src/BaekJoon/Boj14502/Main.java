package BaekJoon.Boj14502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 일단 DFS, 백트래킹 n,M의 범위가 작고 최대값이 NM 시간제한2초기 때문에 브루토포스
 * 1. 벽을 3개 세운다 (N*M)^3
 * 2. 벽 세울때마다 바이러스 퍼질수 없는 곳 크기 구하기 (빈칸의 개수 - 바이러스 퍼진 칸 개수(BFS) NM)
 * 3. 시간 복잡도 (NM)^4
 * @author sangjun
 *
 */
public class Main {
	
	static class Point {
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int N;
	static int M;
	static int ans = Integer.MIN_VALUE;
	static int[][] map;
	static int[][] copyMap;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		copyMap = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 벽세우기
		dfs(0);
		System.out.println(ans);
	}

	private static void dfs(int cnt) {
		if(cnt==3) {
			bfs();
			return;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					dfs(cnt+1);
					map[i][j] = 0;
				}
			}
		}
		
	}

	private static void bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copyMap[i][j] = map[i][j];
				if(copyMap[i][j] == 2) queue.offer(new Point(i,j));
			}
		}
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for(int d=0; d<4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && copyMap[nx][ny] == 0) {
					copyMap[nx][ny] = 2;
					queue.offer(new Point(nx,ny));
				}
			}
		}
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copyMap[i][j]==0) cnt++;
			}
		}
		ans = Math.max(ans, cnt);
	}

	
}
