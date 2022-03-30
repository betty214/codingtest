package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class crypto_1 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/crypto_1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[]alpha=new int[26];
        for(int i=0;i<5;i++){
            String now = br.readLine();
            for(int j=0;j<now.length();j++){
                alpha[now.charAt(j)-'A']++;
            }
        }
        for(int i=0;i<26;i++){
            System.out.print(alpha[i]+" ");
        }
    }
}
