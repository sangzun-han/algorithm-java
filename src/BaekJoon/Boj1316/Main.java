package BaekJoon.Boj1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = n;
		for(int i=0; i<n; i++) {
			String word = br.readLine();
			for(int j=1; j<word.length(); j++) {
				System.out.println(word.indexOf(word.charAt(j-1)));
				System.out.println(word.indexOf(word.charAt(j)));
				if(word.indexOf(word.charAt(j-1)) > word.indexOf(word.charAt(j))) {
					ans--;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}
