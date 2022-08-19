package BaekJoon.Boj14891;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N = 4;
	static int M = 8;
	public static void main(String[] args) throws Exception{
		int[][] map = new int[N][M];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		int K = Integer.parseInt(br.readLine()); // K번 회전
		int ans = 0;
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int gear = Integer.parseInt(st.nextToken())-1; // 톱니바퀴 번호
			int dir = Integer.parseInt(st.nextToken()); // 회전 방향
			
			// 톱니바퀴는 동시에 회전을 해야한다.
			// 따라서 각 톱니바퀴가 어떤 방향으로 회전하는지 구한다.
			
			int[] d = new int[N]; // 톱니바퀴의 회전 정보 
			d[gear] = dir; // 현재 선택된 톱니바퀴의 회전방향을 배열에 저장
			
			// 현재 선택된 톱니바퀴의 왼쪽에 위치한 모든 톱니바퀴의 회전 정보를 조사
			for(int k=gear-1; k>=0; k--) {
				if(map[k][2] != map[k+1][6]) {
					d[k] = -d[k+1];
				} else break;
			}
			
			// 현재 선택된 톱니바퀴의 오른쪽에 위치한 모든 톱니바퀴의 회전 정보를 조사
			for(int k=gear+1; k<N; k++) {
				if(map[k][6] != map[k-1][2]) {
					d[k] = -d[k-1];
				} else break;
			}
			
			for(int k=0; k<N; k++) {
				if(d[k] == 0) continue;
				
				// 시계방향 회전
				if(d[k] == 1) {
					int temp  = map[k][7];
					for(int l=7; l>=1; l--) {
						map[k][l] = map[k][l-1];
					}
					map[k][0] = temp;
				} 
				// 반시계 방향 회전
				else if (d[k] == -1) {
					int temp = map[k][0];
					for(int l=0; l<7; l++) {
						map[k][l] = map[k][l+1];
					}
					map[k][7] = temp;
				}
			}
		}
		

		if(map[0][0]==1) ans +=1;
		if(map[1][0]==1) ans +=2;
		if(map[2][0]==1) ans +=4;
		if(map[3][0]==1) ans +=8;
		
		System.out.println(ans);
	}
}
