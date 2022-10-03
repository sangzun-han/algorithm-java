import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_16637_괄호추가하기 {
    static class Exp {
        int num,op;

        public Exp(int num, int op) {
            this.num = num;
            this.op = op;
        }
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        Exp[] exp = new Exp[N];

        for(int i=0; i<N; i++) {
            if(i%2 == 0) {
                exp[i] = new Exp(s.charAt(i)-'0', 0);
            } else {
                int op = 1;
                if(s.charAt(i) == '-') op = 2;
                else if(s.charAt(i) =='*') op = 3;
                exp[i] = new Exp(0, op);
            }
        }

        int M = (N-1) / 2; // 연산자의 개수
        int ans = Integer.MIN_VALUE;

        for(int i=0; i<(1<<M); i++) {
            boolean flag = true;

            for(int j=0; j<M-1; j++) {
                if((i&(1<<j)) > 0 && (i&(1<<(j+1))) > 0) {
                    flag = false;
                }
            }

            if(!flag) continue;
            Exp[] exp2 = new Exp[N];

            for(int j=0; j<N; j++) {
                exp2[j] = new Exp(exp[j].num, exp[j].op);
            }

            for(int j=0; j<M; j++) {
                if((i&(1<<j)) > 0) {
                    int k = 2*j+1;

                    if(exp2[k].op == 1) {
                        exp2[k-1].num += exp[k+1].num;
                        exp2[k+1].num = 0;
                    } else if (exp2[k].op == 2) {
                        exp2[k-1].num -= exp[k+1].num;
                        exp2[k].op = 1;
                        exp2[k+1].num = 0;
                    } else if (exp2[k].op == 3) {
                        exp2[k-1].num *= exp[k+1].num;
                        exp2[k].op = 1;
                        exp2[k+1].num = 0;
                    }
                }
            }

            int res = exp2[0].num;
            for(int j=0; j<M; j++) {
                int k = 2*j+1;

                if(exp2[k].op == 1) {
                    res += exp2[k+1].num;
                } else if (exp2[k].op == 2) {
                    res -= exp2[k+1].num;
                } else if (exp2[k].op == 3) {
                    res *= exp2[k+1].num;
                }
            }

            if(ans < res) ans = res;
        }
        System.out.println(ans);
    }
}
