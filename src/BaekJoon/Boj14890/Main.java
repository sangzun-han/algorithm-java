package BaekJoon.Boj14890;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		
		int ans = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 행 검사
		for(int i=0; i<N; i++) {
			int[] d = new int[N];
			for(int j=0; j<N; j++) {
				d[j] = map[i][j];
			}
			if(check(d, L)) ans += 1;
		}
		// 열 검사
		for(int i=0; i<N; i++) {
			int[] d= new int[N];
			for(int j=0; j<N; j++) {
				d[j] = map[j][i];
			}
			if(check(d,L)) ans += 1;
		}
		
		System.out.println(ans);
	}

	private static boolean check(int[] d, int l) {
		int n = d.length;
		boolean[] c = new boolean[n];
		
		for(int i=1; i<n; i++) {
			// 높이의 차이가 1이 아니라면 경사로를 설치할수 없다.
			if(d[i-1] != d[i]) {		
				int diff = Math.abs(d[i] - d[i-1]);
				if (diff != 1) return false;
				
			if(d[i-1] < d[i]) { // 낮은곳에서 높은곳으로 경사로를 설치할 경우
				for(int j=1; j<=l; j++) {
					if(i-j < 0) return false; // 범위 벗어난거
					if(d[i-1] != d[i-j]) return false; // 낮은 지점의 높이가 같지않거나, L개가 연속되지 않았다.
					if(c[i-j]) return false; // 경사로에 경사로를 더 놓는 경우
					c[i-j] = true;
				}
			} else if (d[i-1] > d[i]) { // 높은곳에서 낮은곳으로경사로를 설치한다.
				for(int j=0; j<l; j++) {
					if(i+j >= n) return false; // 범위 벗어남
					if(d[i] != d[i+j]) return false;
					if(c[i+j]) return false;
					c[i+j] = true;
				} 
			}
			}
		}
		return true;
	}
}
