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
		
		Collections.sort(list, (o1,o2) -> o2.day - o1.day);

		int ans = 0;
		int idx = 0;
		PriorityQueue<Info> queue = new PriorityQueue<>();
		
		for(int i=last; i>0; i--) {
			while(idx < N && list.get(idx).day >= i) {
				queue.offer(list.get(idx));
			}
			if(!queue.isEmpty()) ans += queue.poll().score;
		}
		System.out.println(ans);
		
	}
}	
