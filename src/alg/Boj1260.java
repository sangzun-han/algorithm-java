package alg;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Boj1260 {
	static int n;
	static int m;
	static int v;
	static int[][] dfs_graph;
	static boolean[] dfs_visited;
	static int[][] bfs_graph;
	static boolean[] bfs_visited;
	
	public static void dfs(int v) {
		dfs_visited[v] = true;
		System.out.print(v + " ");
		for(int i=1; i<=n; i++) {
			if (dfs_visited[i] == false && dfs_graph[v][i] == 1) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(v);
		bfs_visited[v] = true;
		System.out.print(v+ " ");
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();		
			for(int i=1; i<=n; i++) {
				if(bfs_visited[i] == false && bfs_graph[temp][i] == 1) {
					queue.offer(i);
					bfs_visited[i] = true;
					System.out.print(i + " ");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		dfs_graph = new int[1001][1001];
		dfs_visited = new boolean[1001];
		bfs_graph = new int[1001][1001];
		bfs_visited = new boolean[1001];
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			dfs_graph[a][b] = 1;
			dfs_graph[b][a] = 1;
			bfs_graph[a][b] = 1;
			bfs_graph[b][a] = 1;
		}
		dfs(v);
		System.out.println();
		bfs(v);
		sc.close();
	}
}
