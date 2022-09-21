import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_1916_최소비용구하기 {
	static class Node {
		int to,weight;
		
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		List<Node>[] adjList = new ArrayList[N+1];
		boolean[] visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adjList[start].add(new Node(end, cost));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int[] d = new int[N+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		
		d[start] = 0;
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
			if(idx != -1) {
				visited[idx] = true;				
				for(Node n : adjList[idx]) {
					if(!visited[n.to] && n.weight >= 0 && d[n.to] > d[idx] + n.weight) {
						d[n.to] = d[idx] + n.weight;
					}
				}
			}
			
		}
		System.out.println(d[end]);
	}
}