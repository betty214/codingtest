package kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//숫자 문자열과 영단어
public class test_1 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuffer result = new StringBuffer("");
        int start_eng=-1;
        int end_eng=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)-'0'>=0&&s.charAt(i)-'0'<10){
                if(start_eng!=-1){
                    result.append(toNumber(s.substring(start_eng,end_eng+1)));
                    start_eng=-1;
                    end_eng=-1;
                }result.append(s.charAt(i));
            }else{
                if(start_eng==-1){
                    start_eng=i;
                }else{
                    end_eng=i;
                }
            }
        }if(start_eng!=-1){
            result.append(toNumber(s.substring(start_eng,end_eng+1)));
        }
        System.out.println(result);
    }static String toNumber(String s){
        StringBuffer answer=new StringBuffer("");
        if(s.length()<6){
            return convert(s);
        }else{
            while(s.length()>5){
                int index=slice(s);
                answer.append(convert(s.substring(0,index)));
                s=s.substring(index,s.length());
            }
            answer.append(convert(s));
        }
        return answer.toString();
    }static int slice(String s){
        switch(s.charAt(0)){
            case 'z':
                return 4;
            case 'o':
                return 3;
            case 't':
                if(s.charAt(1)=='w'){
                    return 3;
                }else{
                    return 5;
                }
            case 'f':
                if(s.charAt(1)=='o'){
                    return 4;
                }else{
                    return 4;
                }
            case 's':
                if(s.charAt(1)=='i'){
                    return 3;
                }else{
                    return 5;
                }
            case 'e':
                return 5;
            case 'n':
                return 4;
        }return 0;
    }
    static String convert(String s){
        switch(s.charAt(0)){
            case 'z':
                return "0";
            case 'o':
                return "1";
            case 't':
                if(s.charAt(1)=='w'){
                    return "2";
                }else{
                    return "3";
                }
            case 'f':
                if(s.charAt(1)=='o'){
                    return "4";
                }else{
                    return "5";
                }
            case 's':
                if(s.charAt(1)=='i'){
                    return "6";
                }else{
                    return "7";
                }
            case 'e':
                return "8";
            case 'n':
                return "9";
        }
        return "";
    }
}
