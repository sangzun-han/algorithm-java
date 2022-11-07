import java.util.*;
import java.io.*;

public class Main_BJ_1926_그림 {
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static class Point {
		int x,y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		int cnt = 0;
		int area = 0;
		for(int i=0; i<N; i++ ) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j] && map[i][j]==1) {
					area = Math.max(bfs(i,j),area);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(area);
	}

	private static int bfs(int x, int y) {
		int area = 0;
		Queue<Point> queue = new ArrayDeque<>();
		visited[x][y] = true;
		queue.offer(new Point(x,y));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			area++;
			for(int d=0; d<4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny] && map[nx][ny]==1) {
					queue.offer(new Point(nx,ny));
					visited[nx][ny] = true;
					
				}
			}
		}
		return area;
	}
}
