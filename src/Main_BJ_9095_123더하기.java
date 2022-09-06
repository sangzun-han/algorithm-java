import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_9095_123더하기 {
	static int n;
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] d= new int[11];
		d[0] = 1;
		d[1] = 1;
		d[2] = 2;
		
		for(int tc=0; tc<T; tc++) {
			n = Integer.parseInt(br.readLine());

			for(int i=3; i <= n;i ++) {
				d[i] = d[i-3] + d[i-2] + d[i-1];
			}
			System.out.println(d[n]);
		}
	}
}
	
	/*
	 * 순열
	 * 	for(int i=0; i<T; i++) {
			n = Integer.parseInt(br.readLine());
			ans = 0;
			perm(0,0);
			System.out.println(ans);
		}
	}

	private static void perm(int cur, int sum) {
		if(sum > n) return;
		if(sum==n) {
			ans++;
			return;
		}
		
		perm(cur+1, sum+1);
		perm(cur+2, sum+2);
		perm(cur+3, sum+3);
	}
	 */