import java.util.*;
import java.io.*;

public class Main_BJ_17142_연구소3 {
	static int N, M, ans, blank;
	static int[][] map;
	static int[][] copyMap;
	static boolean[] isSelected;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static ArrayList<Point> list = new ArrayList<>();

	static class Point {
		int x, y,time;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		Point(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;
		map = new int[N][N];
		copyMap = new int[N][N];
		blank = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int k = Integer.parseInt(st.nextToken());
				map[i][j] = k;
				copyMap[i][j] = k;
				if (map[i][j] == 0)
					blank++;
				if (map[i][j] == 2) {
					list.add(new Point(i, j));
				}
			}
		}
		if (blank == 0) {
			System.out.println(0);
			System.exit(0);
		}

		isSelected = new boolean[list.size()];

		dfs(0, 0);
		if(ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
			
	}

	private static void dfs(int cnt, int start) {
		if (cnt == M) {
			ans = Math.min(ans, bfs());
		}

		for (int i = start; i < list.size(); i++) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			dfs(cnt + 1, i + 1);
			isSelected[i] = false;
		}

	}

	private static int bfs() {
		int cnt = 0;
		int time = 0;
		Queue<Point> queue = new ArrayDeque<>();
		visited = new boolean[N][N];
		for (int i = 0; i < list.size(); i++) {
			if (isSelected[i]) {
				queue.offer(new Point(list.get(i).x, list.get(i).y,0));
			}
		}
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N || map[nx][ny]==1 || visited[nx][ny]) continue;
				
				if(map[nx][ny]==0)  {
					cnt++;
					time = p.time + 1;
				}
				
				visited[nx][ny] = true;
				queue.offer(new Point(nx,ny,p.time+1));
			}
		}
		if(cnt==blank) {
			return time;
		} else {
			return Integer.MAX_VALUE;
		}
	}

}