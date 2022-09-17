import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_11066_파일합치기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[][] d = new int[K+2][K+2];
            int[] files = new int[K+1];
            for(int i=1; i<=K; i++) {
                files[i] = Integer.parseInt(st.nextToken());
            }

            int[] sum = new int[K+1];
            sum[0] = files[0];

            for(int i=1; i<=K; i++) {
                sum[i] = sum[i - 1] + files[i];
            }

            for(int i=2; i<=K; i++) {
                for(int j=i-1; j>0; j--) {
                    d[j][i] = Integer.MAX_VALUE;
                    for(int k=j; k <= i; k++) {
                        d[j][i] = Math.min(d[j][i], d[j][k] + d[k+1][i]);
                    }
                    d[j][i] += sum[i] - sum[j-1];
                }
            }
            System.out.println(d[1][K]);
        }
    }
}


