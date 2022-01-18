package day1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_9663 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day1/9663.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N==1) System.out.println(1);
        else if(N<5) System.out.println(0);
        else{

        }
    }
}
