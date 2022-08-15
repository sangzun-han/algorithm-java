package BaekJoon.Boj16926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		int rect_cnt = Math.min(n, m)/2;
		int r = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<r; i++)  { // 배열 회전 수
			for(int j=0; j<rect_cnt; j++) { // 사각형의 수만큼 반복
				int x = j;
				int y = j;
				int value = map[x][y];
				int index = 0;
				while (index < 4) {
					int nx = x + dx[index];
					int ny = y + dy[index];
					if(nx>=j && ny>=j && nx<n-j && ny<m-j) {
						map[x][y] = map[nx][ny];
						x = nx;
						y = ny;
					} else {
						index++;
					}
				}
				map[x+1][y] = value;
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
