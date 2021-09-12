package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ex_2251 {
    static int A,B,C;
    public static void main(String[] args) throws IOException {
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> answer = new HashSet<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A= Integer.parseInt(st.nextToken());
        B= Integer.parseInt(st.nextToken());
        C= Integer.parseInt(st.nextToken());
        boolean[][][] visit = new boolean[A + 1][B + 1][C + 1];
        visit[0][0][C] = true;
        answer.add(C);
        q.add(new int[] { 0, 0, C });

        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == 0) {
                answer.add(now[2]);
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j)
                        continue;
                    int[] next = BFS(now, i, j);
                    if (!visit[next[0]][next[1]][next[2]]) {
                        visit[next[0]][next[1]][next[2]] = true;
                        q.add(next);
                    }
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>(answer);
        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        for (Integer i : ans) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
    static int[] BFS(int[] now, int i, int j) {
        int input;
        if(j==0){
            input=A;
        }else if(j==1){
            input=B;
        }else{
            input=C;
        }
        if (now[i] == 0 || now[j] == input) {
            return now;
        }

        // from i to j;
        int[] next = now.clone();
        int tmp = input - next[j];
        if (next[i] > tmp) {
            next[j] += tmp;
            next[i] -= tmp;
        } else {
            next[j] += next[i];
            next[i] = 0;
        }

        return next;
    }
}
