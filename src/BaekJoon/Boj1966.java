package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Queue<Integer> queue = new LinkedList<>();
			Queue<Integer> index = new LinkedList<>();

			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				queue.offer(Integer.parseInt(st.nextToken()));
				index.offer(j);
			}

			int count = 0;
			while (!queue.isEmpty()) {
				int max = Collections.max(queue);
				int now = queue.poll();
				int nowIndex = index.poll();

				if (now == max) {
					if (nowIndex == M) {
						count++;
						System.out.println(count);
						break;
					}
					count++;
				} else {
					queue.offer(now);
					index.offer(nowIndex);
				}
			}
		}
	}
}
