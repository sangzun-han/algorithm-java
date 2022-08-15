package BaekJoon.Boj12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Character> queue =new LinkedList<>();
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		char[] DNA = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int cntA = 0;
		int cntC = 0;
		int cntG = 0;
		int cntT = 0;
		int ans =0;
		for(int i=0; i<S; i++) {
			if(DNA[i]=='A') cntA++;
			if(DNA[i]=='C') cntC++;
			if(DNA[i]=='G') cntG++;
			if(DNA[i]=='T') cntT++;
			queue.add(DNA[i]);
			
			if(queue.size() > P) {
				char ch = queue.poll();
				if(ch=='A') cntA--;
				if(ch=='C') cntC--;
				if(ch=='G') cntG--;
				if(ch=='T') cntT--;
			}
			
			if(queue.size()==P && A<=cntA && C<=cntC && G<=cntG && T<=cntT) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
