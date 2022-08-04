package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Boj11000 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int n = Integer.parseInt(br.readLine());
		int[][] lectures = new int[n][2];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int Si = Integer.parseInt(st.nextToken());
			int Ti = Integer.parseInt(st.nextToken());
			lectures[i][0] = Si;
			lectures[i][1] = Ti;
		}
		
		Arrays.sort(lectures, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o1[1] - o2[1]; // 오름차순
				else return o1[0] - o2[0]; // 오름차순
			}
		});
	
	
//		int count = 1;
//		int temp = 0;
//		for(int i=1; i<n; i++) {
//			if(lectures[temp][1] <= lectures[i][0]) {
//				count++;
//				temp = i;
//			}
//		}
		for(int i=0; i<n; i++) {
			System.out.print(lectures[i][0]+" "+lectures[i][1]+"\n");
		}
		
		for(int i=0; i<n; i++) {
			int ti = lectures[i][1];
			if(!queue.isEmpty() && queue.peek() <= lectures[i][0]) {
				queue.poll();
			}
			queue.offer(ti);
		}
		System.out.println(queue.size());
		
	}
}

