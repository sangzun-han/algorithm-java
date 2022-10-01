import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class MaIn_BJ_14395_4연산 {
    final static int INF = 1000000000;
    static long s;
    static int t;
    static HashSet<Long> check = new HashSet<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Long.parseLong(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        bfs(s);
    }

    private static void bfs(long s) {
        Queue<Long> queue = new ArrayDeque<>();
        Queue<String> queueString = new ArrayDeque<>();
        queue.offer(s);
        queueString.offer("");
        check.add(s);

        while(!queue.isEmpty()) {
            long x = queue.poll();
            String str = queueString.poll();
            if(x==t) {
                if(str.length() == 0) {
                    str = "0";
                }
                System.out.println(str);
                return;
            }
            if(x*x <= INF && x*x >= 0 && !check.contains(x*x)) {
                queue.offer(x*x);
                queueString.offer(str+"*");
                check.add(x*x);
            }

            if(x+x <= INF && x+x >= 0 && !check.contains(x+x)) {
                queue.offer(x+x);
                queueString.offer(str+"+");
                check.add(x+x);
            }

            if(x-x <= INF && x-x >= 0 && !check.contains(x-x)) {
                queue.offer(x-x);
                queueString.offer(str+"-");
                check.add(x-x);
            }

            if(x != 0 && x/x <= INF && x/x >= 0 && !check.contains(x/x)) {
                queue.offer(x/x);
                queueString.offer(str+"/");
                check.add(x/x);
            }
        }
        System.out.println(-1);
    }
}