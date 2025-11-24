package ToBeSolved;

import java.util.*;

public class MinimumWindowSubstring76 {


    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        //String s="a";
        //String t = "a";
        //String s="aa";
        //String t="aaa";
        //String s="bba";
        //String t="ab";
        //String s="bdab";
        //String t="ab";
        //String s="abc";
        //String s="abc";
        //String t="ab";
        //String t ="ab";
        System.out.print(minWindow(s, t));
    }



    public static String minWindow(String s, String t) {

        ArrayList<Character> list = new ArrayList<>();
        for(char c:t.toCharArray()){
            list.add(c);
        }

        ArrayList<Character> temp = new ArrayList<>(list);


        int pointer1=0;
        int pointer2=0;
        int currLen=Integer.MAX_VALUE;
        String curr="";
        String min="";

        while(pointer1<s.length()){


            if(temp.contains(s.charAt(pointer1))){


                do{
                    temp.remove((Character)s.charAt(pointer2));
                    curr+=s.charAt(pointer2);
                    if(pointer2==s.length()-1){
                        break;
                    }
                    pointer2++;
                }while(!temp.isEmpty());


                if(!temp.isEmpty()){
                    temp.clear();
                    curr="";
                    temp.addAll(list);
                    break;
                }


                /*
                curr+=s.charAt(pointer1);
                temp.remove((Character)s.charAt(pointer1));


                while(!temp.isEmpty()){
                    temp.remove((Character)s.charAt(pointer2));
                    if(pointer2==s.length()-1){
                        break bigLoop;
                    }
                    pointer2++;
                    curr+=s.charAt(pointer2);
                }
                */


                if(curr.length()<currLen){
                    min=curr;
                    currLen=curr.length();
                }
                curr="";
                temp.addAll(list);



            }



            pointer1++;
            pointer2=pointer1;
        }

        if(curr.length()!=0){

            for(int i=0;i<curr.length();i++){
                list.remove((Character)curr.charAt(i));
            }

            if(list.isEmpty()){
                return min.isEmpty()?curr: (curr.length() < min.length() ? curr : min );
            }
        }


        return min;


        /*


        //HashSet<Character> set = new HashSet<>();

        ArrayList<Character> list= new ArrayList<>();
        for(int i=0;i<t.length();i++){
            list.add(t.charAt(i));
        }




        StringBuilder sb = new StringBuilder();
        String shortestString="";

        int lastAppear=0;
        HashMap<Character, Integer> map = new HashMap<>();

        int i=0;

        do{

            if(list.isEmpty()){

                if(!shortestString.isEmpty() && sb.length() < shortestString.length() ){
                    shortestString = sb.toString();
                }
                else if(shortestString.isEmpty()){
                    shortestString = sb.toString();
                }

                sb = new StringBuilder();

                for(int j = 0; j < t.length(); j++){
                    list.add(t.charAt(j));
                }

                continue;

            }



            if(list.contains(s.charAt(i))){
                list.remove((Character)s.charAt(i));
                sb.append(s.charAt(i));
            }
            else if(list.size()<t.length()){

                sb.append(s.charAt(i));

            }

        i++;
        }while(i<s.length());


        if(list.isEmpty()) {

            if(shortestString.isEmpty() ){
                return sb.toString();
            }
            else if(sb.length() < shortestString.length()){
                return sb.toString();
            }


        }




        if(sb.length() < shortestString.length()){
            shortestString = sb.toString();
        }else if(shortestString.isEmpty()){
            shortestString = sb.toString();
        }



        return shortestString;*/


    }



}
