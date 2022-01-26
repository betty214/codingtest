package day8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ex_2759 {
    static int[]stair,DP;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day8/2759.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        stair=new int[n];
        DP=new int[n];
        Arrays.fill(DP,-1);
        for(int i=0;i<n;i++){
            stair[i]= Integer.parseInt(br.readLine());
        }
        DP[0]=stair[0];
        if(n>1) {
            DP[1]=stair[0]+stair[1];
        }if(n>2){
            DP[2]=Math.max(stair[2]+stair[1],stair[0]+stair[2]);
        }
        up(n-1);
        System.out.println(DP[n-1]);
    }public static int up(int index) {
        if (DP[index]==-1){
            DP[index]=Math.max(up(index-2),up(index-3)+stair[index-1])+stair[index];
        }
        return DP[index];
    }
}
