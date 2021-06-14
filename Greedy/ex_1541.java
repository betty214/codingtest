package backjun;

import java.util.ArrayList;
import java.util.Scanner;

public class ex_1541 {
    static ArrayList<Character> ops;
    static ArrayList<Integer> nums,tnums;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        String input = sc.next();
        ops = new ArrayList<>();
        nums = new ArrayList<>();
        tnums=new ArrayList<>();
        String temp="";
        for (int i = 0; i <input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-') {
            	nums.add(Integer.parseInt(temp));
            	temp="";
                ops.add(c);
            }else {
            	temp+=c;
            }
        }if(!temp.equals("")) {
        	nums.add(Integer.parseInt(temp));
        }
        int sum=0;
        for(int i=0;i<ops.size();i++) {
        	if(ops.get(i)=='+') {
        		sum+=nums.get(i)+nums.get(i+1);
        	}else {
        		if(i==0) {
        			tnums.add(nums.get(0));
        			if(nums.size()==2) {
        				tnums.add(nums.get(1));
        				break;
        			}
        		}else {
        			if(sum!=0) {
        				tnums.add(sum);
            			sum=0;
        			}else {
        				if(i==ops.size()-1) {
        					tnums.add(nums.get(i));
        					tnums.add(nums.get(i+1));
        				}else {
        					tnums.add(nums.get(i));
        				}
        			}
        		}
        	}
        }
        if(sum!=0) {
        	tnums.add(sum);
       }
        sum=tnums.get(0);
        for(int i=1;i<tnums.size();i++) {
        	sum-=tnums.get(i);
        }
        if(nums.size()==1) {
        	sum=nums.get(0);
        }
        System.out.println(sum);
    }
}
