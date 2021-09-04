package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ex_9935 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        String bomb=br.readLine();
        while(str.contains(bomb)){
            str=str.replaceAll(bomb,"");
        }
        if(str==""){
            System.out.println("FRULA");
        }else{
            System.out.println(str);
        }
    }
}
