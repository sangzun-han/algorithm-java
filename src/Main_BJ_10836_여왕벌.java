import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_10836_여왕벌 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(st.nextToken()); // 가로세로
		int N = Integer.parseInt(st.nextToken()); // 날짜
		
		int[] map = new int[2*M-1];
		
		for(int i=0; i<2*M-1; i++) {
			Arrays.fill(map, 1);
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int zero = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			
			for(int j=zero; j<zero+one; j++) {
				map[j] += 1;
			}
			
			for(int j=zero+one; j<zero+one+two; j++) {
				map[j] += 2;
			}
		}
		
		for(int i=M-1; i>=0; i--) {
			sb.append(map[i]).append(" ");
			for(int j=M; j<2*M-1; j++) {
				sb.append(map[j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}	
}