package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_21609 {
    static int N,M;
    static int[][] block;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/21609.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        block=new int[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                block[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        findBlock();

        //그룹을 선택하여 블록을 비우고 점수 획득하는 함수
        //90도 뒤집는 함수
        //중력 적용 함수
    }
    //블록 그룹 찾는 함수
    static void findBlock(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){

            }
        }
    }
}
