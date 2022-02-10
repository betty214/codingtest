package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex_3425 {
    static ArrayList <String> command;
    static String[]name={"POP","INV","DUP","SWP","ADD","SUB","MUL","DIV","MOD"};
    static ArrayList<Integer>stack;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/input/3425.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String com =st.nextToken();
        while(!com.equals("QUIT")){
            command=new ArrayList<>();
            while(!com.equals("END")){
                if(com.equals("NUM")){
                    String X = st.nextToken();
                    command.add(X);
                }else command.add(com);
                st = new StringTokenizer(br.readLine());
                com=st.nextToken();
            }
            int n = Integer.parseInt(br.readLine());
            for(int i=0;i<n;i++){
                int input = Integer.parseInt(br.readLine());
                calc(input);
            }
            System.out.println();
            st = new StringTokenizer(br.readLine());
            st = new StringTokenizer(br.readLine());
            com =st.nextToken();
        }
    }static void calc(int input){
        stack=new ArrayList<>();
        stack.add(input);
        boolean flag=true;
        for(int i=0;i< command.size();i++){
            int now=Arrays.asList(name).indexOf(command.get(i));
            if(!check(stack)){
                if(stack.size()==0 && now>=0){
                    flag=false;
                    break;
                }else if(now>2){
                    flag=false;
                    break;
                }
            }
            switch(now){
                case -1: //NUM X
                    ArrayList<Integer>t=new ArrayList<>();
                    t.add(Integer.parseInt(command.get(i)));
                    t.addAll(stack);
                    stack.clear();
                    stack.addAll(t);
                    break;
                case 0: //POP
                    stack.remove(0);
                    break;
                case 1: //INV
                    stack.set(0,-stack.get(0));
                    break;
                case 2: //DUP
                    stack.add(stack.get(0));
                    break;
                case 3: //SWP
                    int temp=stack.get(0);
                    stack.set(0,stack.get(1));
                    stack.set(1,temp);
                    break;
                default:
                    flag=calc2(now,stack.get(0),stack.get(1));
                    break;
            }
            //System.out.println(stack);
            if(!flag) break;
        }

        if(flag && stack.size()==1 && Math.abs(stack.get(0))<=1000000000) System.out.println(stack.get(0));
        else System.out.println("ERROR");
    }static boolean calc2(int mod, int first, int second){
        boolean mfirst=false;
        boolean msecond=false;
        if(first<0){
            mfirst=true;
        }if(second<0){
            msecond=true;
        }
        BigInteger f=new BigInteger(Integer.toString(first));
        BigInteger s=new BigInteger(Integer.toString(second));
        BigInteger result=new BigInteger("0");
        if(mod>6 && first==0) return false;
        switch(mod){
            case 4:
                result=f.add(s);
                break;
            case 5:
                result=s.subtract(f);
                break;
            case 6:
                result=f.multiply(s);
                break;
            case 7:
                f=f.abs();
                s=s.abs();
                if(mfirst&&msecond) result=s.divide(f);
                else if(mfirst||msecond) result=s.divide(f).multiply(new BigInteger("-1"));
                else result=s.divide(f);
                break;
            case 8:
                f=f.abs();
                s=s.abs();
                if(msecond) result=s.mod(f).multiply(new BigInteger("-1"));
                else result=s.mod(f);
                break;
        }
        //System.out.println(mfirst+" "+msecond+" "+result);
        if(result.abs().compareTo(new BigInteger("1000000000"))==1) return false;
        else {
            stack.remove(0);
            stack.set(0,result.intValue());
            return true;
        }
    }
    static boolean check(ArrayList<Integer>stack) {
        if (stack.size() < 2) return false;
        return true;
    }
}
