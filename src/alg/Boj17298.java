package alg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj17298 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());

		int[] ans = new int[n];

		

		int[] numbers = new int[n];

		Stack<Integer> stack = new Stack<>();
		stack.add(0);

		st = new StringTokenizer(br.readLine());

		for (int i = 0; st.hasMoreTokens(); i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < n; i++) {
			if (stack.isEmpty()) {
				stack.push(i);
			}
			while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
				ans[stack.peek()] = numbers[i];
				stack.pop();
			}
			stack.push(i);
		}
		
		while (!stack.isEmpty()) {
			ans[stack.peek()] = -1;
			stack.pop();
		}


		for(int a : ans) {
			sb.append(a).append(" ");
		}
		System.out.println(sb);
	}

}