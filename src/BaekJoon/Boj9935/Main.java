package BaekJoon.Boj9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		Stack<Character> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		String bomb = br.readLine();
		int bombLength = bomb.length();

		for (int i = 0; i < word.length(); i++) {
			stack.push(word.charAt(i));
			if (stack.size() >= bombLength) {
				boolean flag = true;

				for (int j = 0; j < bomb.length(); j++) {
					if (stack.get(stack.size() - bombLength + j) != bomb.charAt(j)) {
						flag = false;
						break;
					}
				}

				if (flag) {
					for (int j = 0; j < bombLength; j++) {
						stack.pop();
					}
				}
			}
		}
		if (stack.isEmpty()) {
			System.out.println("FRULA");
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		for(Character c: stack) {
			sb.append(c);
		}
		System.out.println(sb);
		
	}
}
