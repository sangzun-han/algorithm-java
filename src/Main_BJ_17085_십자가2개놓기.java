import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_17085_십자가2개놓기 {
	static int N, M;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		int ans = 0;
		// 격자판에 십자가를 놓는 방법 구하기
		// 십자가 1개 만들기 -> NM*min(N,M)
		// 십자가 2개 만들기 -> NM*min(N,M)^2
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for(int s=0;; s++) {
					if (i-s<0 || i+s>=N) break;
					if (j-s<0 || j+s>=M) break;
					if (map[i-s][j] != '#' || map[i+s][j] != '#') break;
					if (map[i][j-s] != '#' || map[i][j+s] != '#') break;
					map[i-s][j] = '*'; map[i+s][j] = '*';
					map[i][j-s] = '*'; map[i][j+s] = '*';
				
					for (int i2=0; i2< N; i2++) {
						for (int j2=0; j2<M; j2++) {
							for(int s2=0;; s2++) {
								if (i2-s2<0 || i2+s2>=N) break;
								if (j2-s2<0 || j2+s2>=M) break;
								if (map[i2-s2][j2] != '#' || map[i2+s2][j2] != '#') break;
								if (map[i2][j2-s2] != '#' || map[i2][j2+s2] != '#') break;		
								int area = (4*s+1) * (4*s2+1);
								ans = Math.max(ans, area);
							}
						}
					}
					
				}
				for(int s=0;; s++) {
					if (i-s<0 || i+s>=N) break;
					if (j-s<0 || j+s>=M) break;
					if (map[i-s][j] != '*' || map[i+s][j] != '*') break;
					if (map[i][j-s] != '*' || map[i][j+s] != '*') break;
					map[i-s][j] = '#'; map[i+s][j] = '#';
					map[i][j-s] = '#'; map[i][j+s] = '#';
				}
			}
		}
		System.out.println(ans);
	}
}