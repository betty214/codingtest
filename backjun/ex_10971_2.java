package backjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
 
public class ex_10971_2 {
 
    static int n ;
    static int[][] arr;
    static long min = Integer.MAX_VALUE;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        visited = new boolean[n];
 
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i <n ; i++) {
            dfs(i,i,0,0);
        }
        System.out.println(min);
    }
    public static void dfs(int start, int i, int cnt, int sum){
        if(cnt == n && start == i){
            min = Math.min(min, sum);
            return;
        }
        for (int j = 0; j <n ; j++) {
            if(arr[i][j]==0){
                continue;
            }
 
            if(!visited[i] && arr[i][j] > 0){
                visited[i]=true;
                sum += arr[i][j];
                dfs(start, j, cnt +1, sum);
                visited[i] = false;
                sum -= arr[i][j];
            }
        }
    }
 
}
