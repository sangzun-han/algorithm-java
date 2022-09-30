import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_17070_파이프옮기기1 {
	static int N;
	static int ans = 0;
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(1,2,0);
		System.out.println(ans);
	}

	private static void dfs(int x, int y, int dir) {
		if(x==N && y==N) {
			ans++;
			return;
		}
		
		// 가로
		if(dir==0) {
			if(y+1 <= N && map[x][y+1] == 0) dfs(x,y+1,0);
		}  
		if(dir == 1) {
			if(x+1 <=N && map[x+1][y] == 0) dfs(x+1,y,1);
		} 
		 if(dir == 2) {
			if(x+1 <= N && map[x+1][y] == 0) dfs(x+1,y,1);
			if(y+1 <= N && map[x][y+1] == 0) dfs(x,y+1,0);
		}

		if(x+1 <=N && y+1 <=N && map[x][y+1] == 0 && map[x+1][y] == 0 && map[x+1][y+1]==0) dfs(x+1,y+1,2);		
		
	}
}
