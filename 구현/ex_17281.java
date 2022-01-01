package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_17281 {
    static int[][] player;
    static int[] order;
    static int now_index, answer, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        player = new int[N][9];
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        boolean[] visited = new boolean[arr.length];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                player[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        now_index = 0;
        answer = 0;
        permutation(arr, 0, 8, 8);
        System.out.println(answer);
    }

    static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            order = new int[9];
            order[3] = 0;
            int now_answer = 0;
            int idx = 0;
            for (int i = 0; i < 8; i++) {
                if (idx == 3) {
                    idx++;
                    i--;
                    continue;
                }
                order[idx++] = arr[i];
            }
            now_index = 0;
            for (int i = 0; i < N; i++) {
                now_answer += innings(i, order);
            }
            if (now_answer > answer) {
                answer = now_answer;
            }
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    static int innings(int inning, int[] order) {
        int out = 0;
        int score = 0;
        int runner = 0;
        int[] base = new int[3];
        int max_base=-1;
        while (out < 3) {
            if (now_index > 8) {
                now_index = 0;
            }
            int now_score = player[inning][order[now_index]];
            int hit = 0;
            if (now_score == 0) {
                out++;
            } else if (now_score < 4) {
                hit=now_score;
            } else {
                score += runner + 1;
                runner = 0;
                for(int i=0;i<3;i++){
                    base[i]=0;
                }max_base=-1;
            }
            if (hit > 0) {
                runner++;
                if(max_base<=hit-1 ||base[hit-1]==1){
                    for (int i = 2; i >= 0; i--) {
                        if (base[i] == 1) {
                            if (i + hit > 2) {
                                score++;
                                runner--;
                            } else {
                                base[i + hit] = 1;
                                if(i+hit>max_base){
                                    max_base=i+hit;
                                }
                            }
                            base[i] = 0;
                        }
                    }
                }
                base[hit - 1] = 1;
                if(hit-1>max_base){
                    max_base=hit-1;
                }
            }
            now_index++;
        }
        return score;
    }
}
