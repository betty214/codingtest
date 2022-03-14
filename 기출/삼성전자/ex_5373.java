package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_5373 {
    static char [][][]cube;
    static char[]color={'w','y','r','o','g','b'};
    public static void main(String[] args)throws IOException {
        System.setIn(new FileInputStream("input/5373.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        cube=new char[6][3][3];

        for(int i=0;i<T;i++){
            init();

            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0;j<N;j++){
                String input = st.nextToken();
                turn(input.charAt(0), input.charAt(1));
            }
            print();
        }


    }static void turn(char pos, char dir){
        switch(pos){
            case 'U':
                if(dir=='-'){
                    char[]temp=cube[5][0].clone();
                    cube[5][0]=cube[2][0].clone(); //F->R
                    char[]temp2=cube[3][0].clone();
                    cube[3][0]=temp.clone(); //R->B
                    char[]temp3=cube[4][0].clone();
                    cube[4][0]=temp2.clone(); //B->L
                    cube[2][0]=temp3.clone(); //L->F
                }else{
                    char[]temp=cube[4][0].clone();
                    cube[4][0]=cube[2][0].clone(); //F->L
                    char[]temp2=cube[3][0].clone();
                    cube[3][0]=temp.clone(); //L->B
                    char[]temp3=cube[5][0].clone();
                    cube[5][0]=temp2.clone(); //B->R
                    cube[2][0]=temp3.clone(); //R->F
                }
                break;
            case 'D':
                if(dir=='-'){
                    char[]temp=cube[4][2].clone();
                    cube[4][2]=cube[2][2].clone();
                    char[]temp2=cube[3][2].clone();
                    cube[3][2]=temp.clone();
                    char[]temp3=cube[5][2].clone();
                    cube[5][2]=temp2.clone();
                    cube[2][2]=temp3.clone();
                }else{
                    char[]temp=cube[5][2].clone();
                    cube[5][2]=cube[2][2].clone();
                    char[]temp2=cube[3][2].clone();
                    cube[3][2]=temp.clone();
                    char[]temp3=cube[4][2].clone();
                    cube[4][2]=temp2.clone();
                    cube[2][2]=temp3.clone();
                }
                break;
            case 'L':
                if(dir=='-'){
                    char[]temp={cube[3][0][2],cube[3][1][2],cube[3][2][2]};
                    cube[3][0][2]=cube[0][2][0]; cube[3][1][2]=cube[0][1][0]; cube[3][2][2]=cube[0][0][0];
                    char[]temp2={cube[1][0][2],cube[1][1][2],cube[1][2][2]};
                    cube[1][0][2]=temp[0]; cube[1][1][2]=temp[1]; cube[1][2][2]=temp[2];
                    char[]temp3={cube[2][0][0],cube[2][1][0],cube[2][2][0]};
                    cube[2][0][0]=temp2[2]; cube[2][1][0]=temp2[1]; cube[2][2][0]=temp2[0];
                    cube[0][0][0]=temp3[0]; cube[0][1][0]=temp3[1]; cube[0][2][0]=temp3[2];
                }else{
                    char[]temp={cube[2][0][0],cube[2][1][0],cube[2][2][0]};
                    cube[2][0][0]=cube[0][0][0]; cube[2][1][0]=cube[0][1][0]; cube[2][2][0]=cube[0][2][0];
                    char[]temp2={cube[1][0][2],cube[1][1][2],cube[1][2][2]};
                    cube[1][0][2]=temp[0]; cube[1][1][2]=temp[1]; cube[1][2][2]=temp[2];
                    char[]temp3={cube[3][0][2],cube[3][1][2],cube[3][2][2]};
                    cube[3][0][2]=temp2[0]; cube[3][1][2]=temp2[1]; cube[3][2][2]=temp2[2];
                    cube[0][0][0]=temp3[2]; cube[0][1][0]=temp3[1]; cube[0][2][0]=temp3[0];
                }
                break;
            case 'R':
                if(dir=='-'){
                    char[]temp={cube[2][0][2],cube[2][1][2],cube[2][2][2]};
                    cube[2][0][2]=cube[0][0][2]; cube[2][1][2]=cube[0][1][2]; cube[2][2][2]=cube[0][2][2];
                    char[]temp2={cube[1][0][0],cube[1][1][0],cube[1][2][0]};
                    cube[1][0][0]=temp[2]; cube[1][1][0]=temp[1]; cube[1][2][0]=temp[0];
                    char[]temp3={cube[3][0][0],cube[3][1][0],cube[3][2][0]};
                    cube[3][0][0]=temp2[0]; cube[3][1][0]=temp2[1]; cube[3][2][0]=temp2[2];
                    cube[0][0][2]=temp3[2]; cube[0][1][2]=temp3[1]; cube[0][2][2]=temp3[0];
                }else{
                    char[]temp={cube[3][0][0],cube[3][1][0],cube[3][2][0]};
                    cube[3][0][0]=cube[0][2][2]; cube[3][1][0]=cube[0][1][2]; cube[3][2][0]=cube[0][0][2];
                    char[]temp2={cube[1][0][0],cube[1][1][0],cube[1][2][0]};
                    cube[1][0][0]=temp[0]; cube[1][1][0]=temp[1]; cube[1][2][0]=temp[2];
                    char[]temp3={cube[2][0][2],cube[2][1][2],cube[2][2][2]};
                    cube[2][0][2]=temp2[2]; cube[2][1][2]=temp2[1]; cube[2][2][2]=temp2[0];
                    cube[0][0][2]=temp3[0]; cube[0][1][2]=temp3[1]; cube[0][2][2]=temp3[2];
                }
                break;
        }
    }static void init(){
        for(int i=0;i<6;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    cube[i][j][k]=color[i];
                }
            }
        }
    }static void print(){
        for(int i=0;i<6;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    System.out.print(cube[i][j][k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
