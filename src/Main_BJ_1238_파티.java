import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_1238_파티 {
	static int N,M,X;
	static class Node {
		int to, weight;
		
		Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		List<Node>[] adjList = new ArrayList[M+1];
		List<Node>[] reverseAdjList = new ArrayList[M+1];
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
			reverseAdjList[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			adjList[n].add(new Node(m, t));
			reverseAdjList[m].add(new Node(n,t));
		}
		
		int[] distance = dijkstra(adjList);
		int[] reverseDistance = dijkstra(reverseAdjList);
		
		int ans = Integer.MIN_VALUE;
		for(int i=1; i<=N; i++) {
			ans = Math.max(ans, distance[i]+reverseDistance[i]);
		}
		System.out.println(ans);
		
	}

	private static int[] dijkstra(List<Node>[] adjList) {
		
		boolean[] visited = new boolean[M+1];
		int[] d = new int[N+1];
		
		Arrays.fill(d, Integer.MAX_VALUE);
		d[X] = 0;
		
		int min,idx;
		for(int i=1; i<=N; i++) {
			min = Integer.MAX_VALUE;
			idx = -1;
			
			for(int j=1; j<=N; j++) {
				if(!visited[j] && min > d[j]) {
					min = d[j];
					idx = j;
				}
		
			}
		
			visited[idx] = true;
			
			for(Node n : adjList[idx]) {
				if(!visited[n.to] && n.weight !=0 && d[n.to] > d[idx] + n.weight) {
					d[n.to] = d[idx] + n.weight;
				}
			}
		}
		return d;
	}
}
