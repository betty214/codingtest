package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ex_15685 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][]box;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        box=new boolean[101][101];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int direction=Integer.parseInt(st.nextToken());
            int generation=Integer.parseInt(st.nextToken());
            make_line(x,y,direction,generation);
        }
        int answer=0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (box[i][j] && box[i][j + 1] && box[i + 1][j] && box[i + 1][j + 1]) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
    static void make_line(int x,int y, int d, int g){
        ArrayList<Integer> d_list = new ArrayList<>();
        d_list.add(d);

        for (int i = 1; i <= g; i++) {
            for (int j = d_list.size() - 1; j >= 0; j--) {
                d_list.add((d_list.get(j) + 1) % 4);
            }
        }

        box[y][x] = true;
        for (Integer direction : d_list) {
            x += dx[direction];
            y += dy[direction];
            box[y][x] = true;
        }
    }
}
