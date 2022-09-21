import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2225_합분해 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] d = new int[K+1][N+1];
		d[0][0] = 1;
		
		for(int i=1; i<=K; i++) {
			for(int j=0; j<=N; j++) {
				for(int k=0; k<=j; k++) {
					d[i][j] += d[i-1][j-k];
					d[i][j] %= 1000000000;
				}
			}
		}
		System.out.println(d[K][N]);
	}
}
