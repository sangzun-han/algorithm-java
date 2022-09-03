import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_BJ_11053_가장긴증가하는부분수열 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] D = new int[N];
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		// D[n] = A[n]을 마지막으로 하는 가장 긴 증가하는 부분 수열의 길이
		for(int i=0; i<N; i++) {
			D[i] = 1;
			for(int j=0; j<N; j++) {
				if(A[j] < A[i] && D[i] < D[j]+1) {
					D[i] = D[j]+1;
				}
			}
		}
		
		int ans = 0;
		for(int i=0; i<N; i++) {
			if(ans <D[i]) {
				ans = D[i];
			}
		}
		System.out.println(ans);
	}
}
