package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 *
 * Constraints:
 *
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 *
 *
 * */

public class LetterCombinationsOfAPhoneNumber17 {





    public static void main(String[] args) {



        System.out.println(letterCombinations("234"));

    }


    public static List<String> letterCombinations(String digits) {


        /*
        if(digits.length()<2){
            return letterTable(digits);
        }*/



        List<String> result = new ArrayList<>();
        for(int i=0; i<digits.length(); i++){
            List<String> letters = letterTable(digits.charAt(i)+"");
            List<String> combinations = new ArrayList<>();



            if(!result.isEmpty()) {
                for (String letter : letters) {
                    for (String res : result) {
                        combinations.add(res + letter);
                    }
                }
            }
            else{
                combinations.addAll(letters);
            }


            result = combinations;

        }


        return result;
    }


    public static List<String> letterTable(String digits) {

        int digit=Integer.parseInt(digits);
        List<String> list;
        String[] array;
        switch(digit){
            case 2:
                array=new String[]{"a","b","c"};
                break;
                case 3:
                    array=new String[]{"d","e","f"};
                    break;
                    case 4:
                        array=new String[]{"g","h","i"};
                        break;
                        case 5:
                            array=new String[]{"j","k","l"};
                            break;
                            case 6:
                                array=new String[]{"m","n","o"};
                                break;
                                case 7:
                                    array=new String[]{"p","q","r","s"};
                                    break;
                                    case 8:
                                        array=new String[]{"t","u","v"};
                                        break;
                                        case 9:
                                            array=new String[]{"w","x","y","z"};
                                            break;
                                            default:
                                                array=new String[]{};
        }

        list=Arrays.asList(array);
        return list;

    }

    /*Note:
    * Although it SHOULD be solved with recursion, iteration can reach it even faster
    * */


}
