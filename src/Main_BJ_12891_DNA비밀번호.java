import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BJ_12891_DNA비밀번호 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		LinkedList<Character> window = new LinkedList<>();
		char[] words = br.readLine().toCharArray();
		
		
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		
		int aCount = 0;
		int cCount = 0;
		int gCount = 0;
		int tCount = 0;
		
		int ans = 0;
		int idx = 0;
		
		for(int i=0; i<P; i++) {
			window.add(words[i]);
			if(window.get(i)=='A') aCount++;
			if(window.get(i)=='C') cCount++;
			if(window.get(i)=='G') gCount++;
			if(window.get(i)=='T') tCount++;
		}
		
		if(aCount>=A && cCount>=C && gCount>=G && tCount>=T) {
			ans++;
		}
		
		while(P+idx<S) {
			int temp = window.removeFirst();
			
			if(temp=='A') aCount--;
			else if(temp=='C') cCount--;
			else if(temp=='G') gCount--;
			else if(temp=='T') tCount--;
			window.addLast(words[P+idx]);
			
			if(words[P+idx]=='A') aCount++;
			else if(words[P+idx]=='C') cCount++;
			else if(words[P+idx]=='G') gCount++;
			else if(words[P+idx]=='T') tCount++;
			
			if(aCount>=A && cCount>=C && gCount>=G && tCount>=T) {
				ans++;
			}
			idx++;
		
		}
		System.out.println(ans);
		
	}
}
