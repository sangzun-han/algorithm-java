import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1253_좋다 {
	static int N;
	static int[] nums;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		nums = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int ans = 0;
		Arrays.sort(nums);

		for (int i = 0; i < N; i++) {
			int findNum = nums[i];

			int left = 0;
			int right = N - 1;

			while (left < right && right < N) {
				if (left == i)
					left++;
				else if (right == i)
					right--;
				else {
					int sum = nums[left] + nums[right];
					if (sum > findNum) {
						right--;
					} else if (sum == findNum) {
						ans++;
						break;
					} else if (sum < findNum) {
						left++;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
