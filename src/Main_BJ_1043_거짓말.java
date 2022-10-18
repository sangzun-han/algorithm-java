import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1043_거짓말 {
	static int N,M;
	static int[] parents;
	static int[] knowingPeople;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 인원
		M = Integer.parseInt(st.nextToken()); // 열리는 파티 갯수
		parents = new int[N+1];
		
	}
}
