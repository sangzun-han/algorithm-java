import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_15649_N과M1 {
	static int N,M;
	static int[] nums;
	static int[] ans;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		for(int i=1; i<=N; i++) {
			nums[i-1] = i;
		}
		
		ans = new int[M];
		isSelected = new boolean[N];
		
		perm(0);
		
		System.out.println(sb);
		
	}
	private static void perm(int cnt) {
		if(cnt==M) {
			for(int i=0; i<M; i++) {
				sb.append(ans[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			ans[cnt] = nums[i];
			perm(cnt+1);
			isSelected[i] = false;
		}
		
	}
}
