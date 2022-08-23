package BaekJoon.Boj13459;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj13459 {
	static class Point {
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N,M;
	static char[][] map;
	static int T = 10;
	static int redX = 0;
	static int redY = 0;
	static int blueX = 0;
	static int blueY = 0;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='R') {
					redX = i;
					redY = j;
				}
				if(map[i][j] == 'B') {
					blueX = i;
					blueY = j;
				}
			}
		}
		
		while(T--> 0) {
			if(bfs()) {
				System.out.println(1);
				break;
			}
		}
		System.out.println(0);
	}

	private static boolean bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(redX, redY));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for(int d=0; d<4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if(map[nx][ny] == '.') {
						queue.offer(new Point(nx,ny));
					}
					if(map[nx][ny]=='O') return true;
				}
			}
		}
		return true;
	}
}
