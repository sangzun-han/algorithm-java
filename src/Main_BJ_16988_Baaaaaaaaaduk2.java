import java.io.*;
import java.util.*;

public class Main_BJ_16988_Baaaaaaaaaduk2 {
	static int N,M,ans;
	static int[][] map;
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
		
		ans = -1;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		comb(0,0,0);
		System.out.println(ans);
	}
	private static void comb(int x, int y, int cnt) {
		if(cnt==2) {
			ans = Math.max(ans, bfs());
			return;
		}
		
		for(int i=x; i<N; i++) {
			for(int j=0; j<M; j++) {
				
				if(map[i][j]==0) {
					map[i][j] = 1;
					comb(i,j,cnt+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	private static int bfs() {
		boolean[][] visited = new boolean[N][M];
		Queue<Point> queue = new ArrayDeque<>();
		int total = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==2 && !visited[i][j]) {
					boolean flag = true; // 죽었나 안죽었나
					queue.offer(new Point(i,j));
					visited[i][j] = true;
					
					int cnt = 0;
					
					while(!queue.isEmpty()) {
						Point p = queue.poll();
						cnt++;
						
						for(int d=0; d<4; d++) {
							int nx = p.x + dx[d];
							int ny = p.y + dy[d];
							
							if(nx>=0 & nx<N && ny>=0 && ny<M) {
								if(map[nx][ny]==0) {
									flag = false;
								}
								
								else if(map[nx][ny]==2 && !visited[nx][ny]) {
									queue.offer(new Point(nx,ny));
									visited[nx][ny] = true;
								}
							}
						}
					}
					if(flag) {
						total += cnt;
					}
				}
			}
		}
		return total;
	}

}
