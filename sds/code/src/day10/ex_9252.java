package day10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_9252 {
    public static void main(String[] args)  throws IOException {
        System.setIn(new FileInputStream("code/src/day10/9252.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first=br.readLine();
        String second=br.readLine();
        char[][]back=new char[first.length()+1][second.length()+1];
        int[][]DP=new int[first.length()+1][second.length()+1];
        for(int i=1;i<=first.length();i++){
            for(int j=1;j<=second.length();j++){
                if(first.charAt(i-1)==second.charAt(j-1)){
                    DP[i][j]=DP[i-1][j-1]+1;
                    back[i][j]='c';
                }else{
                    if(DP[i-1][j]>=DP[i][j-1]){
                        back[i][j]='u';
                        DP[i][j]=DP[i-1][j];
                    }else{
                        back[i][j]='l';
                        DP[i][j]=DP[i][j-1];
                    }
                }
            }
        }
        int x=first.length();
        int y=second.length();
        System.out.println(DP[x][y]);
        String answer="";
        while(x>0 && y>0){
            if(back[x][y] == 'u') {
                x--;
            }else if(back[x][y] == 'l') {
                y--;
            }else if(back[x][y]=='c'){
                answer=first.charAt(x-1)+answer;
                x--;
                y--;
            }
        }
        System.out.println(answer);
    }
}
