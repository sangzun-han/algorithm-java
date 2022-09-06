import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_11727_2n타일링2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] d = new int[n+1];
		d[0] = 1;
		d[1] = 1;
		
		for(int i=2; i<=n; i++) {
			d[i] = (d[i-1] + d[i-2]*2)%10007;
		}
		
		System.out.println(d[n]);
	}
}
