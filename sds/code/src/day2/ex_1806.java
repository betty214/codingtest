package day2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_1806 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day2/1806.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int [] arr=new int[N+1];
        int low = 0, high = 0, ans = Integer.MAX_VALUE, len = 1;
        for(int i=0;i<N;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
        int sum = arr[0];
        while (true) {
            if (high == N)
                break;
            if (sum <= M) {
                if (sum == M)
                    ans = Math.min(ans, len);
                sum += arr[++high];
                len++;
            } else {
                sum -= arr[low++];
                ans = Math.min(ans, len--);
            }
        }

        if(ans==Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(ans);

    }
}
