package intern_2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_2 {
    static String[]places;
    static int[] dx_1={0,0,1,-1};
    static int[] dy_1={1,-1,0,0};
    static int[] dx_2={1,1,-1,-1};
    static int[] dy_2={1,-1,1,-1};
    static int[] dx_3={2,-2,0,0};
    static int[] dy_3={0,0,2,-2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        places=new String[5];
        for(int i=0;i<5;i++){
            places[i]=br.readLine();
        }
        System.out.println(check());
    }static boolean check(){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(places[i].charAt(j)=='P'){
                    for(int k=0;k<4;k++){
                        if(range(i+dx_1[k],j+dy_1[k])) {
                            if (places[i + dx_1[k]].charAt(j + dy_1[k]) == 'P') {
                                return false;
                            }
                        }if(range(i+dx_2[k],j+dy_2[k])){
                            if(places[i+dx_2[k]].charAt(j+dy_2[k])=='P'){
                                if(places[i+dx_2[k]].charAt(j)!='X'||places[i].charAt(j+dy_2[k])!='X'){
                                    return false;
                                }
                            }
                        }if(range(i+dx_3[k],j+dy_3[k])){
                            if(places[i+dx_3[k]].charAt(j+dy_3[k])=='P'){
                                if(dx_3[k]!=0){
                                    if(dx_3[k]>0){
                                        if(places[i+1].charAt(j)!='X'){
                                            return false;
                                        }
                                    }else{
                                        if(places[i-1].charAt(j)!='X'){
                                            return false;
                                        }
                                    }
                                }else{
                                    if(dy_3[k]>0){
                                        if(places[i].charAt(j+1)!='X'){
                                            return false;
                                        }
                                    }else{
                                        if(places[i].charAt(j-1)!='X'){
                                            return false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }static boolean range(int x,int y){
        if(x>=5||y>=5||x<0||y<0){
            return false;
        }return true;
    }
}
