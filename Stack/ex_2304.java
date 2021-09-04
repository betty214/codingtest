package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ex_2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] box = new int[N][2];
        int max = 0;
        int max_index = -1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (y > max) {
                max = y;
                max_index = x;
            }
            box[i][0] = x;
            box[i][1] = y;
        }
        Arrays.sort(box, (o1, o2) -> {
            return Integer.compare(o1[0], o2[0]);
        });
        int test = box[0][1];
        boolean flag = false;
        int answer = 0;
        int maxL=0;
        for(int i=0; i<box.length; i++) {
            if(box[i][1] == max) {
                maxL = i;
                break;
            }
        }
        for(int i=0; i<maxL; i++) {
            for(int j=i+1; j<=maxL; j++) {
                if(box[i][1] <= box[j][1]) {
                    answer += (box[j][0]- box[i][0]) * box[i][1];
                    i = j;
                }
            }
        }

        for(int i=N-1; i>maxL; i--) {
            for(int j=i-1; j>=maxL; j--) {
                if(box[i][1]<= box[j][1]) {
                    answer += (box[i][0] - box[j][0]) * box[i][1];
                    i = j;
                }
            }
        }
        answer += max;
        System.out.println(answer);
    }
}
