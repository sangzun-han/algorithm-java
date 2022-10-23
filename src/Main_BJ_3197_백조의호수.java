import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_3197_백조의호수 {
	static int R,C;
	static char[][] map;
	static int cnt = 0;
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
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		// . 물
		// X 빙판
		// L 백조
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]=='.') {
					bfs(i,j);
				}
			}
		}
		
		System.out.println(Arrays.deepToString(map));
		System.out.println(cnt);
		
	}
	private static void bfs(int x, int y) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(x,y));
		visited[x][y] = true;
		int qSize = queue.size();
		while(!queue.isEmpty()) {
			for(int i=0; i<qSize; i++) {
				Point p = queue.poll();
				
				for(int d=0; d<4; d++) {
					int nx = p.x + dx[d];
					int ny = p.y + dy[d];
					
					if(nx>=0 && nx<R && ny>=0 && ny<C && !visited[nx][ny] && map[nx][ny]=='X') {
						map[nx][ny] ='.';
					}
				}
			}
		}
		
	}
}
