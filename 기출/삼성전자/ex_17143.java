package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class ex_17143 {
    static int R, C, M, answer;
    static Shark[][] sea,temp;

    private static class Shark {
        int speed;
        int direction;
        int size;

        Shark(int speed, int direction, int size) {
            this.speed = speed;
            this.direction = direction;
            this.size = size;
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "speed=" + speed +
                    ", direction=" + direction +
                    ", size=" + size +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/17143.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sea = new Shark[R+1][C+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            sea[r][c]=new Shark(s, d, z);
        }
        answer = 0;
        for (int i = 1; i <= C; i++) {
            getShark(i);
            moveShark();
        }
        System.out.println(answer);
    }

    static void getShark(int y) {
        for(int x=1;x<=R;x++){
            if(sea[x][y]!=null){
                answer += sea[x][y].size;
                sea[x][y]=null;
                break;
            }
        }
    }

    static void moveShark() {
        temp = new Shark[R+1][C+1];
        for(int i=1;i<=R;i++){
            for(int j=1;j<=C;j++){
                if(sea[i][j]==null) continue;

                int count = sea[i][j].speed;
                int nowX = i;
                int nowY = j;
                int nowDir = sea[i][j].direction;
                int nowSize = sea[i][j].size;

                while (count > 0) {
                    switch (nowDir) {
                        case 1:
                            nowX--;
                            break;
                        case 2:
                            nowX++;
                            break;
                        case 3:
                            nowY++;
                            break;
                        case 4:
                            nowY--;
                            break;
                    }
                    if (nowX < 1 && nowDir == 1) {
                        nowDir = 2;
                        nowX=2;
                    }
                    if (nowX > R && nowDir == 2) {
                        nowDir = 1;
                        nowX=R-1;
                    }
                    if (nowY > C && nowDir == 3) {
                        nowDir = 4;
                        nowY=C-1;
                    }
                    if (nowY < 1 && nowDir == 4) {
                        nowDir = 3;
                        nowY=2;
                    }
                    count--;
                }

                if (temp[nowX][nowY] == null) {
                    temp[nowX][nowY] = new Shark(sea[i][j].speed, nowDir, nowSize);
                } else {
                    if (temp[nowX][nowY].size < nowSize) {
                        temp[nowX][nowY] = new Shark(sea[i][j].speed, nowDir, nowSize);
                    }
                }
            }
        }
        copy();
    }static void print() {
        for (int i = 1; i <= R; i++) {
            for(int j=1;j<=C;j++){
                System.out.print(sea[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static void copy(){
        sea = new Shark[R+1][C+1];
        for (int i = 1; i <= R; i++) {
            for(int j=1;j<=C;j++){
                sea[i][j]=temp[i][j];
            }
        }
    }
}
