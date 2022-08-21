package BaekJoon.Boj11559;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;


public class Main {
	static class Point {
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Save {
		int x;
		int y;
		
		Save(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N = 12;
	static int M = 6;
	static int ans = 0;
	static int cnt;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	static char[][] map;
	static char[][] copyMap;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new char[N][M];
		copyMap = new char[N][M];
		for(int i=0; i<N; i++) {
			char[] s = br.readLine().toCharArray();
			map[i] = s;
			copyMap[i] = s;
		}
		
		while(true) {
			int boonCnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] != '.') {
						boonCnt += bfs(i,j);
					}
				}
			}
			if(boonCnt==0) break;
			ans++;
			down();
		}
		System.out.println(ans);
	}

	private static int bfs(int x, int y) {
		Queue<Save> sQueue = new ArrayDeque<>();
		Queue<Point> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		
		queue.offer(new Point(x, y));
		sQueue.offer(new Save(x,y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
					if(map[x][y] == map[nx][ny]) {
						queue.offer(new Point(nx,ny));
						sQueue.offer(new Save(nx,ny));
						visited[nx][ny] = true;
					}
				}
			}
			
		}
		
		if(sQueue.size() >= 4) {
			while(!sQueue.isEmpty()) {
				Save p = sQueue.poll();
				map[p.x][p.y] = '.';
			}
			return 1;			
		}
		else return 0;		
	}
	
	private static void down() {
		for(int i=N-1; i>=0; i--) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != '.') {
					for(int k=N-1; k>=0; k--) {
						if(i+k < N && map[i+k][j]=='.') {
							map[i+k][j] = map[i][j];
							map[i][j] ='.';
							break;
						}
					}
				}
			}
		}
	}
}

