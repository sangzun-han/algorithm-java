import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_10026_적록색약 {
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		int cnt2 = 0;
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					cnt++;
				}
			}
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] =='G') {
					map[i][j] = 'R';
				}
			}
		}
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					cnt2++;
				}
			}
		}
		System.out.println(cnt+" "+cnt2);
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int d=0; d<4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny] && map[nx][ny]==map[x][y]) {
				dfs(nx,ny);
				
			}
		}
		
	}
}
