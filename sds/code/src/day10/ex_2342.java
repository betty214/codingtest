package day10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ex_2342 {
    public static void main(String[] args)  throws IOException {
        System.setIn(new FileInputStream("code/src/day10/2342.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int next=Integer.parseInt(st.nextToken());
        ArrayList<Integer>command=new ArrayList<>();
        while(next!=0){
            command.add(next);
            next=Integer.parseInt(st.nextToken());
        }
        int len=command.size();
        int[][][]DP=new int[len+1][5][5];
        for(int i = 1 ; i <= len ; i++) {
            for(int j = 0 ; j <= 4 ; j++) {
                for(int k = 0 ; k <= 4 ; k++) {
                    DP[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        DP[1][0][command.get(0)] = 2;
        DP[1][command.get(0)][0] = 2;

        for(int i = 1 ; i < len ; i++) {
            for(int j = 0 ; j <= 4 ; j++) {
                for(int k = 0 ; k <= 4 ; k++) {
                    if(DP[i][j][k] != Integer.MAX_VALUE) {
                        next = command.get(i);
                        if(k != next) {
                            DP[i+1][next][k] = Math.min(DP[i+1][next][k], DP[i][j][k] + getCost(j, next));
                        }
                        if(j != next) {
                            DP[i+1][j][next] = Math.min(DP[i+1][j][next], DP[i][j][k] + getCost(k, next));
                        }
                    }
                }
            }
        }
        int answer=Integer.MAX_VALUE;
        for(int j = 0 ; j <= 4 ; j++) {
            for(int k = 0 ; k <= 4 ; k++) {
                answer = Math.min(answer, DP[len][j][k]);
            }
        }
        System.out.println(answer);
    }static int getCost (int from, int to){
        if(from == to) {
            return 1;
        } else if(from == 0) {
            return 2;
        } else if (Math.abs(from - to) == 2) {
            return 4;
        } else {
            return 3;
        }
    }
}