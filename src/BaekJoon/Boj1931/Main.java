package BaekJoon.Boj1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
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
				if(o1[1] == o2[1]) return o1[0] - o2[0]; 
				else return o1[1] - o2[1]; 
			}
		});
		
		int prev = 0;
		int count = 0;
		for(int i=0; i<n; i++) {
			if (prev <= lectures[i][0]) {
				prev = lectures[i][1];
				count++;
			}
		}
		System.out.println(count);
	}
}
