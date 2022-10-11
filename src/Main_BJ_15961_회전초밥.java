import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_15961_회전초밥 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 접시의 수
		int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		int[] belt = new int[n];
		int[] check = new int[d+1];
		
		for(int i=0; i<n; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		int eatSushi = 0;
		int ans = 0;
		
		// k개 먹음
		for(int i=0; i<k; i++) {
			if(check[belt[i]]==0) {
				eatSushi++;
			}
			check[belt[i]]++;
		}
		
		ans = eatSushi;
		
		
		// 왼쪽 하나제거 오른쪽 추가
		for(int i=1; i<n; i++) {
			
			// 왼쪽 제거
			int left = belt[i-1];
			check[left]--;
			if(check[left]==0) eatSushi--;
			
			// 오른쪽 추가
			int right = (i+k-1)%n;
			if(check[belt[right]]==0) eatSushi++;
			check[belt[right]]++;
			
			// 먹은게 많아지거나 같을때 쿠폰확인
			if(ans<=eatSushi) {
				if(check[c]==0) ans = eatSushi+1;
				else ans = eatSushi;
			}
		}
		
		System.out.println(ans);
	}
}