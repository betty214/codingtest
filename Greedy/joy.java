import java.util.Arrays;
class Solution {
    public int solution(String name) {
        char[]temp=name.toCharArray();
        int sum=0;
        int move=temp.length-1;
        for(int i=0;i<temp.length;i++){
            int front = (int)(temp[i]-'A');
            int back = (int)('Z'-temp[i]+1);
            sum+=Math.min(front,back);
            move=Math.min(move, i+1)
        }
        int answer = sum;
        return answer;
    }
}