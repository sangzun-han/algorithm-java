import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_17615_볼모으기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] balls = br.readLine().toCharArray();
		int red = 0;
		int blue = 0;
		
		for(int i=0; i<N; i++) {
			if(balls[i]=='R') red++;
			else blue++;
		}
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(balls[0] == balls[i]) cnt++;
			else break;
		}
		
		int cnt2 = 0;
		for(int i=N-1; i>=0; i--) {
			if(balls[N-1]==balls[i]) cnt2++;
			else break;
		}
		// RRRRRBRRR의 경우 B를 옮기는것이 더 최소횟수
		int ans = Math.min(red, blue);
		
		if(balls[0]=='R') {
			ans = Math.min(ans, red-cnt);
		} else {
			ans = Math.min(ans, blue-cnt);
		}
		
		if(balls[N-1]=='R') {
			ans = Math.min(ans, red-cnt2);
		} else {
			ans = Math.min(ans, blue-cnt2);
		}
		
		System.out.println(ans);
	}
}
