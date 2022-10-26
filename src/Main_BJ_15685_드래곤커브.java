import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BJ_15685_드래곤커브 {
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new boolean[101][101];
		ArrayList<Integer> curve = new ArrayList<>();

		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			curve = dragonCurve(d, g);
			map[x][y] = true;
			for (int dir : curve) {
				x += dx[dir];
				y += dy[dir];
				map[x][y] = true;
			}
		}

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1])
					ans++;
			}
		}
		System.out.println(ans);

	}

	private static ArrayList<Integer> dragonCurve(int d, int g) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(d);
		for (int i = 1; i <= g; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			temp.addAll(list);
			Collections.reverse(temp);

			for (int j = 0; j < temp.size(); j++) {
				temp.set(j, (temp.get(j) + 1) % 4);
			}
			list.addAll(temp);
		}
		return list;
	}

}