import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_1208_부분수열의합2 {
	static int N,M,S;
	static long[] nums;
	static List<Long> front;
	static List<Long> back;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		nums = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Long.parseLong(st.nextToken());
		}
		M = N/2;
		
	
		front = new ArrayList<>();
		back = new ArrayList<>();
		
		// 2^40 = 1조(시간초과)
		// 2^20 , 2^20에 대한 모든 부분수열의 합 구하기
		subset(0,M,0,front);
		subset(M,N,0,back);
		Collections.sort(front);
		Collections.sort(back);
		
		/// 투포인터를 이용해서 S가 되는 경우의 수 모두 찾기.
		int left = 0;
		int right = back.size()-1;
		long ans = 0;
		while(left < front.size() && right >= 0) {
			long sum = front.get(left) + back.get(right);
			if(sum>S)  right--;
			else if (sum==S) {
				long cnt1 = 0;
				long cnt2 = 0;
				long val = front.get(left);
				long val2 = back.get(right);
				
				while(left < front.size() && val==front.get(left)) {
					left++;
					cnt1++;
				}
				
				
				while(right>=0 && val2==back.get(right)) {
					right--;
					cnt2++;
				}
				
				ans += cnt1*cnt2;
				
			} else if(sum<S) left++;
			
		}
		if(S==0) ans--;
		System.out.println(ans);
		
		
	}

	
	private static void subset(int idx, int cnt, long sum, List<Long> list) {
		if(idx==cnt) {
			list.add(sum);
			return;
		}
		subset(idx+1, cnt, sum+nums[idx],list);
		subset(idx+1, cnt, sum,list);
	}
}
