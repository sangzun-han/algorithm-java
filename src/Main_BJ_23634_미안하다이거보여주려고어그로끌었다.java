import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_23634_미안하다이거보여주려고어그로끌었다 {
	static int N,M;
	static int day = 0;
	static int size = 0;
	static boolean flag = true;
	static int[][] map;
	static int[][] copy;
	static boolean[][] visited;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static Queue<Point> queue = new ArrayDeque<>();
	static class Point {
		int x,y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		copy = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j) -'0';
				if(map[i][j]==0) queue.offer(new Point(i,j));
			}
		}
		int qSize = queue.size();
		while(flag) {
			fire();
			search();
			day++;
		}
		
		System.out.print((day-1)+" "+(size+qSize));
		
	}

	private static void search() {
		A:for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==1) {
					flag =  true;
					break A;
				} else {
					flag = false;
				}
			}
		}
	}

	private static void fire() {
		Queue<Point> next = new ArrayDeque<>();
		while(!queue.isEmpty()) {			
			Point p = queue.poll();
			visited[p.x][p.y] = true;
			for(int d=0; d<4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M ) continue;
				
				if(map[nx][ny]==1) {
					next.offer(new Point(nx,ny));
					map[nx][ny] = 0;
					size++;
				}
			}
		}
		queue = next;
	}
}