import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_BJ_20437_문자열게임2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
        	int[] alpha = new int[26];
            String word = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if(K==1) {
            	sb.append(1).append(" ").append(1).append("\n");
            	continue;
            }
            
            // 3번 게임 : K개를 포함하는 가장 짧은 연속 문자열의 길이
            // 4반 게임 : K개를 포함하면 문자열 첫번재, 마지막글자 같으면서, 가장긴 길이
            // 게임을 나눠서 진행할 필요 없어보임
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            // 단어의 알파벳수 미리 다 새놓음
            for (int i = 0; i < word.length(); i++) {
                alpha[word.charAt(i) - 'a']++;
            }

            for(int i=0; i<word.length(); i++) {
                int cur = word.charAt(i);
                if (alpha[cur - 'a'] < K) continue; // K개 미만은 고려할 필요가 없음

                int cnt = 0;

                for (int j = i; j < word.length(); j++) {
                	
                    if (cur == word.charAt(j)) cnt++;
                    
                    if (cnt == K) {
                        min = Math.min(min, j - i + 1);
                        max = Math.max(max, j - i + 1);
                        break;
                    }
                }
            }

                if(min != Integer.MAX_VALUE) {
                    sb.append(min).append(" ").append(max).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        System.out.println(sb);
    }
    }