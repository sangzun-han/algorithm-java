package BaekJoon.Boj16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int cnt = 0;
		while (a!=b) {
			cnt++;
			int temp = b;
			if (b%10 == 1) b = (b/10);
			else if (b%2==0) b /= 2;
			
			if (temp==b) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(cnt+1);
	}
	
}

