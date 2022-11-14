import java.io.*;
import java.util.*;

public class Main_BJ_2212_센서 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Set<Integer> set = new TreeSet<>();
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[] sensors = new int[N];
		int[] dif = new int[N-1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			sensors[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sensors);
		
		for(int i=0; i<N-1; i++) {
			dif[i] = sensors[i+1] - sensors[i];
		}
		
		Arrays.sort(dif);

		int ans = 0;
		for(int i=0; i<N-K; i++) {
			ans += dif[i];
		}
		
		System.out.println(ans);
		
		
	}
}