package BaekJoon.Boj1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		String[] words = new String[n];
		Integer[] alpha = new Integer[26];
		Arrays.fill(alpha, 0);
		// 입력
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			StringBuilder sb = new StringBuilder(input);
			words[i] = sb.toString();
		}
		
		
		for(int i=0; i<n; i++) {
			char[] input = words[i].toCharArray();	
			int pos = 0;
			for(int j=input.length-1; j>=0; j--) {
				alpha[input[j] - 'A'] += (int)Math.pow(10,pos++);	
			}
		}
		Arrays.sort(alpha, Collections.reverseOrder());
		
		for(int i=0; i<10; i++) {
			ans += alpha[i] * (9-i);
		}
		
		System.out.println(ans);
	}
}
