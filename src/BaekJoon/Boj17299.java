package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj17299 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int[] cnt = new int[1000001];
		int[] nums = new int[N];
		int[] ans = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) nums[i] = Integer.parseInt(st.nextToken());	
		for(int i=0; i<N; i++) cnt[nums[i]] +=1; 
		
		for(int i=0; i<N; i++) {
			while(!stack.isEmpty() && cnt[nums[i]] > cnt[nums[stack.peek()]]) {
				ans[stack.pop()] = nums[i];
			}
			stack.push(i);
		}
		while(!stack.isEmpty()) ans[stack.pop()] = - 1;
		
		for(int i=0; i<N; i++) sb.append(ans[i]+" ");
		System.out.println(sb);
	}}
