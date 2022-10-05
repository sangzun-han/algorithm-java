import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2636_치즈_DFS {
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int cheeze;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		cheeze = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) cheeze++;
			}
		}
		int ans = 0;
		int time = 0;
		
		while(cheeze!=0) {
			visited = new boolean[N][M];
			ans = cheeze;
			dfs(0,0);
			time++;
		}
		
		System.out.println(time);
		System.out.println(ans);
	}
	
	private static void dfs(int x, int y) {
		
		for(int d=0; d<4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(nx >=0 && nx < N && ny >=0 && ny < M && !visited[nx][ny]) {
				visited[nx][ny] = true;
				if(map[nx][ny]==0) {
					dfs(nx,ny);					
				} else {
					cheeze--;
					map[nx][ny] = 0;
				}
			}
		}
	}
}
