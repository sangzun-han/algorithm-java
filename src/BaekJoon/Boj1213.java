package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1213 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		int[] alpha = new int[26];
		String ans = "";
		int oddCount = 0;
		for(int i=0; i<word.length(); i++) {
			alpha[word.charAt(i)-'A'] += 1;
		}
		
		for(int i=0; i<alpha.length; i++) {
			if(alpha[i]%2!=0) oddCount++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		if(oddCount > 1) System.out.println("I'm Sorry Hansoo");
		else {
			for(int i=0; i<alpha.length; i++) {
				for(int j=0; j<alpha[i]/2; j++) {
					sb.append((char)(i+65));
				}
			}
			ans += sb.toString();
			String end = sb.reverse().toString();
			
			sb = new StringBuilder();
			for(int i=0; i<alpha.length; i++) {
				if(alpha[i]%2==1) {
					sb.append((char)(i+65));
				}
			}
			ans += sb.toString()+end;
		}
		System.out.println(ans);
	}
}
