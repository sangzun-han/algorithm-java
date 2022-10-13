import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11660_구간합구하기5 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); // 표의 크기
		int M = Integer.parseInt(st.nextToken()); // 구해야 하는 횟수
		int[][] map = new int[N+1][N+1];
		
		// dp 배열
		int[][] d = new int[N+1][N+1];
		
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				d[i][j] = d[i-1][j] + d[i][j-1] - d[i-1][j-1] + map[i][j];
			}
		}
		
 		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int ans = d[x2][y2] - d[x2][y1-1] - d[x1-1][y2] + d[x1-1][y1-1];
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
		
		
	}
}
