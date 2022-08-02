package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1543 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		int len = word.length();
		String search = br.readLine();
		word = word.replace(search, "");
		System.out.println(len - word.length()/search.length());
	}
}
