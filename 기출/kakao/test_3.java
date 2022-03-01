package kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class test_3 {
    static int k,n;
    static boolean []almond;
    static ArrayList<Integer> del_index;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        String[]cmd=new String[11];
        almond=new boolean[n];
        del_index=new ArrayList<>();
        Arrays.fill(almond,true);
        for(int i=0;i<11;i++){
            cmd[i]=br.readLine();
        }
        for(int i=0;i<11;i++){
            System.out.println(cmd[i]+" "+k);
            if(cmd[i].charAt(0)=='U'){
                up_down(0,cmd[i].charAt(2)-'0');
            }else if(cmd[i].charAt(0)=='D'){
                up_down(1,cmd[i].charAt(2)-'0');
            }else if(cmd[i].charAt(0)=='C'){
                can();
            }else{
                recover();
            }
        }StringBuffer result=new StringBuffer("");
        for(int i=0;i<n;i++){
            if(almond[i]){
                result.append("O");
            }else{
                result.append("X");
            }
        }
        System.out.println(result.toString());
    }static void up_down(int what,int now){
        int move=0;
        while(move!=now){
            if(what==0){
                k--;
            }else{
                k++;
            }
            if(almond[k]){
                move++;
            }
        }
    }static void can(){
        almond[k]=false;
        del_index.add(k);
        if(k==n-1){
            k--;
        }else{
            k++;
        }
    }static void recover(){
        int size=del_index.size();
        int index=del_index.get(size-1);
        del_index.remove(size-1);
        almond[index]=true;
    }
}
