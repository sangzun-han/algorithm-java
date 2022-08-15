package BaekJoon.Boj17406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[][] map;
	static int[][] copy;
	static List<int[]> list = new ArrayList<>();
	static int min;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // 회전 회수

		map = new int[N][M];
		copy = new int[N][M]; // 배열 복사본

		// 배열 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// r,c,s 입력
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			list.add(new int[] { r, c, s });
		}

		min = Integer.MAX_VALUE;

		// 순열을 통해 모든 조합알아냄 -> 알아낸 조합으로 회전
		perm(0, new int[K], new boolean[K]);
		System.out.println(min);

	}

	private static void perm(int cnt, int[] isSelected, boolean[] visited) {
		if(cnt==K) {
			init(); // 원래 배열 초기화
			for(int i=0; i<K; i++) {
				int index = isSelected[i];
				rotate(list.get(index));
			}
			
			for(int i=0; i<N; i++) {
				int sum = 0;
				for(int j=0; j<M; j++) {
					sum += map[i][j];
				}
				min = Math.min(min,sum);
			}
			return;	
		}
	
	for(int i=0; i<K; i++) {
		if(!visited[i]) {
			visited[i] = true;
			isSelected[cnt] = i;
			perm(cnt+1, isSelected, visited);
			visited[i] = false;
		}
	}
	}

	private static void rotate(int[] rotateInfo) {
		int r = rotateInfo[0];
		int c = rotateInfo[1];
		int s = rotateInfo[2];
		int x1 = r-s;
		int y1 = c-s;
		int x2 = r+s;
		int y2 = c+s;
		
		for(int k=0; k<s; k++) {
			int x = x1 + k;
			int y = y1 + k;
			int d = 0;
			int value = copy[x][y];
			while (d<4) {
				int nx = x + dx[d];
				int ny = y = dy[d];
				
				if(nx >=x1+k && ny >= x1+k && nx <= x2-k && ny <= y2-k) {
					copy[x][y] = copy[nx][ny];
					x = nx;
					y = ny;
				}
				d++;
			}
			copy[x][y+1] = value;
		}
	}

	private static void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}

}