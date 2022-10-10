
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 다익스트라 풀이하다가 안될거같아서 패스
// 플로이드 와샬 ->
public class Main_BJ_1976_여행가자 {
    static int N,M;
    static int[][] map;
    static int[] plan;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        plan = new int[M+1];

        // 도시 연결 정보
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(i==j) map[i][j] = 1;
            }
        }


        // 여행계획
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=M; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        floyd();

        for(int i=1; i<M; i+=2) {
            if(map[plan[i]][plan[i+1]] == 1) continue;
            else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static void floyd() {
        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(map[i][k] == 1 && map[k][j] == 1) map[i][j] = 1;
                }
            }
        }

    }

}
