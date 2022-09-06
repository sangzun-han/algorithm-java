import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_12865_평범한배낭 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] W = new int[N+1];
		int[] V = new int[N+1];
		
		// D[i][j] : i번째 물건까지 봤을때 배넝에 넣은 물건 무게의 합이 j 일때 최대값
		int[][] D = new int[N+1][K+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] =  Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				D[i][j] = D[i-1][j];
				if(j - W[i] >= 0) {
					D[i][j] = Math.max(D[i][j], D[i-1][j-W[i]] + V[i]);
				}
			}
		}
		System.out.println(D[N][K]);
	}
}
