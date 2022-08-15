package BaekJoon.Boj6198;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		int[] height = new int[n];
		long ans = 0;
		for(int i=0; i<n; i++) {
			height[i] = Integer.parseInt(br.readLine());
			
			while(!stack.isEmpty() && stack.peek() <= height[i]) {
				stack.pop();
			}
			stack.push(height[i]);
			ans += stack.size()-1;
		}
		System.out.println(ans);
	}
}
