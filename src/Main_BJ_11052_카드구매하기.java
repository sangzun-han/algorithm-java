import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11052_카드구매하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] cards = new int[N+1];
		
		// dp[n] : 카드 n개 샀을 때 최대비용
		int[] dp = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j]+cards[j]);
			}
		}
		System.out.println(dp[N]);
	}
}
