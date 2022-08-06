package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 * 1. 가장 적은 카드 수를 합치는 과정 -> 틀림 반례) 5 6 7 8
 * 2. 가장 적은 카드 2개를 더한다 -> 합을 큐에 다시 넣기 (반복)
 */
public class Boj1715 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int ans = 0;
		for (int i = 0; i < N; i++) {
			queue.add(Integer.parseInt(br.readLine()));
		}

		while(!(queue.size()==1)) {
			int temp = 0;
			temp += queue.poll();
			temp += queue.poll();
			ans += temp;
			queue.offer(temp);
			
		}

		
		System.out.println(ans);
	}
}
