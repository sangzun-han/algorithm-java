import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2458_키순서 {
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken()); // 학생 수
        M = Integer.parseInt(st.nextToken()); // 키 비교 횟수
        map = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            int count = 0;
            count = small(i) + big(i);
            if (count == N - 1) ans++;
        }

        System.out.println(ans);
    }

    private static int small(int x) {
        int cnt = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(x);
        boolean[] visited = new boolean[N + 1];

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (map[i][cur] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static int big(int x) {
        int cnt = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(x);
        boolean[] visited = new boolean[N + 1];

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (map[cur][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}