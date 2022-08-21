package BaekJoon.Boj14226;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static class Emotion {
		int screen;
		int clipboard;
		
		Emotion(int screen, int clipboard) {
			this.screen = screen;
			this.clipboard = clipboard;
		}
	}
	
	
	static int MAX = 2000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());
		int[][] time = new int[MAX][MAX];
		
		for(int i=0; i<MAX; i++) {
			for(int j=0; j<MAX; j++) {
				time[i][j] = -1;
			}
		}
		
		Queue<Emotion> queue = new ArrayDeque<>();
		time[1][0]= 0;
		queue.offer(new Emotion(1,0));
		
		while(!queue.isEmpty()) {
			Emotion e = queue.poll();
			if(time[e.screen][e.screen] == -1) {
				time[e.screen][e.screen] = time[e.screen][e.clipboard] + 1;
				queue.offer(new Emotion(e.screen, e.screen));
			}
			
			if(e.screen + e.clipboard <= S && time[e.screen+e.clipboard][e.clipboard] == -1) {
				time[e.screen+e.clipboard][e.clipboard] = time[e.screen][e.clipboard] + 1;
				queue.offer(new Emotion(e.screen+e.clipboard, e.clipboard));
			}
			if(e.screen - 1 >= 0 && time[e.screen-1][e.clipboard] == -1) {
				time[e.screen-1][e.clipboard] = time[e.screen][e.clipboard] + 1;
				queue.offer(new Emotion(e.screen-1, e.clipboard));
			}
		}
		
		int ans = -1;
		for(int i=0; i<=S; i++) {
			if(time[S][i] != -1) {
				if(ans == -1 || ans>time[S][i]) {
					ans = time[S][i];
				}
			}
		}
		System.out.println(ans);
	}
}
