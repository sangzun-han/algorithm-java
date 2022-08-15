/**
 *  D[n] = n을 1,2,3의 나타내는 방법의 수
 *  ㅁ 
 *  D[n] = D[n-1] + D[n-2] + D[n-3]
 *  D[0] = 1
 */

package BaekJoon.Boj9095;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int cnt;
	static int[] nums;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			N = Integer.parseInt(br.readLine());
			nums = new int[N];
			cnt = 0;
			int ans = perm(0,N);
			System.out.println(ans);
		}
	}

	private static int perm(int sum, int N) {
		if(sum > N) return 0;
		if(sum == N) return 1;
		
		int prev = 0;
		for(int i=1; i<=3; i++) {
			prev += perm(sum+i,N);
		}
		return prev;
		
	}
}
