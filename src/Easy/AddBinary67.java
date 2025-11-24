package Easy;
/**
 *
 * Given two binary strings a and b, return their sum as a binary string.
 *
 *
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 *
 * Constraints:
 *
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 *
 * */

public class AddBinary67 {



    public static void main(String[] args) {

        System.out.println(addBinary("1010", "1011"));

    }


    public static String addBinary(String a, String b) {




        int carry=0;
        int i=a.length()-1;
        int j=b.length()-1;
        String res="";

        while(i>=0 || j>=0 || carry==1){

            /*
            * My opinion:
            * My coding here would be like:
            *
            * while(p1>=0 || p2>=0){
            *
            * }
            *
            * And I deal with the carrier with the infinite ifs
            *
            * His opinion:
            * use a carry to deal with the carrier, mod it for the nums we wanna, and store it for the extra values
            * by 2 each time for the purpose of reduce one digit
            *
            * Note:
            * Variable sometimes matters more than the infinite if
            *
            * */





            if(i>=0){
                carry+=a.charAt(i--)-'0';
            }

            if(j>=0){
                carry+=b.charAt(j--)-'0';
            }

            res=carry%2+res;
            carry/=2;

        }
        return res;




        /*
        char[] array=new char[Math.max(a.length(), b.length())+1];
        boolean carry=false;


        for(int i=array.length-1;i>=0;i--){

            if(a.charAt(i)=='0' && b.charAt(i)=='0'){

                if(carry){
                    array[i]='1';
                }
                else{
                    array[i]='0';
                }
                carry=false;
            }
            else if(a.charAt(i)=='1' && b.charAt(i)=='1'){
                if(carry){
                    array[i]='1';
                }
                else{
                    array[i]='0';
                }
                carry=true;
            }
            else{
                if(carry){
                    array[i]='0';
                    carry=true;
                }
                else{
                    array[i]='1';
                    carry=false;
                }

            }

        }


        if(carry){
            array[0]='1';
        }
        else{
            array[0]='0';
        }

        StringBuilder res=new StringBuilder();
        for(int i=0;i<array.length;i++){
            res.append(array[i]);
        }
        return res.toString();*/



    }



}
