

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_11404_플로이드 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] map = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i!=j && map[i][j]==0) map[i][j] = 10000001;
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a][b] = Math.min(c, map[a][b]);
		}
		
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				if(k==i) continue;
				for(int j=1; j<=n; j++) {
					if(i==j || k==j) continue;
					if(map[i][j] > map[i][k]+map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n ;j++) {
				if(map[i][j] == 10000001) {
					map[i][j] = 0;
				}
			}		
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
