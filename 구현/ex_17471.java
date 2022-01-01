package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex_17471 {
    static int N,answer;
    static boolean []entered;
    static ArrayList<Integer>[] link;
    static int[] people;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        link = new ArrayList[N+1];
        entered=new boolean[N+1];
        people=new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            people[i] = Integer.parseInt(st.nextToken());
            link[i]=new ArrayList<>();
        }
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j=0;j<num;j++){
                int now = Integer.parseInt(st.nextToken());
                link[i].add(now);
            }
        }
        answer=Integer.MAX_VALUE;
        selectA(1);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
    static void selectA(int idx) {
        if (idx == N + 1) {
            if (check()) {
                int sumA = 0, sumB = 0;
                for (int i = 1; i <= N; i++) {
                    if (entered[i]) sumA += people[i];
                    else sumB += people[i];
                }

                answer = Math.min(answer, Math.abs(sumA - sumB));
            }

            return;
        }
        entered[idx] = true;
        selectA(idx + 1);
        entered[idx] = false;
        selectA(idx + 1);

    }
    static boolean check() {
        boolean[] visited = new boolean[N + 1];

        int areaA = -1;
        for (int i = 1; i <= N; i++) {
            if (entered[i]) {
                areaA = i;
                break;
            }
        }
        int areaB = -1;
        for (int i = 1; i <= N; i++) {
            if (!entered[i]) {
                areaB = i;
                break;
            }
        }
        if (areaA == -1 || areaB == -1) return false;

        Queue<Integer> q = new LinkedList<>();
        q.add(areaA);
        visited[areaA] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < link[now].size(); i++) {
                if (visited[link[now].get(i)]) continue;
                if (!entered[link[now].get(i)]) continue;
                visited[link[now].get(i)] = true;
                q.add(link[now].get(i));
            }
        }
        q.add(areaB);
        visited[areaB] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < link[now].size(); i++) {
                if (visited[link[now].get(i)]) continue;
                if (entered[link[now].get(i)]) continue;
                visited[link[now].get(i)] = true;
                q.add(link[now].get(i));
            }
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i])
                return false;
        }

        return true;
    }

}
