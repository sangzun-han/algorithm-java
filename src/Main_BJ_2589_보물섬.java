import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2589_보물섬 {
	static int N,M;
	static int[][] map;
	static int[][] copyMap;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static int ans = Integer.MIN_VALUE;
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
		copyMap = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				if(s.charAt(j) == 'W') 	{
					map[i][j] = 0;
					copyMap[i][j] = 0;
				}
				else if(s.charAt(j) == 'L') {
					map[i][j] = 1;
					copyMap[i][j] = 1;
				}
			}
		}
		
	
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1) {
					bfs(i,j);
				}
			}
		}
		System.out.println(ans-1);
		
	}
	private static void bfs(int x, int y) {
		
		boolean[][] visited = new boolean[N][M];
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(x,y));
		visited[x][y] = true;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if(nx >= 0 && nx < N &&  ny >=0 && ny < M && !visited[nx][ny] && map[nx][ny]==1) {
					queue.offer(new Point(nx,ny));
					visited[nx][ny] = true;
					copyMap[nx][ny] = copyMap[p.x][p.y] + 1;
				}
			}
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copyMap[i][j] > ans) {
					ans = copyMap[i][j];
				}
				copyMap[i][j] = map[i][j];
			}
		}
		
		
	
	}
}
