import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_18428_감시피하기 {
	static int N;
	static char[][] map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,-1,0,1};
	static List<Point> student = new ArrayList<>();
	
	static class Point {
		int x;
		int y;
		
		public Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	// 완전탐색
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N =Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] == 'S') {
					student.add(new Point(i,j));
				}
			}
		}
		
		dfs(0);
		System.out.println("NO");
	}

	private static void dfs(int cnt) {
		if(cnt==3) {
			bfs();
			return;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]=='X') {
					map[i][j] ='O';
					dfs(cnt+1);
					map[i][j] ='X';
				}
			}
		}
		
	}

	private static void bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		boolean[][] isvisited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 'T') {
					queue.offer(new Point(i,j));
					isvisited[i][j] = true;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			int x = p.x;
			int y = p.y;
			
			for(int d=0; d<4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				while(nx>=0 && nx < N && ny >= 0 && ny < N) {
					if(map[nx][ny] != 'O') {
						isvisited[nx][ny] = true;
						nx += dx[d];
						ny += dy[d];
					}else {
						break;
						
					}
				}
			}
		}
		
		if(check(isvisited)) {
			System.out.println("YES");
			System.exit(0);
		}
		
		
	}

	private static boolean check(boolean[][] isvisited) {
		for(Point p : student) {
			if(isvisited[p.x][p.y]) return false;
		}
		return true;
	}
}
