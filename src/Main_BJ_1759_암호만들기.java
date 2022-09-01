import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1759_암호만들기 {
	static int L,C;
	static char[] alpha;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpha = new char[C];
		visited = new boolean[C];
		String s = br.readLine().replace(" ", "");
		alpha =  s.toCharArray();
		Arrays.sort(alpha);
		comb(0,0);
	}

	private static void comb(int cnt, int start) {
		if(cnt==L) {
			int mo = 0;
			int ja = 0;
			
			for(int i=0; i<C; i++) {
				if(visited[i] && (alpha[i] == 'a' || alpha[i] == 'e' || alpha[i] == 'i' || alpha[i] == 'o' || alpha[i] == 'u')) {
					mo++;
				} else if(visited[i]) {
					ja++;
				}	
			}
			
			if(mo>=1 && ja>=2) {
				for(int i=0; i<C; i++) {
					if(visited[i]) {
						System.out.print(alpha[i]);
					}
				}
				System.out.println();
					
			}
		
		}
		
		for(int i=start; i<C; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			comb(cnt+1,i+1);
			visited[i] = false;
		}
		
	}
}
