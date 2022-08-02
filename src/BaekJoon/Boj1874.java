package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj1874 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		int[] ans = new int[n];
		
		for(int i=0; i<n; i++) {
			ans[i] = Integer.parseInt(br.readLine());
		}
		
		
		// 스택 계산
		int m = 0;
		for(int a: ans) {
			if (a > m) {
 				while (a>m) {
					stack.push(++m);
					sb.append("+\n");
 				}
 				stack.pop();
 				sb.append("-\n");
			} else {
				if(stack.peek() != a) {
					System.out.println("NO");
					return;
				}
				stack.pop();
				sb.append("-\n");
			}
		}
		System.out.println(sb);
	}
}
