package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	int time;
	String pos;

	Pos(int time, String pos) {
		this.time = time;
		this.pos = pos;
	}

}

public class Boj2065 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken()); // 태울 수 있는 수
		int t = Integer.parseInt(st.nextToken()); // 나룻배 이동하는데 시간
		int N = Integer.parseInt(st.nextToken()); // 입력개수
		boolean flag = true;

		Queue<Pos> left = new LinkedList<>();
		Queue<Pos> right = new LinkedList<>();
		Queue<Integer> ansRight = new LinkedList<>();
		Queue<Integer> ansLeft = new LinkedList<>();
		Queue<String> dir = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			String pos = st.nextToken();
			if (pos.equals("left")) {
				left.offer(new Pos(time, pos));
				dir.offer(pos);
			}
			else {
				right.offer(new Pos(time, pos));
				dir.offer(pos);
			}
		}

		int time = 0;
		while (!(left.isEmpty() && right.isEmpty())) {
			if (flag) {

				if (left.isEmpty() || !(right.isEmpty()) && right.peek().time < left.peek().time && left.peek().time > time) {
					int currentLoad = 0;
					int curTime = right.peek().time;
					time = Math.max(time, curTime);
					time += t;

					while (!(right.isEmpty()) && right.peek().time <= time && currentLoad < N) {
						currentLoad++;
						right.poll();
					}
					time += t;

					while (currentLoad-- > 0) {
						ansRight.offer(time);
					}
					continue;
				}

				int currentLoad = 0;
				int curTime = left.peek().time;
				time = Math.max(time, curTime);
				while (!(left.isEmpty()) && left.peek().time <= time && currentLoad < M) {
					currentLoad++;
					left.poll();
				}

				time += t;
				flag = false;
				while (currentLoad-- > 0) {
					ansLeft.offer(time);
				}
			} else {
				if (right.isEmpty()
						|| !(left.isEmpty()) && left.peek().time < right.peek().time && right.peek().time > time) {
					int currentLoad = 0;
					int curTime = left.peek().time;
					time = Math.max(time, curTime);
					time += t;

					while (!left.isEmpty() && left.peek().time <= time && currentLoad < M) {
						currentLoad++;
						left.poll();
					}
					time += t;
					flag = false;
					while (currentLoad-- > 0) {
						ansLeft.offer(time);
					}
					continue;
				}
				int currentLoad = 0;
				int curTime = right.peek().time;
				time = Math.max(time, curTime);
				while (!(right.isEmpty()) && right.peek().time <= time && currentLoad < M) {
					currentLoad++;
					right.poll();
				}
				time += t;
				flag = true;
				while (currentLoad-- > 0) {
					ansRight.offer(time);
				}
				
				
			}
		}
		while(!dir.isEmpty()) {
			if(dir.poll().equals("left")) {
				System.out.println(ansLeft.poll());
			} else {
				System.out.println(ansRight.poll());
			}
		}
		
	}
}
