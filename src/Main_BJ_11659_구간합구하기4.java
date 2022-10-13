import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_11659_구간합구하기4 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] nums = new int[N+1];
		int[] d = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// dp배열
		for(int i=1; i<=N; i++) {
			d[i] = d[i-1]+nums[i];
		}
		

		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int I = Integer.parseInt(st.nextToken());
			int J = Integer.parseInt(st.nextToken());
			sb.append(d[J] - d[I-1]).append("\n");
		}
		
		System.out.println(sb);
	}
}
