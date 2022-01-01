package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ex_14002 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[]DP=new int[N+1];
        int[]arr=new int[N+1];
        int[]back=new int[N+1];
        int result=0;
        int resultIdx=0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            DP[i]=1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && DP[j]+1>DP[i]) {
                    DP[i]=DP[j]+1;
                    back[i]=j;
                }
            }
            if(DP[i]>result) {
                result = DP[i];
                resultIdx=i;
            }
        }

        int[] answer = new int[result];
        int index = resultIdx;

        for(int i = result - 1; i >= 0; i--) {
            answer[i] = arr[index];
            index = back[index];
        }
        System.out.println(result);
        for(int i = 0; i < result; i++) {
            System.out.print(answer[i]+" ");
        }
    }
}
