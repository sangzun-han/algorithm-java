import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_14466_소가길을건너간이유6 {
	static int N,K,R;
	static int ans = 0;
	static class Point {
		int x,y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static boolean[][][][] visited;
	static boolean[][] check;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static Point[] p;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N*N 격자
		K = Integer.parseInt(st.nextToken()); // K마리의 소
		R = Integer.parseInt(st.nextToken()); // R 길 위치
		
		visited = new boolean[N+1][N+1][N+1][N+1];
		
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			visited[r1][c1][r2][c2] = true;
			visited[r2][c2][r1][c1] = true;
		}
		
		p = new Point[K+1];
		
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			p[i] = new Point(x,y);
		}
		
		for(int i=0; i<K; i++) {
			check = new boolean[N+1][N+1];
			bfs(p[i].x, p[i].y);
			for(int j=i; j<K; j++) {
				if(!check[p[j].x][p[j].y]) ans++;
			}
 		}
		System.out.println(ans);
		
	}

	private static void bfs(int x, int y) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(x,y));
		check[x][y] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for(int d=0; d<4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if(nx <= 0 || nx > N || ny <= 0 || ny > N) continue;
				if(visited[p.x][p.y][nx][ny] || check[nx][ny]) continue;
				check[nx][ny] = true;
				queue.offer(new Point(nx, ny));
			}
		}
		
	}
}
