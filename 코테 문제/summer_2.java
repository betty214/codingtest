import java.util.*;
class Solution {
    public int solution(int sticker[]) {
        int len = sticker.length;
        int []DP = new int [len];
        DP[0]=sticker[0]-sticker[len-1];
        if(len>1){
            DP[1]=Math.max(DP[0],sticker[1]);
            if(len>2){
                if(len==3){
                    int max= Math.max(sticker[0],sticker[1]);
                    DP[2]=Math.max(sticker[2],max);
                }else{
                    DP[2]=Math.max(sticker[1],sticker[2]+DP[0]);
                    for(int i=3;i<len;i++){
                        int max=Math.max(DP[i-2],DP[i-3])+sticker[i];
                        DP[i]=Math.max(max,DP[i-1]);
                    }
                }
            }else{
                DP[len-1]=Math.max(sticker[0],sticker[1]);
            }
        }else{
            DP[len-1]=sticker[0];
        }
        return DP[len-1];
    }
}