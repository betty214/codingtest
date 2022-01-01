package backjun;

import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ex_5373 {
    static ArrayList<char[][]> cube;
    static char[] color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        color = new char[]{'w', 'y', 'r', 'o', 'g', 'b'};
        cube = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            cube.add(fill(color[i]));
        }
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                String dir = st.nextToken();
                turn(dir);
            }
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    System.out.print(cube.get(0)[k][l] + " ");
                }
                System.out.println();
            }
            reCube();
        }

    }

    static char[][] fill(char c) {
        char[][] space = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                space[i][j] = c;
            }
        }
        return space;
    }

    static void turn(String dir) {
        char pos = dir.charAt(0);
        char sig = dir.charAt(1);
        int switch_num=-1;
        if(pos=='U'||pos=='D'){
            switch_num=0;
        }else if(pos=='L'||pos=='R'){
            switch_num=1;
        }else if(pos=='F'||pos=='B'){
            switch_num=2;
        }
        int index=0;
        switch (switch_num) {
            case 0:
                if(pos=='D') index=2;
                if((pos=='U'&&sig=='+') || (pos=='D'&&sig=='-')){
                    char[][] temp = cube.get(2);
                    char[][] temp2 = cube.get(3);
                    char[][] temp3 = cube.get(5);
                    for (int i = 0; i < 3; i++) {
                        cube.get(3)[index][i] = cube.get(4)[index][i];
                        cube.get(4)[index][i] = temp[index][i];
                        cube.get(2)[index][i] = temp3[index][i];
                        cube.get(5)[index][i] = temp2[index][i];
                    }
                }
                if ((pos=='U'&&sig=='-') || (pos=='D'&&sig=='+')) {
                    char[][] temp = cube.get(3);
                    char[][] temp2 = cube.get(4);
                    char[][] temp3 = cube.get(2);
                    for (int i = 0; i < 3; i++) {
                        cube.get(3)[index][i] = cube.get(5)[index][i];
                        cube.get(5)[index][i] = temp3[index][i];
                        cube.get(2)[index][i] = temp2[index][i];
                        cube.get(4)[index][i] = temp[index][i];
                    }
                }
                break;
            case 1:
                if(pos=='R') index=2;
                if((pos=='L'&&sig=='+') || (pos=='R'&&sig=='-')){
                    char[][] temp = cube.get(1);
                    char[][] temp2 = cube.get(3);
                    char[][] temp3 = cube.get(0);
                    for (int i = 0; i < 3; i++) {
                        cube.get(1)[i][index] = cube.get(2)[i][index];
                        cube.get(2)[i][index] = temp3[i][index];
                        cube.get(0)[i][index] = temp2[i][index];
                        cube.get(3)[i][index] = temp[i][index];
                    }
                }
                if((pos=='L'&&sig=='-') || (pos=='R'&&sig=='+')){
                    char[][] temp = cube.get(1);
                    char[][] temp2 = cube.get(2);
                    char[][] temp3 = cube.get(0);
                    for (int i = 0; i < 3; i++) {
                        cube.get(1)[i][index] = cube.get(3)[i][index];
                        cube.get(3)[i][index] = temp3[i][index];
                        cube.get(0)[i][index] = temp2[i][index];
                        cube.get(2)[i][index] = temp[i][index];
                    }
                }
                break;
            case 2:
                if(pos=='B') index=2;
                if(pos=='F'&&sig=='+'){
                    char[][]temp = cube.get(1);
                    char[][]temp2 = cube.get(4);
                    char[][]temp3 = cube.get(0);
                    for (int i = 0; i < 3; i++) {
                        cube.get(1)[2][i]=cube.get(5)[0][i];
                        cube.get(4)[i][2]=temp[2][i];
                        cube.get(0)[2][i]=temp2[0][2-i];
                        //cube.get(4)
                    }
                }
                break;
        }
    }

    static void reCube() {
        cube.clear();
        for (int i = 0; i < 6; i++) {
            cube.add(fill(color[i]));
        }
    }

}
