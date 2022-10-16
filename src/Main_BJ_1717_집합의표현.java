import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1717_집합의표현 {
	static int N,M;
	static int[] parents;
	
	static void make() {
		parents = new int[N+1];
		for(int i=0; i<=N; i++) {
			parents[i] = i;
		}
	}
	
	static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(xRoot==yRoot) return false;
		if(xRoot > yRoot) {
			parents[xRoot] = yRoot;
		} else if (xRoot < yRoot) {
			parents[yRoot] = xRoot;
		}
		return true;
	}
	
	static int find(int x) {
		if(x==parents[x]) return x;
		return parents[x] = find(parents[x]);
	}
	

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		make();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			//type==0이면 합집합
			if(type==0) {
				union(a,b);
			} else if (type==1) {
				if(find(a)==find(b)) sb.append("YES").append("\n");
				else sb.append("NO").append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
