package BaekJoon.Boj15662;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int M = 8;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int[][] map = new int[T][M];
		
		for(int i=0; i<T; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j) -'0';
			}
		}
		int ans = 0;
		int K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int gear = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			
			int d[] = new int[T];
			d[gear] = dir;
			
			for(int k=gear-1; k>=0; k--) {
				if(map[k+1][6] != map[k][2]) {
					d[k] = -d[k+1];
				} else break;
			}
			
			for(int k=gear+1; k<T; k++) {
				if(map[k-1][2] != map[k][6]) {
					d[k] = -d[k-1];
				}
			}
			
			for(int k=0; k<T; k++) {
				if(d[k] == 0) continue;
				if(d[k] == 1) {
					int temp = map[k][7];
					for(int l=7; l>=1; l--) {
						map[k][l] = map[k][l-1];
					}
					map[k][0] = temp;
				}
				if(d[k] == -1) {
					int temp = map[k][0];
					for(int l=0; l<7; l++) {
						map[k][l] = map[k][l+1];
					}
					map[k][7] = temp;
				}
			}
		}
		
		for(int i=0; i<T; i++) {
			if(map[i][0] == 1) {
				ans+=1;
			}
		}
		System.out.println(ans);
	}
}
