import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ_22233_가희와키워드 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String,Boolean> keywords = new HashMap<>();
		
		// 키워드 넣기
		for(int i=0; i<N; i++) {
			keywords.put(br.readLine(), true);
		}
		int ans = keywords.size();
		
		// 블로그에 키워드 이용해서 글쓰기
 		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), ",");
			
			while(st.hasMoreTokens()) {
				String s= st.nextToken();
				if(keywords.containsKey(s)) {
					keywords.remove(s);
					ans--;
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}



