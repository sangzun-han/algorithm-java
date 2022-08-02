package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2941 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		String[] change = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		for(int i=0; i<change.length; i++) {
			if(word.contains(change[i])) {
				word = word.replace(change[i], "q");
			}
				
		}
		System.out.println(word);
		
	}
}
