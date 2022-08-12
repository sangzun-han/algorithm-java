package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Boj1260 {
	static int N;
	static int M;
	static int V;
	static int[][] dfs_graph;
	static boolean[] dfs_visited;
	static int[][] bfs_graph;
	static boolean[] bfs_visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		dfs_graph = new int[1001][1001];
		dfs_visited = new boolean[1001];
		bfs_graph = new int[1001][1001];
		bfs_visited = new boolean[1001];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x =  Integer.parseInt(st.nextToken());
			int y =  Integer.parseInt(st.nextToken());
			dfs_graph[x][y] = dfs_graph[y][x] = 1;
			bfs_graph[x][y] = bfs_graph[y][x] = 1;
		}
		
		
		dfs(V);
		System.out.println();
		bfs(V);
	}

	private static void bfs(int v) {
		Queue<Integer> queue = new ArrayDeque<>();
		bfs_visited[v] = true;
		queue.offer(v);
		System.out.print(v+" ");
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			for(int i=1; i<=N; i++) {
				if(!bfs_visited[i] && bfs_graph[temp][i] == 1) {
					queue.offer(i);
					bfs_visited[i] = true;
					System.out.print(i+" ");
				}
				
			}
		}
	}

	private static void dfs(int v) {
		dfs_visited[v] = true;
		System.out.print(v+" ");
		for(int i=1; i<=N; i++) {
			if(!dfs_visited[i] && dfs_graph[v][i] == 1) {
				dfs(i);
			}
		}
		
	}
}
