import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_11726_2n타일링 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] d = new int[N+1];
		d[0] = 1;
		d[1] = 1;
		
		for(int i=2; i<=N; i++) {
			d[i] = (d[i-2] + d[i-1])%10007;
		}
		
		System.out.println(d[N]);
	}
}	
