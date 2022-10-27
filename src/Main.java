import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;

    static boolean[] visited = new boolean[200001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        queue.offer(new int[]{N, 0});

        visited[N] = true;

        int answer = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int loc = now[0];
            int time = now[1];

            if (loc == K) {
                answer = Math.min(answer, time);
                continue;
            }

            if (loc * 2 <= 100000) {
                if (!visited[loc * 2]) {
                    visited[loc * 2] = true;
                    queue.offer(new int[]{loc * 2, time});
                }
            }

            if (loc - 1 >= 0) {
                if (!visited[loc - 1]) {
                    visited[loc - 1] = true;
                    queue.offer(new int[]{loc - 1, time + 1});
                }
            }

            if(loc + 1 <= 100000) {
                if (!visited[loc + 1]) {
                    visited[loc + 1] = true;
                    queue.offer(new int[]{loc + 1, time + 1});
                }
            }
        }

        System.out.println(answer);
    }
}
