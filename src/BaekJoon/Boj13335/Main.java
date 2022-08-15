package BaekJoon.Boj13335;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 트럭 개수
		int W = Integer.parseInt(st.nextToken()); // 다리 길이
		int L = Integer.parseInt(st.nextToken()); // 다리 최대 무게
		int[] truck = new int[N];

		int time = 0; // 시간
		int weight = 0; // 트럭 무게 총합

		Queue<Integer> queue = new LinkedList<>();
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			truck[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			while (true) {
				if (queue.isEmpty()) { // 다리에 아무것도 없으면
					queue.offer(truck[i]); // 다리에 트럭 올리기
					time++; // 시간증가
					weight += truck[i]; // 무게 증가
					break;
				} else if (queue.size() == W) { // 다리에 트럭 다 있으면
					weight -= queue.remove(); // 트럭 하나 무게 빼기
				} else { // 다리에 트럭있을 때
					if (weight + truck[i] > L) { // 최대 하중보다 크면
						queue.offer(0); // 무게에 영향없는 0 추가, 트럭 움직임
						time++; // 시간 증가
					} else { // 최대하중보다 작으면
						queue.offer(truck[i]); // 트럭 하나 
						time++; // 시간 증가
						weight += truck[i]; // 무게 증가
						break;
					}
				}

			}
		}
		System.out.println(time+W);

	}
}
