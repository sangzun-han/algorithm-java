import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1149_RGB거리 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] rgb = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			rgb[i][0] = Integer.parseInt(st.nextToken());
			rgb[i][1] = Integer.parseInt(st.nextToken());
			rgb[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<N; i++) {
			rgb[i][0] += Math.min(rgb[i-1][1], rgb[i-1][2]);
			rgb[i][1] += Math.min(rgb[i-1][0], rgb[i-1][2]);
			rgb[i][2] += Math.min(rgb[i-1][0], rgb[i-1][1]);
		}

		int ans = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			if(ans > rgb[N-1][i]) ans = rgb[N-1][i];
		}
		System.out.println(ans);
	}
}
