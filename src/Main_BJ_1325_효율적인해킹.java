import java.util.*;
import java.io.*;

public class Main_BJ_1325_효율적인해킹 {
   static ArrayList<Integer>[] map;
   static int N,M;
   static boolean[] visited;
   static int[] arr;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      StringBuilder sb = new StringBuilder();
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      
      map = new ArrayList[N+1];
      for(int i=1; i<=N; i++) {
         map[i] = new ArrayList<Integer>();
      }
      
      visited = new boolean[N+1];
      arr = new int[N+1];
      for(int i=0; i<M; i++) {
         st = new StringTokenizer(br.readLine());
         int s = Integer.parseInt(st.nextToken());
         int e = Integer.parseInt(st.nextToken());
         map[e].add(s);
      }
      
//      for(int i=1; i<map.length; i++) {
//         System.out.println(map[i]);
//      }
      
      for(int i=1; i<map.length; i++) {
         arr[i] = BFS(i);
      }
      
      int max = 0;
      
      for(int i=1; i<arr.length; i++) {
         max = Math.max(arr[i], max);
      }
      
      for(int i=1; i<arr.length; i++) {
         if(arr[i] == max) sb.append(i).append(" ");
      }
      
      System.out.println(sb);
   }
   
   
   public static int BFS(int Node) {
      int count = 0;
      Queue<Integer> queue = new LinkedList<Integer>();
      visited = new boolean[N+1];
      queue.add(Node);
      visited[Node] = true;
      
      while(!queue.isEmpty()) {
         int now_Node = queue.poll();
         for(int i : map[now_Node]) {
            if(!visited[i]) {
               visited[i] = true;
               queue.add(i);
               count++;
            }
         }
      }
      return count;
   }
}