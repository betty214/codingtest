package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][]arr = new int[N][3];
        int[] maxDp = new int[3];
        int[] minDp = new int[3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int now = Integer.parseInt(st.nextToken());
                arr[i][j] = now;
            }
            if (i == 0) {
                maxDp[0] = minDp[0] = arr[i][0];
                maxDp[1] = minDp[1] = arr[i][1];
                maxDp[2] = minDp[2] = arr[i][2];
            } else {
                int tempMax0 = maxDp[0];
                int tempMax2 = maxDp[2];
                maxDp[0] = Math.max(maxDp[0], maxDp[1]) + arr[i][0];
                maxDp[2] = Math.max(maxDp[1], maxDp[2]) + arr[i][2];
                maxDp[1] = Math.max(Math.max(tempMax0, maxDp[1]), tempMax2) + arr[i][1];

                int tempMin0 = minDp[0];
                int tempMin2 = minDp[2];
                minDp[0] = Math.min(minDp[0], minDp[1]) + arr[i][0];
                minDp[2] = Math.min(minDp[1], minDp[2]) + arr[i][2];
                minDp[1] = Math.min(Math.min(tempMin0, minDp[1]), tempMin2) + arr[i][1];
            }
        }
        System.out.println(Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2]))+" "+Math.min(minDp[0], Math.min(minDp[1], minDp[2])));
    }
}
