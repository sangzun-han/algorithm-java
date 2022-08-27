package Swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_낚시터자리잡기_한상준 {

	static int N, ans;
	static int[][] infos;
	static int[][] idxList = { 
			{ 0, 1, 2 }, 
			{ 0, 2, 1 }, 
			{ 1, 0, 2 }, 
			{ 1, 2, 0 }, 
			{ 2, 1, 0 }, 
			{ 2, 0, 1 } 
	};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			infos = new int[3][2];
			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine());
				infos[i][0] = Integer.parseInt(st.nextToken());
				infos[i][1] = Integer.parseInt(st.nextToken());
			}
			ans = Integer.MAX_VALUE;

			for (int method = 0; method < 6; method++) {
				dfs(0, method, new int[N + 1]);
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int cnt, int method, int[] posInfo) {
		if (cnt == 3) {
			ans = Math.min(ans, calcDisSum(posInfo));
			return;
		}

		int[] newPosInfo = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			newPosInfo[i] = posInfo[i];
		}

		int gate = infos[idxList[method][cnt]][0];
		int fisherNum = infos[idxList[method][cnt]][1];

		int distance = 0;

		while (fisherNum > 1) {
			if (gate + distance <= N && newPosInfo[gate + distance] == 0) {
				newPosInfo[gate + distance] = gate;
				fisherNum--;

			}

			if (gate - distance > 0 && newPosInfo[gate - distance] == 0) {
				newPosInfo[gate - distance] = gate;
				fisherNum--;
			}
			distance++;
		}

		if (fisherNum == 0) {
			dfs(cnt + 1, method, newPosInfo);
		} else {
			distance = findMinDis(gate, newPosInfo);

			if (gate - distance > 0 && newPosInfo[gate - distance] == 0) {
				int[] copy = new int[N + 1];
				for (int i = 0; i <= N; i++) {
					copy[i] = newPosInfo[i];
				}
				copy[gate - distance] = gate;
				dfs(cnt + 1, method, copy);
			}

			if (gate + distance <= N && newPosInfo[gate + distance] == 0) {
				int[] copy = new int[N + 1];
				for (int i = 0; i <= N; i++) {
					copy[i] = newPosInfo[i];
				}
				copy[gate + distance] = gate;
				dfs(cnt + 1, method, copy);
			}
		}
	}

	static int calcDisSum(int[] posInfo) {
		int sumDis = 0;
		for (int i = 1; i <= N; i++) {
			if (posInfo[i] != 0) {
				sumDis += Math.abs(posInfo[i] - i) + 1;
			}
		}
		return sumDis;
	}

	static int findMinDis(int gate, int[] posInfo) {
		int leftDis = 0;
		while (gate - leftDis > 0 && posInfo[gate - leftDis] != 0) {
			leftDis++;
		}
		int rightDis = 0;
		while (gate + rightDis <= N && posInfo[gate + rightDis] != 0) {
			rightDis++;
		}

		int minDis = Math.min(leftDis, rightDis);
		int maxDis = Math.max(leftDis, rightDis);

		return (gate + minDis <= N && posInfo[gate + minDis] == 0) || (gate - minDis > 0 && posInfo[gate - minDis] == 0)
				? minDis
				: maxDis;
	}
}
