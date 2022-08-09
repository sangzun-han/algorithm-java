package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Pos {
	int time;
	String pos;
	
	Pos(int time, String pos) {
		this.time = time;
		this.pos = pos;
	}
}

public class Boj2065 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		Queue<Pos> left = new LinkedList<>();
		Queue<Pos> right = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			String pos = st.nextToken();
			if(pos.equals("left")) left.add(new Pos(time,pos));
			if(pos.equals("right")) right.add(new Pos(time,pos));
		}
		System.out.println(left);
	}
}
