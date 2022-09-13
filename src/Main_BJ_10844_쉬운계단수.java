import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_10844_쉬운계단수 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] d = new int[N+1][10];
		
		d[1][0] = 0;
		for(int i=1; i<10; i++) {
			d[1][i] = 1;
		}
		
		for(int i=2; i<=N; i++) {
			d[i][0] = (d[i-1][1]) % 1000000000;
			d[i][1] = d[i-1][0] == 0 ? 1 : d[i-1][0];
			d[i][1] = (d[i][1] + d[i-1][2]) % 1000000000;
			
			for(int j=2; j<=8; j++) {
				int temp = d[i-1][j-1] + d[i-1][j+1];
				d[i][j] = temp % 1000000000;
			}
			
			d[i][9] = (d[i-1][8]) % 1000000000;
		}
		
		
		int ans = 0;
		for(int i=1; i<=9; i++) {
			ans = (ans + d[N][i]) % 1000000000;
			
		}
		System.out.println(ans);
		
	}
}
