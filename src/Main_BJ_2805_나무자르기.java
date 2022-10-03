import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2805_나무자르기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] trees = new int[N];
		
		st = new StringTokenizer(br.readLine());
		long max = 0;
		long min = 0;
		for(int i=0; i<N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(trees[i], max);
		}
		
		while(min <= max) {
			long sum = 0;
			long mid = (max + min) / 2;
			
			for(int t : trees) {
				if(t - mid > 0) 
					sum += t-mid;
			}
			
			if(sum >= M) {
				min = mid+1;
			} else {
				max = mid-1;
			}
		}
		System.out.println(max);
	}
}
