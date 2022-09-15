import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14719_빗물 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] road = new int[W];
		int ans = 0;
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<W; i++) {
			road[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<W-1; i++) {
			int left = road[i];
			
			for(int j=0; j<i; j++) {
				left = Math.max(left, road[j]);
			}
			
			int right = road[i];
			for(int j=i+1; j<W; j++) {
				right = Math.max(right, road[j]);
			}
			 ans += Math.min(left,right) - road[i];
		}
		
		System.out.println(ans);
	}
}
