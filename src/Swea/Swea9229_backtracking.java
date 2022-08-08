package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea9229_backtracking {
	public static int cnt;
	public static int n;
	public static int m;
	public static int[] weight;
	public static int max;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int t = Integer.parseInt(br.readLine());
		for(int tc=0; tc<t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 과자 봉지 개수
			m = Integer.parseInt(st.nextToken()); // 무게 합 제한
			weight = new int[n];
			max = -1;
			st = new StringTokenizer(br.readLine());
			
			// 과자 무게 입력
			for(int i=0; i<n; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			} 
			backtracking(0,0,0);
			
			System.out.println("#" + (tc+1)+" "+max);
		}
	}

	private static void backtracking(int index, int cnt, int sum) {
		if (sum > m) return;
		if (index==n) return;
		if(cnt==2 && max<sum) {
			max = sum;
			return;
		}
		
		backtracking(index+1,cnt+1,sum+weight[index]);
		backtracking(index+1,cnt,sum);
		
		
		
	}
}
