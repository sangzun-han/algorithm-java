import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_1504_특정한최단경로 {
	static final int INF = 200000000;
    static int N,E;
    static List<Node>[] adjList;
    static class Node {
        int to,weight;
        
        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        // 인접리스트 생성
        adjList = new ArrayList[N+1];
        
        // 인접리스트 초기화
        for(int i=1; i<=N; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        
        for(int i=1; i<=E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            adjList[a].add(new Node(b,c));
            adjList[b].add(new Node(a,c));
        }
        st = new StringTokenizer(br.readLine());
        int mid1 = Integer.parseInt(st.nextToken());
        int mid2 = Integer.parseInt(st.nextToken());
        
        
        int d1 = 0;
        d1 += dijkstra(1,mid1);
        d1 += dijkstra(mid1,mid2);
        d1 += dijkstra(mid2,N);

        int d2 = 0;
        d2 += dijkstra(1,mid2);
        d2 += dijkstra(mid2, mid1);
        d2 += dijkstra(mid1, N);
        
        if(d1 >= INF && d2 >= INF) {
        	System.out.println(-1);
        } else {
        	System.out.println(Math.min(d1,d2));
        }
    }

    private static int dijkstra(int start, int end) {
        int[] d = new int[N+1];
        boolean[] visited = new boolean[N+1];
        
        Arrays.fill(d, INF);
        d[start] = 0;
        
        for(int i=1; i<=N; i++) {
            int min = INF;
            int minV = -1;
            for(int j=1; j<=N; j++) {
                if(!visited[j] && min > d[j]) {
                    min = d[j];
                    minV = j;
                }
            }
            
            if(minV != -1) {
            	visited[minV] = true;
                for(Node n: adjList[minV]) {
                    if(!visited[n.to] && n.weight > 0 && d[n.to] > d[minV] + n.weight) {
                        d[n.to] = d[minV] + n.weight;
                    }
                }                
            }
        }
       
        return d[end];
    }
}