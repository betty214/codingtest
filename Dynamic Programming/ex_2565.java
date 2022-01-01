package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ex_2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] DP = new int[N];
        int[][] elec = new int[N][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            elec[i][0] = Integer.parseInt(st.nextToken());
            elec[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(elec, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Arrays.fill(DP,1);

        for(int i = 0; i < DP.length; i++) {
            for(int j = 0; j < i; j++) {
                if(elec[i][1] > elec[j][1]) {
                    DP[i] = Math.max(DP[i], DP[j] + 1);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < N; i++) {
            if(max<DP[i]){
                max=DP[i];
            }
        }
        System.out.println(N - max);
    }
}
