import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map.Entry;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<phone_book.length;i++){
            int n = phone_book[i].length();
            map.put(phone_book[i],n);
        }
        ArrayList<Entry<String, Integer>> sortPhone = new ArrayList<Entry<String, Integer>>(map.entrySet());
      Collections.sort(sortPhone, new Comparator<Entry<String, Integer>>() {
         public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
            return obj1.getValue().compareTo(obj2.getValue());
         }
      });
        Loop1:
        for(int i=0;i<sortPhone.size();i++){
            int n = sortPhone.get(i).getValue();
            String in = sortPhone.get(i).getKey();
            Loop2:
            for(int j=i+1;j<sortPhone.size();j++){
                String start = in.substring(0,1);
                if(n==sortPhone.get(j).getValue()){
                    continue;
                }else if(sortPhone.get(j).getKey().startsWith(start)==false){
                    continue;
                }else{
                    String temp = sortPhone.get(j).getKey().substring(0,n);
                   if(in.equals(temp)){
                       answer=false;
                       break Loop1;
                   }
                }
            }
        }
        
        return answer;
    }
}