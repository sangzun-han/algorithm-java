package BaekJoon.Boj1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String words = br.readLine();
		int n = Integer.parseInt(br.readLine());
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		
		for (int i = 0; i < words.length(); i++) {
			left.push(words.charAt(i));
		}

		

		for (int i = 0; i < n; i++) {
			String[] command = br.readLine().split(" ");
			if (command[0].equals("L")) {
				if(!left.isEmpty()) right.push(left.pop());
			} else if (command[0].equals("D")) {
				if(!right.isEmpty()) left.push(right.pop());
			} else if (command[0].equals("B")) {
				if(!left.isEmpty()) left.pop();
			} else if (command[0].equals("P")) {
				left.push(command[1].charAt(0));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		while (!left.isEmpty()) {
			right.push(left.pop());
		}

		while (!right.isEmpty()) {
			sb.append(right.pop());
		}
		System.out.println(sb);
		
	}
}
