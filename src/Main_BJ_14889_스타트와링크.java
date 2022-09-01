import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14889_스타트와링크 {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0,0);
		System.out.println(ans);
	}
	private static void comb(int cnt, int start) {
	
		if(cnt==N/2) {
			diff();
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			comb(cnt+1, i+1);
			visited[i] = false;
		}
	}
	
	static void diff() {
		int s_team = 0;
		int l_team = 0;
		
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(visited[i] && visited[j]) s_team += map[i][j] + map[j][i];
				else if(!visited[i] && !visited[j]) l_team += map[i][j] + map[j][i];
			}
		}
		
		int diff = Math.abs(s_team - l_team);
	
		if(diff==0) {
			System.out.println(diff);
			System.exit(0);
		}
		ans = Math.min(diff, ans);
	}
	
}
