package Swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_7465_창용마을무리의개수_한상준 {
	static int[] set;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			Set<Integer> s = new HashSet<>();
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			set = new int[N+1];
			for(int i=1; i<=N; i++) {
				set[i] = i;
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a,b);
			}
			
			for(int i=1; i<=N; i++) {			
				s.add(find(i));
			}
			
			sb.append("#").append(tc).append(" ").append(s.size()).append("\n");
		}
		System.out.println(sb);
	}
	
	private static int find(int x) {
		if(set[x] == x) return x;
		return set[x] = find(set[x]);
	}
	
	private static boolean union(int x, int y) {
		if(find(x) == find(y)) return false;
		else {
			set[find(y)] = find(x); 
			return true;
		}
			
		}
		
	}
	

	
