import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 *  
 * d[n] : n을 1로 만드는 최소 연산 횟수
 */
public class Main_BJ_1463_1로만들기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] d = new int[N+1];
		for(int i=2; i<=N; i++) {
			d[i] = d[i-1] + 1;
			
			if(i%2==0 && d[i] > d[i/2]+1) {
				d[i] = d[i/2] + 1;
			}
			
			if(i%3 == 0 && d[i] > d[i/3]+1) {
				d[i] = d[i/3] +1;
			}
			
		}
		
		System.out.println(Arrays.toString(d));
		
	}
}
