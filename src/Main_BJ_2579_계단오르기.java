import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_2579_계단오르기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] stairs = new int[301];
		// d[i] = i번째 계단을 밟았을 때 최대값
		int[] d = new int[301];
		for(int i=1; i<=n; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		d[1] = stairs[1];
		d[2] = stairs[1] + stairs[2];
		d[3] = Math.max(stairs[1]+stairs[3], stairs[2]+stairs[3]);
		
		
		for(int i=4; i<=n; i++) {
			d[i] = Math.max(d[i-3]+stairs[i-1]+stairs[i], d[i-2]+stairs[i]);
		}
		
		System.out.println(d[n]);
	}
}
