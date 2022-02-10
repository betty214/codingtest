package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_9663 {
    static int N,answer;
    static int []arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/input/9663.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr=new int[N];
        answer=0;
        dfs(0);
        System.out.println(answer);
    }static void dfs(int depth){
        if(depth==N) {
            answer++;
            return;
        }
        for(int i=0;i<N;i++){
            arr[depth]=i;
            if(check(depth)) dfs(depth+1);
        }
    }static boolean check(int d){
        for(int i=0;i<d;i++){
            if(arr[d]==arr[i]) return false;//세로
            else if(Math.abs(d-i)==Math.abs(arr[d]-arr[i])) return false;//대각선
        }
        return true;
    }
}
