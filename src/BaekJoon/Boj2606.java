package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2606 {
	static boolean[] virus;
	static int[][] map;
	static int N;
	static int cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		virus = new boolean[N+1];
		cnt = 0;
		int pair = Integer.parseInt(br.readLine());
		for(int i=0; i<pair; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = 1;
		}
		
		bfs(1);
		System.out.println(cnt);
	}

	private static void bfs(int num) {
		Queue<Integer> queue = new ArrayDeque<>();
		virus[num] = true;
		queue.offer(num);
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			for(int i=1; i<=N; i++) {
				if (map[temp][i]==1 && !virus[i]) {
					virus[i] = true;
					queue.offer(i);
					cnt++;
				}

			}
		}
	}
}
