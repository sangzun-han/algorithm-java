import java.io.*;
import java.util.*;

public class Main_BJ_13904_과제 {
	static class Info implements Comparable<Info>{
		int day, score;
		
		Info(int day, int score) {
			this.day = day;
			this.score = score;
		}

		@Override
		public int compareTo(Info o) {
			return o.score - this.score;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<Info> list = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		int last = 0;
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			list.add(new Info(day, score));
			last = Math.max(last, day);
		}
		int ans = 0;
		for(int i=last; i>0; i--) {
			Info info = new Info(0,0);
			
			for(Info inf: list) {
				if(inf.day >= i && info.score < inf.score) {
					info = inf;
				}
			}
			ans += info.score;
			list.remove(info);
		}
		System.out.println(ans);


		
	}
}	
