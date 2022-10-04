import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2003_bruteforce {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); // 찾아야되는 숫자
		int[] nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// 1. i를 결정
		// 2. j를 결정
		// 3. 모든 수를 합해본다.
		int ans = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int sum = 0;
				for(int k=i; k<=j; k++) {
					sum += nums[k];
				}
				if(sum == M) ans++;
			}
		}
		
		System.out.println(ans);
	}
}
