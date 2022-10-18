import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_4485_녹색옷입은애가젤다지 {
	static int N;
	static int[][] map, ans;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static class Point {
		int x,y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = 1;
		while(true) {
			
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			map = new int[N][N];
			ans = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					ans[i][j] = Integer.MAX_VALUE;
				}
			}
			ans[0][0] = map[0][0];
			sb.append("Problem").append(" ").append(tc).append(":").append(" ");
			dijkstra(0,0);
			tc++;
		}
		
		System.out.println(sb);
	}
	
	private static void dijkstra(int x, int y) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(x, y));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				if(ans[nx][ny] > ans[p.x][p.y] + map[nx][ny]) {
					ans[nx][ny] = ans[p.x][p.y] + map[nx][ny];
					queue.offer(new Point(nx, ny));
				}
			}
		}
		
		sb.append(ans[N-1][N-1]).append("\n");
		
		
	}


}
