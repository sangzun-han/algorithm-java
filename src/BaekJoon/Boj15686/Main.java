/**
 * 주어진 M개의 치킨집을 선택해서 모든 집까리 거리 탐색
 * 최소값 구함
 */
package BaekJoon.Boj15686;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Coordinate {
	int x;
	int y;

	Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int N; // 크기
	static int M; // 치킨집 개수 선택
	static int[][] map;
	static ArrayList<Coordinate> home; // 집 좌표
	static ArrayList<Coordinate> chicken; // 치킨집 좌표
	static boolean[] isSelected;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		home = new ArrayList<>();
		chicken = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					home.add(new Coordinate(i, j));
				} else if (map[i][j] == 2) {
					chicken.add(new Coordinate(i, j));
				}
			}
		}

		ans = Integer.MAX_VALUE;
		isSelected = new boolean[chicken.size()];

		dfs(0, 0);
		System.out.println(ans);
	}

	private static void dfs(int start, int cnt) {

		// 종료조건 (치킨집 M개 선택 됐을 때)
		if (cnt == M) {
			int result = 0;
			for (int i = 0; i < home.size(); i++) {
				int temp = Integer.MAX_VALUE;
				for (int j = 0; j < chicken.size(); j++) {
					if (isSelected[j]) {
						int d = Math.abs(home.get(i).x - chicken.get(j).x) + Math.abs(home.get(i).y - chicken.get(j).y);
						temp = Math.min(temp, d);
					}
				}
				result += temp;
			}
			ans = Math.min(ans, result);
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			isSelected[i] = true;
			dfs(i + 1, cnt + 1);
			isSelected[i] = false;
		}
	}
}
