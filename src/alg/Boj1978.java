package alg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1978 {
	public static void main(String[] args) throws IOException{
		// 소수가 아니라면 true
		
		boolean[] prime = new boolean[1001];
		prime[0] = true;
		prime[1] = true;
		int ans = 0;
		for(int i=2; i*i<=1000; i++) {
			if (prime[i] == false) {
				for(int j=i*2; j<=1000; j+=i) {
						prime[j] = true;
					}
				}
		}
		
	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
			
		while(st.hasMoreTokens()) {
			int a = Integer.parseInt(st.nextToken());
			if (prime[a] == false) ans++;
		}
		
		System.out.println(ans);
	}
}
