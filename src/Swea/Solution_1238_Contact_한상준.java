package Swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_Contact_한상준 {
	static int size = 100;
	static boolean[] visited;
	static int[][] graph;
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int tc=1; tc<=10; tc++) {
			st = new StringTokenizer(br.readLine());
			graph = new int[size+1][size+1];
			visited = new boolean [size+1];
			
			Queue<Integer> queue = new ArrayDeque<>();
			int l = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<l/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from][to] = 1;
			}
			bfs(start);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		}
		System.out.print(sb);
	}
	private static void bfs(int x) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(x);
		visited[x] = true;
		int max = 0;
		
		while(!queue.isEmpty()) {
			int qsize = queue.size();
			max = 0;
			
			// 같은 레벨대에서 찾기 
			for(int i=0; i<qsize; i++) {
				int temp = queue.poll();
				max = max < temp ? temp : max;
				
				for(int j=1; j<=100; j++) {
					if(graph[temp][j]==1 && !visited[j]) {
						visited[j] = true;
						queue.offer(j);
					}
				}
			}
			ans = max;
		}
	
		
	}
}
