package BaekJoon.Boj1697;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int MAX = 200000; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] check = new boolean[MAX];
		int[] d = new int[MAX];
		
		check[N] = true;
		d[N] = 0;
		
		Queue<Integer> queue =new ArrayDeque<>();
		queue.offer(N);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			if(now - 1 >= 0) {
				if(!check[now-1]) {
					
				queue.offer(now-1);
				check[now-1] = true;
				d[now-1] = d[now] + 1;
				}
			}
			if(now + 1 < MAX) {
				if(!check[now+1]) {
					
				queue.offer(now+1);
				check[now+1] = true;
				d[now+1] = d[now] + 1;
				}
			}
			
			if(now * 2 < MAX) {
				if(!check[now*2]) {
					
					queue.offer(now*2);
					check[now*2] = true;
					d[now*2] = d[now] + 1;
				}
			}
		}
		System.out.println(d[K]);
		
	}
}
