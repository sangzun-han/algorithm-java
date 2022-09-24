import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_1261_알고스팟 {
	static int N,M;
	static boolean[][] visited;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1 ,1};
	
	static class Point implements Comparable<Point>{
		int x,y,cnt;
		
		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			return this.cnt - o.cnt;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M];
		map = new int[N][M];
	
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j)-'0';
			
			}
		}
	
		System.out.println(BFS(0,0));
	}

	private static int BFS(int x, int y) {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.offer(new Point(x,y,0));
		visited[x][y] = true;
	
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			if(p.x == N-1 && p.y == M-1) {
				return p.cnt;
			}
			
			for(int d=0; d<4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				if(!visited[nx][ny] && map[nx][ny]==0) {
					visited[nx][ny] = true;
					queue.offer(new Point(nx, ny , p.cnt));
				}
				
				if(!visited[nx][ny] && map[nx][ny]==1) {
					visited[nx][ny] = true;
					queue.offer(new Point(nx, ny, p.cnt+1));
				}
			}
		}
		return 0;
	
	}
}
