package BaekJoon.Boj14499;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0,0,0,-1,1};
	static int[] dy = {0,1,-1,0,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 세로
		int M = Integer.parseInt(st.nextToken()); // 가로
		int x = Integer.parseInt(st.nextToken()); // 주사위 놓은 곳 x좌표
		int y = Integer.parseInt(st.nextToken()); // 주사위 놓은 곳 y좌표
		int K = Integer.parseInt(st.nextToken()); // 명령의 개수
		int[][] map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dice = new int[7];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			int d = Integer.parseInt(st.nextToken());
			int nx =  x + dx[d];
			int ny =  y + dy[d];
			
			// 지도 밖으로 나갔을 때는 다음 반복으로
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			
			// d==1 일경우 동쪽
			if(d==1) {
				int temp = dice[1];
				dice[1] = dice[4];
				dice[4] = dice[6];
				dice[6] = dice[3];
				dice[3] = temp;
			} else if(d==2) {
				int temp = dice[1];
				dice[1] = dice[3];
				dice[3] = dice[6]; 
				dice[6] = dice[4];
				dice[4] = temp;
			} else if(d==3) {
				int temp = dice[1];
				dice[1] = dice[5];
				dice[5] = dice[6];
				dice[6] = dice[2];
				dice[2] = temp;
			} else if(d==4) {
				int temp = dice[1];
				dice[1] = dice[2]; 
				dice[2] = dice[6];
				dice[6] = dice[5];
				dice[5] = temp;
			}
			x = nx;
			y = ny;
			
			if(map[x][y] == 0) {
				map[x][y] = dice[6];
			} else {
				dice[6] = map[x][y];
				map[x][y] = 0;
			}
			System.out.println(dice[1]);
		}
	}
}
