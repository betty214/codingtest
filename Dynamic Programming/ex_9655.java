package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if((N/3)%2==0){
            if(N%3==0){
                System.out.println("CY");
            }else if(N%3==1){
                System.out.println("SK");
            }else {
                System.out.println("CY");
            }
        }else{
            if(N%3==0){
                System.out.println("SK");
            }else if(N%3==1){
                System.out.println("CY");
            }else {
                System.out.println("SK");
            }
        }
    }
}
