import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_2193_이친수 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] d = new long[N+1];
		d[1] = 1;
		
		if(N>=2) d[2] = 1;
		for(int i=3; i<=N; i++) {
			d[i] = d[i-2] + d[i-1];	
		}
		
		System.out.println( d[N]);
	}
}
