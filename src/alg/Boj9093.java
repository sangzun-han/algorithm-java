package alg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj9093 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			Stack<Character> stack = new Stack<>();
			String sentence = br.readLine() + " ";
			StringBuilder result = new StringBuilder();
			for(int i=0; i<sentence.length(); i++) {
				if(sentence.charAt(i) == ' ') {
					while(!stack.isEmpty()) {
						result.append(stack.pop());
					}
					result.append(sentence.charAt(i));
				} else {					
					stack.push(sentence.charAt(i));
				}
			}
			
			System.out.print(result.toString());
			
			
		}
		
	}
}
