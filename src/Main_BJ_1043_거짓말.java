import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_1043_거짓말 {
	static int N,M;
	static int[] parents;
	static ArrayList<Integer> knowing;
	static ArrayList<Integer> parties;
	static void makeSet() {
		parents = new int[N+1];
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int x) {
		if(x==parents[x]) return x;
		return parents[x] = find(parents[x]);
	}
	
	static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(xRoot==yRoot) return false;
		parents[yRoot] = xRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		makeSet();
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		while(num-->0) {
			knowing.add(Integer.parseInt(st.nextToken()));
		}
		
		int party = 0;
		int prev = 0;
		int next = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			party = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<party; j++) {
				next = prev;
				prev =Integer.parseInt(st.nextToken());
				union(prev, next);
				parties.add(prev);
			}
		}
		
		for(int i=0; i<M; i++) {
			boolean flag = true;
			for(int i=0; i<parties.size(); i++) {
				if(find())
			}
		}
		
	}
}