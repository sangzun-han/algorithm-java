package BaekJoon.Boj1753;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int to,weight;
		
		Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		List<Node>[] adjList = new ArrayList[V+1];
		
		// 인접리스트 초기화
		for(int i=1; i<=V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		int start = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<E; i++) {
			 st = new StringTokenizer(br.readLine());
			 int u = Integer.parseInt(st.nextToken());
			 int v = Integer.parseInt(st.nextToken());
			 int w = Integer.parseInt(st.nextToken());

			 adjList[u].add(new Node(v,w));
		}
		
		boolean[] visited = new boolean[V+1];
		int[] d = new int[V+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		d[start] = 0;
		int cnt = 0;
		for(int i=1; i<=V; i++) {
			int min = Integer.MAX_VALUE;
			int minV = -1;
			for(int j=1; j<=V; j++) {
				if(!visited[j] && min > d[j]) {
					
					min = d[j];
					minV = j;
				}
			}
			
			if(cnt++ == V) break;
			
			if(minV == -1) {
				for(int k=1; k<=V; k++) {
					if(d[k] == Integer.MAX_VALUE) System.out.println("INF");
					else System.out.println(d[k]);
				}
				System.exit(0);
			}
			
			visited[minV] = true;
			
			for(Node n : adjList[minV]) {
				if(!visited[n.to] && n.weight !=0 &&  d[n.to] > d[minV] + n.weight) {
					d[n.to] = d[minV] + n.weight;
				}
			}
		}
		
		for(int i=1; i<=V; i++) {
			if(d[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(d[i]);
		}
		
	}
}




