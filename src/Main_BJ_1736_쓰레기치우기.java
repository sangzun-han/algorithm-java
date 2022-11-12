import java.util.*;
import java.io.*;

public class Main_BJ_1736_쓰레기치우기 {
    static int N,M,robot,trash;
    static int[][] map;
    
    static class Point {
        int x,y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        robot = 0;
        trash = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) trash++;
            }
        }
        
        while(trash>0) {
        	robot++;
        	dfs(0,0);        	
        }
        
        System.out.println(robot);
    }

    
    private static void dfs(int x, int y) {
    	if(x==N-1&&y==M-1) {
    		robot++;
    		return;
    	}
    	
        for(int i=x; i<N; i++) {
        	for(int j=y; j<M; j++) {
        		if(map[i][j]==1) {
        			map[i][j] = 0;
        			trash--;
        			dfs(i,j);
        			return;
        		}
        	}
        }
    }
}