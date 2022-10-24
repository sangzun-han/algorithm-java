import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_6087_레이저통신 {
	static int W, H;
	static int[][] map;
	static int[][] dir;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		dir = new int[H][W];

		List<Integer> startX = new ArrayList<>();
		List<Integer> startY = new ArrayList<>();
		
		for (int i = 0; i < H; i++) {
			String s = br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = s.charAt(j);
				dir[i][j] = -1;
				if (map[i][j]=='C') {
					startX.add(i);
					startY.add(j);
				} 
			}
		}
		bfs(startX.get(0),startY.get(0));
		System.out.println(dir[startX.get(1)][startY.get(1)]);
	}

	private static void bfs(int x, int y) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(x,y));
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				while(nx>=0 && nx<H && ny>=0 && ny<W) {
					if(map[nx][ny]=='*') break;
					if(dir[nx][ny]==-1) {
						dir[nx][ny] = dir[p.x][p.y] + 1;
						queue.offer(new Point(nx,ny));
					}
					nx += dx[d];
					ny += dy[d];
				}
			}
		}
		
	}

}