import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2979_트럭주차 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] cnt = new int[101];
		int ans = 0;
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for(int j=a; j<b; j++) {
				cnt[j]++;
			}
		}
		
		for(int i=1; i<=100; i++) {
			if(cnt[i]==0) continue;
			else if (cnt[i]==1) {
				ans += A*cnt[i];
			} else if (cnt[i]==2) {
				ans += B*cnt[i];
			} else if (cnt[i]==3) {
				ans += C*cnt[i];
			}
		}
	
		System.out.println(ans);
		
	}
}