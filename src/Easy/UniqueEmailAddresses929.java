package Easy; /**
 Every valid email consists of a local name and a domain name, separated by the '@' sign. Besides lowercase letters, the email may contain one or more '.' or '+'.

 For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
 If you add periods '.' between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name. Note that this rule does not apply to domain names.

 For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
 If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered. Note that this rule does not apply to domain names.

 For example, "m.y+name@email.com" will be forwarded to "my@email.com".
 It is possible to use both of these rules at the same time.

 Given an array of strings emails where we send one email to each emails[i], return the number of different addresses that actually receive mails.



 Example 1:

 Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 Output: 2
 Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.
 Example 2:

 Input: emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]
 Output: 3


 Constraints:

 1 <= emails.length <= 100
 1 <= emails[i].length <= 100
 emails[i] consist of lowercase English letters, '+', '.' and '@'.
 Each emails[i] contains exactly one '@' character.
 All local and domain names are non-empty.
 Local names do not start with a '+' character.
 Domain names end with the ".com" suffix.
 Domain names must contain at least one character before ".com" suffix
 */
import java.util.HashSet;
public class UniqueEmailAddresses929 {
    public static void main(String[] args) {

       String[] email1={"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(email1));
       String[]email2 ={"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
       System.out.println(numUniqueEmails(email2));
    }


    static int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();

        for(String email:emails){
            set.add(validAddress(email));
        }
        return set.size();
    }

    static String validAddress(String email) {
        int index=email.indexOf("@");
        StringBuilder builder=new StringBuilder();

        for(int i=0;i<index;i++){
            if(email.charAt(i)=='.'){
                continue;
            }
            else if(email.charAt(i)=='+'){
                break;
            }
            else{
                builder.append(email.charAt(i));
            }
        }
        builder.append(email.substring(index));

        return builder.toString();

    }



    /*Note:
    * Unknown:
    * 1. hashSet
    * 2. StringBuilder
    *
    * My opinion:
    * 1. read the whole string
    * 2. split the string into different substrings
    * 3. join them together
    * 4. compare the joined one with the existed ones
    *
    * His opinion:
    * 1. split the method of validation
    * 2. read the whole string, and during the process, use the "continue" to read and use StringBuilder to join at the same time
    * 3. use the HashSet to compare
    *
    * Hint:
    * 1. split of method
    * 2. StringBuilder can finish the process of split and join at the same time
    * 3. HashSet is able to finish the process of comparison without reading the whole ArrayList
    * */



}
