import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16973_직사각형탈출 {
	static int N,M,H,W,Sr,Sc,Fr,Fc;
	static int[][] map;
	static int[][] s,dp;
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
		map = new int[N+1][M+1];
		s = new int[N+1][M+1];
		dp = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		Sr = Integer.parseInt(st.nextToken());
		Sc = Integer.parseInt(st.nextToken());
		Fr = Integer.parseInt(st.nextToken());
		Fc = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				s[i][j] = s[i][j-1] + s[i-1][j] - s[i-1][j-1] + map[i][j];
			}
		}
		
		bfs(Sr,Sc);
	}
	
	private static void bfs(int x, int y) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(x,y));
		dp[x][y] = 0;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
					
			for(int d=0; d<4; d++) {
				
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if(nx < 1 || nx > N || ny < 1 || ny > M) continue;
				
				if(nx >=1 && nx+H-1 <= N && ny >=1 && ny+W-1 <= M) {
					if(sum(nx,ny,nx+H-1,ny+W-1) == 0) {
							if(dp[nx][ny]==-1) {
								queue.offer(new Point(nx, ny));
								dp[nx][ny] = dp[p.x][p.y]+1;
							}
					
					}
				}
			}
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(dp[Fr][Fc]);
	}

	private static int sum(int x1, int y1, int x2, int y2) {
		return s[x2][y2] - s[x1-1][y2] - s[x2][y1-1] + s[x1-1][y1-1];
	}	
}
