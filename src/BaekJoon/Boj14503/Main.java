package BaekJoon.Boj14503;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 상 우 하 좌
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		int N = Integer.parseInt(st.nextToken()); // 세로
		int M = Integer.parseInt(st.nextToken()); // 가로
		int[][] map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken()); // 로봇 위치
		int c = Integer.parseInt(st.nextToken()); // 로봇 위치
		int d = Integer.parseInt(st.nextToken()); // 방향 (0~3)
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 청소했다면 2, 청소하지 않았으면 0, 벽 1
		while(true) {

			// 현재 위치 청소 한다.
			if(map[r][c] == 0) map[r][c] = 2;
			// 네 방향 모두 청소가 되어있다. 또는 벽일 경우
			if(map[r+1][c] != 0 && map[r-1][c] != 0 &&  map[r][c-1] != 0 && map[r][c+1] != 0) {
				// 뒤쪽 방향이 벽이라 후진할 수 없을 경우 작동 멈춤
				if(map[r-dx[d]][c-dy[d]] == 1) {
					break;
				} else {
					// 바라보는 방향 유지한채로 한칸 후진한다.
					r -= dx[d];
					c -= dy[d];
				}
			} else {
				// 왼쫀 방향에 아직 청소하지 않은 공간이 있다. 그 방향(왼쪽)회전한다음 한칸 전진
				// 왼쪽에 청소할 공간이 없다 -> 그 방향으로 회전하고 2번으로
				d = (d+3)%4; // 왼쪽방향
				if(map[r+dx[d]][c+dy[d]] == 0) {
					r += dx[d];
					c += dy[d];
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 2) ans++;
			}
		}
		System.out.println(ans);
	}
	
}
