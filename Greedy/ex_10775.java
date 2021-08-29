package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_10775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G=Integer.parseInt(br.readLine());
        int P=Integer.parseInt(br.readLine());
        int plane[]=new int[P];
        int gate[]=new int[G];
        for(int i=0;i<P;i++){
            plane[i]=Integer.parseInt(br.readLine());
        }
        int flag=0;
        int answer=0;
        for(int i=0;i<P;i++) {
            for(int j=plane[i];j>0;j--){
                if(gate[j-1]==0){
                    gate[j-1]=i+1;
                    answer++;
                    flag=1;
                    break;
                }
            }if(flag==0){
                break;
            }else{
                flag=0;
            }
        }
        System.out.println(answer);
    }
}
