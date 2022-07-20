package alg;

import java.util.Scanner;

public class Boj9093 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<T; i++) {
			String sentence = sc.nextLine();
			String[] split = sentence.split(" ");
			StringBuffer sb = new StringBuffer();
			
			for(String s: split) {
				StringBuffer reverse = new StringBuffer(s);
				sb.append(reverse.reverse());
				sb.append(' ');
			}
			System.out.println(sb);
		}
		
	}
}
