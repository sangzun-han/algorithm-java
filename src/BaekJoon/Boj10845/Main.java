package BaekJoon.Boj10845;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		List<Integer> queue = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if (cmd.equals("front")) {
				if(queue.size() > 0) System.out.println(queue.get(0));
				else System.out.println(-1);
			} else if (cmd.equals("back")) {
				if(queue.size() > 0) System.out.println(queue.get(queue.size()-1));	
				else System.out.println(-1);
			} else if (cmd.equals("empty")) {
				if (queue.size() < 1) System.out.println(1);
				else System.out.println(0);
			} else if (cmd.equals("size")) {
				System.out.println(queue.size());
			} else if (cmd.equals("pop")) {
				if(queue.size()<=0) System.out.println(-1);
				else System.out.println(queue.remove(0));
			} else if(cmd.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				queue.add(num);
				
			}
		}
	}
}
