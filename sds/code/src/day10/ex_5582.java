package day10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_5582 {
    public static void main(String[] args)  throws IOException {
        System.setIn(new FileInputStream("code/src/day10/5582.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first=br.readLine();
        String second=br.readLine();
        int[][]DP=new int[first.length()+1][second.length()+1];
        int answer=0;
        for(int i=1;i<=first.length();i++){
            for(int j=1;j<=second.length();j++){
                if(first.charAt(i-1)==second.charAt(j-1)){
                    DP[i][j]=DP[i-1][j-1]+1;
                    answer=Math.max(DP[i][j],answer);
                }
            }
        }
        System.out.println(answer);
    }
}
