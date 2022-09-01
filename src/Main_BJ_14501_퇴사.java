import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14501_퇴사 {
	static int N;
	static int[] T;
	static int[] P;
	static int ans = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P = new int[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken()); // 시간
			P[i] = Integer.parseInt(st.nextToken()); // 비용
		}
		
		subset(0,0);
		System.out.println(ans);
	}

	/**
	 * 상담을 함 or 상담을 안함
	 * 1. 상담을 안함 -> day+1, sum
	 * 2. 상담을 한다 -> day+T[day], sum + P[day]
	 * @param day
	 * @param sum
	 */
	private static void subset(int day, int sum) {
		if(day > N) return;
		if(day == N) {
			if(sum > ans) {				
				ans = sum;
			}
			return;
		}
		
		subset(day+1, sum); // 상담 안한다.
		subset(day+T[day], sum+P[day]); //상담 한다
		
		
			
	
		
		
	}
}
