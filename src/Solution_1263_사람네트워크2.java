import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1263_사람네트워크2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 사람 수
			int[][] map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && map[i][j]==0) map[i][j] = 9999999;
				}
			}
		
			// 경유지, 출발지, 목적지
			for(int k=0; k<N; k++) {
				for(int i=0; i<N; i++) {
					if(i==k) continue;
					for(int j=0; j<N; j++) {
						if(i==j || k==j) continue;
						if(map[i][j] > map[i][k] + map[k][j]) {
							map[i][j] = map[i][k] + map[k][j];
						}
					}
				}
			}
			int ans = Integer.MAX_VALUE;
			
			for(int i=0; i<N; i++) {
				int sum = 0;
				for(int j=0; j<N; j++) {
					sum += map[i][j];
				}
				ans = Math.min(ans, sum);
			}
			System.out.println("#"+tc+" "+ans);
			
		}
	}
}
