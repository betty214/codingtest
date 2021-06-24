package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도둑질 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] money = new int[N];
        int [] DP = new int[N];
        int [] flag = new int[N];
        flag[0]=1;
        int answer = 0;
        if(N==3){
            int temp=Math.max(money[0],money[1]);
            answer=Math.max(temp,money[2]);
            System.out.println(answer);
        }
        for(int i=0;i<N;i++) {
           if(i==0) {
              DP[i]=money[i];
           }else if(i==1){
                   DP[i]=money[i];
            }else if(i==2) {
              DP[i]=money[i]+money[i-2];
                if(DP[0]!=0){
                    flag[i]=1;
                }
           }else {
              if(DP[i-2]<DP[i-3]) {
                 DP[i]=DP[i-3]+money[i];
                 if(flag[i-3]==1) {
                    flag[i]=1;
                 }
              }else {
                 DP[i]=DP[i-2]+money[i];
                 if(flag[i-2]==1) {
                    flag[i]=1;
                 }
              }
           }
        }
       
        
        if(flag[N-1]==1) {
            int temp=Math.max(DP[N-1]-money[0],DP[N-2]);
           answer=Math.max(temp, DP[N-3]);
        }else {
           answer=Math.max(DP[N-2], DP[N-1]);
        }
        System.out.println(answer);
	}
}
