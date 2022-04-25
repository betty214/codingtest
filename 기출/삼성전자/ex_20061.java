package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_20061 {
    static boolean [][]blue, green;
    static int score,block;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/20061.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        blue=new boolean[4][10];
        green = new boolean[10][4];
        score=0;block=0;

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            moveRight(t,x,y);
            moveDown(t,x,y);
            flag=true;
            while(flag){
                update();
                pull();
            }
        }
        //print();
        count();
        System.out.println(score);
        System.out.println(block);
    }static void update(){
        flag=false;
        for(int i=9;i>3;i--){
            if(blue[0][i] && blue[1][i] && blue[2][i] && blue[3][i]){
                for(int j=0;j<4;j++){
                    blue[j][i]=false;
                }
                score++;
                for(int j=i;j>3;j--){
                    for(int k=0;k<4;k++){
                        blue[k][j]=blue[k][j-1];
                    }
                }
                flag=true;
            }
            if(green[i][0] && green[i][1] && green[i][2] && green[i][3]){
                for(int j=0;j<4;j++){
                    green[i][j]=false;
                }
                score++;
                for(int j=i;j>3;j--){
                    for(int k=0;k<4;k++){
                        green[j][k]=green[j-1][k];
                    }
                }flag=true;
            }
        }
    }static void pull(){
        int blueF=0;
        int greenF=0;
        for(int i=4;i<6;i++){
            if(blue[0][i] || blue[1][i] || blue[2][i] || blue[3][i]) blueF++;
            if(green[i][0] || green[i][1] || green[i][2] || green[i][3]) greenF++;
        }
        for(int i=0;i<4;i++){
            for(int j=9;j>5;j--){
                blue[i][j]=blue[i][j-blueF];
                green[j][i]=green[j-greenF][i];
            }
        }
        for(int i=4;i<6;i++){
            for(int j=0;j<4;j++){
                blue[j][i]=false;
                green[i][j]=false;
            }
        }
    }static void moveRight(int t, int x, int y){
        switch(t){
            case 1:
                for(int i=y;i<10;i++){
                    if(blue[x][i]) {
                        blue[x][i-1]=true;
                        break;
                    }
                    if(i==9){
                        blue[x][9]=true;
                    }
                }
                break;
            case 2:
                for(int i=y;i<10;i++){
                    if(blue[x][i]) {
                        blue[x][i-1]=true;
                        blue[x][i-2]=true;
                        break;
                    }
                    if(i==9){
                        blue[x][9]=true;
                        blue[x][8]=true;
                    }
                }
                break;
            case 3:
                for(int i=y;i<10;i++){
                    if(blue[x][i] || blue[x+1][i]) {
                        blue[x][i-1]=true;
                        blue[x+1][i-1]=true;
                        break;
                    }
                    if(i==9){
                        blue[x][9]=true;
                        blue[x+1][9]=true;
                    }
                }
                break;
        }
    }static void moveDown(int t, int x, int y) {
        switch (t) {
            case 1:
                for (int i = x; i < 10; i++) {
                    if (green[i][y]) {
                        green[i-1][y] = true;
                        break;
                    }
                    if (i == 9) {
                        green[9][y] = true;
                    }
                }
                break;
            case 2:
                for (int i = x; i < 10; i++) {
                    if (green[i][y] || green[i][y+1]) {
                        green[i-1][y] = true;
                        green[i-1][y+1] = true;
                        break;
                    }
                    if (i == 9) {
                        green[9][y] = true;
                        green[9][y+1] = true;
                    }
                }
                break;
            case 3:
                for (int i = x; i < 9; i++) {
                    if (green[i+1][y]) {
                        green[i][y] = true;
                        green[i-1][y] = true;
                        break;
                    }
                    if (i == 8) {
                        green[9][y] = true;
                        green[8][y] = true;
                    }
                }
                break;
        }
    }static void print(){
        for(int i=0;i<4;i++){
            for(int j=0;j<10;j++){
                if(blue[i][j]) System.out.print("⬜ ");
                else System.out.print("⬛ ");
            }
            System.out.println();
        }
        for(int i=0;i<6;i++){
            for(int j=0;j<4;j++){
                if(green[i+4][j]) System.out.print("⬜ ");
                else System.out.print("⬛ ");
            }
            System.out.println();
        }
    }static void count(){
        for(int i=0;i<4;i++){
            for(int j=4;j<10;j++){
                if(blue[i][j]) block++;
                if(green[j][i]) block++;
            }
        }
    }
}
