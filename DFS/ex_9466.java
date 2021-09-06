package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class ex_9466 {
    static int[] student;
    static boolean[]visited;
    static Stack<Integer> stack;
    static int answer;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            student = new int[N + 1];
            visited = new boolean[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                stack = new Stack<>();
                student[j] = Integer.parseInt(st.nextToken());
            }
            answer = N;
            for (int j = 1; j <= N; j++) {
                stack.clear();
                stack.push(j);
                DFS(j, student[j]);
            }
            System.out.println(answer);
        }
    }

    static void DFS(int start, int end) {
        if (start == end) {
            while(!stack.isEmpty()){
                int now=stack.pop();
                if(!visited[now]){
                    visited[now]=true;
                    answer--;
                }
            }
        }else if(start == student[end]){
            if(!visited[start]){
                visited[start]=true;
                answer--;
            }if(!visited[end]){
                visited[end]=true;
                answer--;
            }
        } else if (end == student[end]) {
            if(!visited[end]){
                visited[end]=true;
                answer--;
            }
        } else {
            stack.push(student[start]);
            stack.push(student[end]);
            DFS(start, student[student[end]]);
        }
    }
}
