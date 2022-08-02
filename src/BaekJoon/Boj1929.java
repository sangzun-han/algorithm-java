package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1929 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[] prime = new boolean[M+1];
		prime[0] = true;
		prime[1] = true;
		for(int i=2; i*i<=M; i++) {
			if(prime[i]==false) {
				for(int j=i+i; j<=M; j+=i) {
					prime[j] = true;
				}
			}
		}
		for(int i=N; i<=M; i++) {
			if(prime[i] == false) {
				System.out.println(i);
			}
		}
		
	}
}
