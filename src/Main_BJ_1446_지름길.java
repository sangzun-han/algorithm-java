import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_1446_지름길 {
	static int N,D,ans;
	static ArrayList<Node> list = new ArrayList<>();
	
	static class Node {
		int from,to,cost;
		
		Node(int from,int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if(to > D) continue;
			if(to-from <= cost) continue;
			list.add(new Node(from, to, cost));
		}
		ans = Integer.MAX_VALUE;
		
		recursive(0,0);
		System.out.println(ans);
	}
	
	private static void recursive(int v, int cost) {
		if(cost >= ans) return;
		if(v==D) {
			ans = Math.min(ans, cost);
			return;
		}
		
		for(int i=0; i<list.size(); i++) {
			Node n = list.get(i);
			if(n.from==v) {
				recursive(n.to, cost+n.cost);
			}
		}
		recursive(v+1, cost+1);
	}
}
