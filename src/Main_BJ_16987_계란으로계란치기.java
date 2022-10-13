import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_16987_계란으로계란치기 {
	static int N;
	static int ans = Integer.MIN_VALUE;
	static int[] W,S;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		W = new int[N];
		S = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			W[i] = Integer.parseInt(st.nextToken());
		}
		
		crash(0);
		System.out.println(ans);
	}

	private static void crash(int cnt) {
		// 마지막계란
		if(cnt==N) {
			int count = 0;
			for(int i=0; i<N; i++) {
				if(S[i]<=0) count++;
			}
			ans = Math.max(count,ans);
			return;
		}
		// 현재 계란이 이미 깨져있는 경우 다음계란으로 넘어감
		else if(S[cnt]<=0) crash(cnt+1);
		else {
			boolean flag = false;
			// cnt번째 계란으로 i번째 칠 계란 찾음
			for(int i=0; i<N; i++) {
				if(i==cnt) continue;
				if(S[i] > 0) {
					flag = true;
					S[i] -= W[cnt];
					S[cnt] -= W[i];
					crash(cnt+1);
					S[i] += W[cnt];
					S[cnt] += W[i];
				}
			}
			
			if(!flag) crash(cnt+1);
		}
	}
}
