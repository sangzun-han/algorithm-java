import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1244_스위치켜고끄기 {
	static int N;
	static int[] switches;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 스위치의 개수
		switches = new int[N+1];
		switches[0] = -1;
		st = new StringTokenizer(br.readLine());
		// 스위치 값 초기화
		for(int i=1; i<=N; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		
		int students = Integer.parseInt(br.readLine()); // 학생 수
		
		for(int i=0; i<students; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken()); // 남:1 여:2
			int num = Integer.parseInt(st.nextToken()); // 스위치 번호
			
			if(gender==1) man(num);
			else woman(num);
		}
		
		for(int i=1; i<=N; i++) {
			System.out.print(switches[i]+" ");
			if(i%20==0) System.out.println();
		}
	}
	
	private static void man(int num) {
		for(int i=num; i<=N; i+=num) {
			switches[i] = switches[i] == 0 ? 1 : 0;
		}
	}
	
	private static void woman(int num) {
		switches[num] = switches[num] == 0 ? 1 : 0;		
		for(int i=1; i<=num; i++) {
			if(num-i>=1 && num+i<=N && switches[num-i] == switches[num+i]) {
				switches[num-i] = switches[num-i] == 0 ? 1 : 0;
				switches[num+i] = switches[num+i] == 0 ? 1 : 0;
			} else {
				break;
			}
		}
	}
	
	
}
