package BaekJoon.Boj6588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.
	 */
	public static void main(String[] args) throws IOException{
		final int MAX_SIZE = 1000001;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		boolean prime[] = new boolean[MAX_SIZE];
		prime[0] = true;
		prime[1] = true;
		
		for(int i=2; i*i<MAX_SIZE; i++) {
			if(prime[i]==false) {
				for(int j=i+i; j<MAX_SIZE; j+=i) {
					prime[j] = true;
				}
			}
		}
		while(true) {
			boolean flag = false;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n==0) break;
			
			for(int i=3; i<=n/2; i++) {
				if(prime[n-i] == false && prime[i]==false) {
					System.out.println(n + " = " + i + " + " + (n-i));
					flag = true;
					break;
				}
			}
			if(!flag) System.out.println("Goldbach's conjecture is wrong.");
			
		}
	}
}


