package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[]arr=new int[N+1];
        int[]left=new int[N+1];
        int[]right=new int[N+1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            left[i]=1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && left[i]<left[j]+1){
                    left[i]=left[j]+1;
                }
            }
        }
        for(int i=N-1;i>=0;i--){
            right[i]=1;
            for(int j=N-1;j>i;j--){
                if(arr[i]>arr[j] && right[i]<right[j]+1){
                    right[i]=right[j]+1;
                }
            }
        }int ans=Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            ans=Math.max(ans,left[i]+right[i]);
        }
        System.out.println(ans-1);
    }
}
