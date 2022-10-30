import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2206_벽부수고이동하기 {
	static int N,M;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] map;
	static int[][][] visited;
	
	static class Point {
		int x,y,z;
		Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M][2];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		bfs(0,0,0);
	}
	
	private static void bfs(int x, int y, int z) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(x,y,z));
		visited[x][y][z] = 1;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
				
				if(map[nx][ny]==0 && visited[nx][ny][p.z]==0) {
					visited[nx][ny][p.z] = visited[p.x][p.y][p.z] + 1;
					queue.offer(new Point(nx,ny,p.z));
				}
				
				if(p.z==0 && map[nx][ny]==1 && visited[nx][ny][p.z+1]==0) {
					visited[nx][ny][p.z+1] = visited[p.x][p.y][p.z] + 1;
					queue.offer(new Point(nx,ny,p.z+1));
				}
			}
		}
		
		if(visited[N-1][M-1][0] !=0 && visited[N-1][M-1][1] !=0) {
			System.out.println(Math.min(visited[N-1][M-1][0] , visited[N-1][M-1][1] ));
		} else if (visited[N-1][M-1][0] != 0) {
			System.out.println(visited[N-1][M-1][0]);
		} else if(visited[N-1][M-1][1] != 0) {
			System.out.println(visited[N-1][M-1][1]);
		} else {
			System.out.println(-1);
		}
	}
}
