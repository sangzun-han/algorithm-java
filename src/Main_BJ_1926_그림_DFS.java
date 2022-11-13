import java.util.*;
import java.io.*;

public class Main_BJ_1926_그림_DFS{
	static int N,M,area;
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
		int maxArea = 0;
		for(int i=0; i<N; i++ ) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j] && map[i][j]==1) {
					area = 1;
					dfs(i,j);
					maxArea = Math.max(area, maxArea);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(maxArea);
	}
	
	private static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int d=0; d<4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny] && map[nx][ny]==1) {
				area++;
				dfs(nx,ny);
			}
		}
		
		
	}
	
}
