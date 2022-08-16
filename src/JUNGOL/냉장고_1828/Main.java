package JUNGOL.냉장고_1828;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class  Main {
	static class Chemical implements Comparable<Chemical> {
		int x;
		int y;

		Chemical(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Chemical o) {
			return this.y != o.y ? this.y-o.y : this.x -o.x;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int ans = 1;
		Chemical[] c = new Chemical[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			c[i] = new Chemical(X, Y);
		}
		
		
		
		Arrays.sort(c);
		int max = c[0].y;
		

		for(int i=1; i<N; i++) {
			if(c[i].x > max) {
				max = c[i].y;
				ans++;
			} 
		}
		System.out.println(ans);
	}

}

