package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_1039 {
    static int len,K,answer;
    static String N;
    static int [][]visited;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/input/1039.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = st.nextToken();
        K =Integer.parseInt(st.nextToken());
        len=N.length();
        visited=new int[K+1][1000001];
        answer=-1;
        answer=dfs(N,0);
        System.out.println(answer);
    }static int dfs(String sample, int depth) {
        int num = Integer.parseInt(sample);
        if (depth==K) return num;
        int now = visited[depth][num];
        if(now!=0) return now;
        now = -1;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if (i==0 && sample.charAt(j)=='0') continue;
                String temp = swapLoc(sample,i,j);
                int next = dfs(temp, depth+1);
                now = Math.max(next,now);
            }
        }
        visited[depth][num] = now;
        return now;
    }static String swapLoc(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
        return String.valueOf(chars);
    }
}
