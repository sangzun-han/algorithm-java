package Swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_헌터_한상준 {
	static class Node {
		int x,y,n;
		
		Node(int x, int y, int n) {
			this.x = x;
			this.y = y;
			this.n = n;
		}
	}
	
	static int N;
	static ArrayList<Node> monsters;
	static ArrayList<Node> customers;
	
	static boolean[] visitedMonsters;
	static boolean[] visitedCustomers;

	static int ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N =Integer.parseInt(br.readLine());
			int[][] map = new int[N+1][N+1];
			monsters = new ArrayList<>();
			customers = new ArrayList<>();
			ans = Integer.MAX_VALUE;
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] > 0) monsters.add(new Node(i,j,map[i][j]));
					if(map[i][j] < 0) customers.add(new Node(i,j,map[i][j]));
				}
			}
			
			visitedMonsters = new boolean[monsters.size()+1];
			visitedCustomers = new boolean[customers.size()+1];
			dfs(0, 0, 1, 1);
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	private static void dfs(int cnt, int distance, int x, int y) {
		if(cnt == monsters.size() + customers.size()) {
			ans = Math.min(ans, distance);
		}
		
		// 1. 몬스터 잡기
		
		for(Node monster: monsters) {
			if(visitedMonsters[monster.n]) continue;
			
			int d= getDistance(monster.x, monster.y, x, y);
			visitedMonsters[monster.n] = true;
			dfs(cnt+1, distance+d, monster.x, monster.y);
			visitedMonsters[monster.n] = false;
		}
		
		// 2. 고객 방문
		for(Node customer: customers) {
			int n = Math.abs(customer.n);
	
			if(visitedCustomers[n] || !visitedMonsters[n]) continue;
			int d = getDistance(customer.x, customer.y, x, y);
			visitedCustomers[n] = true;
			dfs(cnt+1, distance+d, customer.x, customer.y);
			visitedCustomers[n] = false;
		}
	}
	
	private static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}
}
