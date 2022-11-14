import java.util.*;
import java.io.*;

public class Main_BJ_1620_나는야포켓몬마스터이다솜 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> pocketToIndex = new HashMap<>();
		Map<Integer, String> IndexToPocket = new HashMap<>();
		
		
		for(int i=1; i<=N; i++) {
			String s = br.readLine();
			pocketToIndex.put(s, i);
			IndexToPocket.put(i, s);
		}
		
		for(int i=0; i<M; i++) {
			String s = br.readLine();
			// 숫자면
			if(isNumber(s)) {
				sb.append(IndexToPocket.get(Integer.parseInt(s))).append("\n");
			} else {
				sb.append(pocketToIndex.get(s)).append("\n");
			}
		}
		
		System.out.println(sb);
	}

	private static boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
}