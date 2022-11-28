import java.io.*;
import java.util.*;

public class Main_BJ_10819_차이를최대로 {
	static int N;
	static boolean[] visited;
	static int[] arr;
	static int[] nums;
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());		
		ans = Integer.MIN_VALUE;
		nums = new int[N];
		arr = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(0);
		System.out.println(ans);
	}

	private static void comb(int cnt) {
		if(cnt==N) {
			int sum = 0;
			for(int i=0; i<N-1; i++) {
				sum += Math.abs(arr[i]-arr[i+1]);
			}
			ans = Math.max(sum, ans);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			arr[cnt] = nums[i];
			comb(cnt+1);
			visited[i] = false;
		}
	}
}
