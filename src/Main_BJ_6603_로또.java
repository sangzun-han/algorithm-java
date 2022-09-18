import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_6603_로또 {
	static int[] lottos,ans;
	static boolean[] visited;
	static int k;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k==0) break;
			
			lottos = new int[k];
			ans = new int[k];
			visited = new boolean[k];
			
			for(int i=0; i<k; i++) {
				lottos[i] = Integer.parseInt(st.nextToken());
			}
			comb(0,0);
			System.out.println();
		}
		
		
	}

	private static void comb(int start, int cnt) {
		if(cnt==6) {
			for(int i=0; i<k; i++) {
				if(ans[i]!=0) System.out.print(ans[i] +" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start; i<k; i++) {
			ans[cnt] = lottos[i];
			comb(i+1,cnt+1);
		}
	}
}

