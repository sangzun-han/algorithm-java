package BaekJoon.Boj2644;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, x, y, m;
	static int[][] graph = new int[101][101];
	static boolean[] visited = new boolean[101];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a][b] = graph[b][a] = 1;
		}

		System.out.println(bfs(x, y));
	}

	private static int bfs(int x, int y) {
		int cnt = 0;
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(x);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0; i<size; i++) {
				int temp = queue.poll();
				visited[temp] = true;
				if(temp==y) return cnt;
				for(int j=1; j<=n; j++) {
					if(graph[temp][j]==1 && !visited[j]) {
						queue.offer(j);
					}
				}
			}
			cnt++;
		}
		return -1;
	}
}
