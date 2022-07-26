package alg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2609 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		System.out.println(GCD(a,b));
		System.out.println(a*b/GCD(a,b));
		
		
	}
	
	public static int GCD(int a, int b) {
		while(b!=0) {
			int r = a%b;
			a = b;
			b = r;
		}
		return a;
		
	}
}
