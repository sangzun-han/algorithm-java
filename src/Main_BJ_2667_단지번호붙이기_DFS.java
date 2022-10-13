import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_BJ_2667_단지번호붙이기_DFS {
	static int N;
	static int count;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static ArrayList<Integer> list = new ArrayList<>();
	static class Point {
		int x,y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		
		int num = 1;
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]!=0 && !visited[i][j]) {
					count = 1;
					list.add(dfs(i,j,num));
					num++;
				}
			}
		}
		
		System.out.println(num-1);
		Collections.sort(list);
		for(Integer n: list) {
			System.out.println(n);
		}
	}
	
	
	private static int dfs(int x, int y, int num) {
		map[x][y] = num;
		visited[x][y] = true;
		for(int d=0; d<4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
				
			if(nx<0 || nx>=N || ny<0 || ny>=N || visited[nx][ny] || map[nx][ny]==0) continue;
			dfs(nx,ny,num);
			count++;
		}		
		return count;
	}
	
}