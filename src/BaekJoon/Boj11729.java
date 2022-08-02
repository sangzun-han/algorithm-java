package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11729 {
	public static int cnt = 0;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		hanoi(n,1,2,3);
		System.out.println(cnt);
		System.out.println(sb);
		
	}

	private static void hanoi(int n, int start, int temp, int end) {
		cnt++;
		if(n==1) {
			sb.append(start+" "+end+"\n");
			return;
		} else {
			hanoi(n-1, start,end,temp);
			sb.append(start+" "+end+"\n");
			hanoi(n-1,temp,start,end);
		}
		
	}
}
