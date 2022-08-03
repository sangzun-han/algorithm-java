package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 함수호출회수 * 함수 시간 복잡도
 * = 문제의 개수 * 문제 1개 푸는데 필요한 시간복잡도
 * = N * 1
 */
public class Boj1463_recursive {
	public static int[] d;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		d = new int[n+1];
		System.out.println(recursive(n));
		
	}
	private static int recursive(int n) {
		if(n==1) return 0; // 1인경우 카운트할 필요없음
		if(d[n] > 0) return d[n]; // 메모이제이션
		d[n] = recursive(n-1) + 1;
		if(n%2==0) {
			int temp = recursive(n/2) + 1;
			if(d[n] > temp) d[n] = temp;
		}
		if(n%3==0) {
			int temp = recursive(n/3) + 1;
			if(d[n] > temp) d[n] = temp;
		}
		return d[n];
	}
}
