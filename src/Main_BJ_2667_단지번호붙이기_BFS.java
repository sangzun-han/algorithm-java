import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class Main_BJ_2667_단지번호붙이기_BFS {
	static int N;
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
					bfs(i,j,num);
					num++;
				}
			}
		}
		
		
		
		System.out.println(num-1);
		Collections.sort(list);
		for(Integer n : list) {
			System.out.println(n);
		}
	}
	
	private static void bfs(int x, int y,int num) {
		int count = 1;
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(x, y));
		map[x][y] = num;
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N || visited[nx][ny] || map[nx][ny]==0) continue;
				
				queue.offer(new Point(nx,ny));
				visited[nx][ny] = true;
				map[nx][ny] = num;
				count++;
			}
		}
		list.add(count);
	}
}
