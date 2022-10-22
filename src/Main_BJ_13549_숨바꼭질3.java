import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_13549_숨바꼭질3 {
	public static void main(String[] args) throws Exception{
		final int INF = 200001;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[INF];
		int[] d = new int[INF];
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(N);
		visited[N] = true;
		d[N] = 0;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			if(now*2<INF && !visited[now*2]) {
				queue.offer(now*2);
				visited[2*now] = true;
				d[2*now] = d[now];
			}
			if(now-1>=0 && !visited[now-1]) {
				queue.offer(now-1);
				visited[now-1] = true;
				d[now-1] = d[now] +1;
			}
			if(now+1<INF && !visited[now+1]) {
				queue.offer(now+1);
				visited[now+1] = true;
				d[now+1] = d[now] + 1;
			}
		}
		System.out.println(d[K]);
	}
}
