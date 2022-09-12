import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_9184_신나는함수실행 {
	static int[][][] d = new int[21][21][21];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == -1 && b == -1 && c == -1)
				break;
			int ans = w(a, b, c);
			sb.append("w").append("(").append(a).append(",").append(" ").append(b).append(",").append(" ").append(c)
					.append(")").append(" ").append("=").append(" ").append(ans).append("\n");

		}
		System.out.print(sb);
	}

	private static int w(int a, int b, int c) {
		if (a >= 0 && a <= 20 && b >= 0 && b <= 20 && c >= 0 && c <= 20 && d[a][b][c] != 0)
			return d[a][b][c];
		if (a <= 0 || b <= 0 || c <= 0)
			return 1;
		if (a > 20 || b > 20 || c > 20)
			return d[20][20][20] = w(20, 20, 20);
		if (a < b && b < c)
			return d[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		else
			return d[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
	}
}
