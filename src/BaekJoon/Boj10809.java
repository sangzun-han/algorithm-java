package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class Boj10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] loc = new int[26];
		for(int i=0; i<loc.length; i++) {
			loc[i] = -1;
		}
		
		String word = sc.nextLine();
		for(int i=0; i<word.length(); i++) {
			char ch = word.charAt(i);
			if(loc[ch-'a']==-1) loc[ch-'a'] = i;
		}
		
		for(int value: loc) System.out.print(value+" ");
	}
}
