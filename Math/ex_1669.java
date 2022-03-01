package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_1669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int X=Integer.parseInt(st.nextToken());
        int Y=Integer.parseInt(st.nextToken());
        if(Y-X<3){
            System.out.println(Y-X);
        }else {
            int sq=(int)Math.sqrt(Y-X);
            int temp=Y-X-sq*sq;
            if(temp==0){
                System.out.println(sq*2-1);
            }else if(temp<=sq){
                System.out.println(sq*2);
            }else{
                System.out.println(sq*2+1);
            }
        }
    }
}
