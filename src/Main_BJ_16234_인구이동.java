import java.util.*;
import java.io.*;

public class Main_BJ_16234_인구이동 {
	static int N,L,R;
	static int[][] map;
	static int day = 0;
	static boolean[][] visited;
	static boolean flag = true;
	static ArrayList<Point> coor = new ArrayList<>();
	static ArrayList<Integer> people = new ArrayList<>();
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static class Point {
		int x,y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {	
			flag = false;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j]) {
						bfs(i,j);
					}
				}
			}
			if(!flag) break;
			day++;
			visited = new boolean[N][N];
		}
		
		System.out.println(day);
	}
	
	private static void bfs(int x, int y) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(x,y));
		visited[x][y] = true;
		people.add(map[x][y]);
		coor.add(new Point(x,y));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny] && Math.abs(map[p.x][p.y] - map[nx][ny]) >=L && Math.abs(map[p.x][p.y] - map[nx][ny])<=R) {
					queue.offer(new Point(nx,ny));
					flag = true;
					people.add(map[nx][ny]);
					coor.add(new Point(nx,ny));
					visited[nx][ny] = true;
				}
			}
		}
		
		int sum = 0;
		for(int i=0; i<people.size(); i++) {
			sum += people.get(i);
		}
		sum /= people.size();
		
		for(int i=0; i<coor.size(); i++) {
			map[coor.get(i).x][coor.get(i).y] = sum;
		}
		
		people.removeAll(people);
		coor.removeAll(coor);
	}
}
