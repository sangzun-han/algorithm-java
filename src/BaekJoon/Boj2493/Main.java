package BaekJoon.Boj2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Top {
	int index;
	int height;

	Top(int index, int height) {
		this.index = index;
		this.height = height;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		Stack<Top> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {

			int height = Integer.parseInt(st.nextToken());
			
			if (stack.isEmpty()) {
				sb.append(0+" ");
				stack.push(new Top(i, height));
			} else {
				while (true) {
					if (stack.isEmpty()) {
						sb.append(0+" ");
						stack.push(new Top(i, height));
						break;

					}
					Top top = stack.peek();

					if (top.height > height) {
						sb.append(top.index+" ");
						stack.push(new Top(i, height));
						break;
					} else {
						stack.pop();
					}
				}
			}
			
		}
		System.out.println(sb);
	}
}
