import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_2309_일곱난쟁이 {
	static int[] height;
	static int[] ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		height = new int[9];
		ans = new int[7];
		
		for(int i=0; i<9; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}
		
		comb(0,0);
	}

	private static void comb(int start, int cnt) {
		if(cnt==7) {
			if(check(ans)) {
				Arrays.sort(ans);
				for(int i=0; i<7; i++) System.out.println(ans[i]);
				System.exit(0);
			}
			return;
		}
		
		for(int i=start; i<9; i++) {
			ans[cnt] = height[i];
			comb(i+1,cnt+1);
		}
	}
	
	private static boolean check(int[] ans) {
		int sum = 0;
		for(int i=0; i<7; i++) sum += ans[i];
		if(sum==100) return true;
		return false;
	}
}
