package Easy; /**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * Example 2:
 *
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * Example 3:
 *
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 200
 * s and t only contain lowercase letters and '#' characters.
 * */

import java.util.ArrayList;

public class BackspaceStringCompare844 {


    public static void main(String[] args) {

        System.out.println(backspaceCompare("oi###mupo##rszty#s#xu###bxx##dqc#gdjz","oi###mu#ueo##pk#o##rsztu#y#s#xu###bxx##dqc#gz#djz"));


    }


    public static boolean backspaceCompare(String s, String t) {



        ArrayList<Character> list1 = new ArrayList();
        ArrayList<Character> list2 = new ArrayList();


        for(Character c : s.toCharArray()) {

            if(!c.equals('#')){
                list1.add(c);
            }
            else if(!list1.isEmpty()){
                list1.remove(list1.size()-1);
            }

        }

        for(Character c : t.toCharArray()) {

            if(!c.equals('#')){
                list2.add(c);
            }
            else if(!list2.isEmpty()){
                list2.remove(list2.size()-1);
            }

        }



        if(list1.isEmpty() && list2.isEmpty()){
            return true;
        }
        else if(list1.size() != list2.size()) {
            return false;
        }


        for(int i = 0; i<list1.size(); i++){
            if(!list1.get(i).equals(list2.get(i))){
                return false;
            }
        }

        return true;


    }

    /*Note:
     * A small warm-up
     * */

}
