import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main_BJ_1699_제곱수의합 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// D[n] : n을 제곱수의 합으로 나타날 때의 항의 최소 개수
		int[] D = new int[N+1];
		for(int i=1; i<=N; i++) {
			D[i] = i;
			for(int j=1; j*j<=i; j++) {
				if(D[i] > D[i-j*j] + 1) {
					D[i] = D[i-j*j] + 1;
				}
			}
		}
		System.out.println(D[N]);
	}
}