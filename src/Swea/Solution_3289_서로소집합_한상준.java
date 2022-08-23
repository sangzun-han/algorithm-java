package Swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합_한상준 {
	static int n,m;
	static int[] set;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			set = new int[n+1];
			makeSet(n);
			sb.append("#").append(tc).append(" ");
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int type = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				// union
				if(type==0) union(a,b);
				// find
				if(type==1) {
					if(find(a) == find(b)) sb.append(1);
					else sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void makeSet(int n) {
		for(int i=1; i<=n; i++) {
			set[i] = i;
		}
	}
	
	private static int find(int x) {
		if (set[x]==x) return x;
		else return set[x] = find(set[x]);
	}
	
	private static boolean union(int x,int y) {
		if(find(x) ==find(y)) return false;
		else {
			set[find(y)] = find(x); 
			return true;
		}
	}
}
