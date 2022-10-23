import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_6087_레이저통신 {
	static int W, H,w,h;
	static int[][] map;
	static int ans = 0;
	static int cnt = 20;
	static boolean[][] visited;
	static boolean[][] visited2;
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
		visited = new boolean[H][W];
		visited2 = new boolean[H][W];

		int x = -1;
		int y = -1;
		for (int i = 0; i < H; i++) {
			String s = br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = s.charAt(j)-'0';
			
				if (map[i][j]==19) {
					x = i;
					y = j;
				}
			}
		}
		bfs(x,y);
		bfs2(w,h);
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(ans);
	}

	// C->C 까지 다시 몇번꺾였나
	private static void bfs2(int w, int h) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(w,h));
		visited2[w][h] = true;
		
		while(!queue.isEmpty()) {
			int dir = 0;
			Point p = queue.poll();
			for(int d=0; d<4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if(nx >= 0 && nx < H && ny >= 0 && ny < W && !visited2[nx][ny] && map[nx][ny]==cnt) {
					if(dir!=d) ans++;
					System.out.println("d:"+d +" dir: "+dir);
					dir = d;
					queue.offer(new Point(nx, ny));
					visited2[nx][ny] = true;
					// 방향이 바뀌면 = d가 바뀌면
					if(map[nx][ny]==19) {
						return;
					}
					cnt--;
				}
			}
		}
		
	}

	// C->C 까지 가는데 최단거리
	private static void bfs(int x, int y) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(x, y));
		visited[x][y] = true;
			while (!queue.isEmpty()) {
				int qSize = queue.size();
				for (int i = 0; i < qSize; i++) {
				Point p = queue.poll();

				
				
				for (int d = 0; d < 4; d++) {
					int nx = p.x + dx[d];
					int ny = p.y + dy[d];

					if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny]) {
						if(map[nx][ny]==-2) {
								
							visited[nx][ny] = true;
							queue.offer(new Point(nx, ny));
							map[nx][ny] = cnt;
						} else if (map[nx][ny]==19) {
							cnt = map[p.x][p.y];
							w = nx;
							h = ny;
							return;
						}
					}
				}
			}
				cnt++;
		}
	}
}
