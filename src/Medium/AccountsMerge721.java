package Medium;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
 *
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 *
 * After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
 * Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
 * Explanation:
 * The first and second John's are the same person as they have the common email "johnsmith@mail.com".
 * The third John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 * Example 2:
 *
 * Input: accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
 * Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
 *
 *
 * Constraints:
 *
 * 1 <= accounts.length <= 1000
 * 2 <= accounts[i].length <= 10
 * 1 <= accounts[i][j].length <= 30
 * accounts[i][0] consists of English letters.
 * accounts[i][j] (for j > 0) is a valid email.
 *
 * */


public class AccountsMerge721 {


/*
    static Map<Integer, Integer> parent = new HashMap<>();




    // Find root with path compression
    private static int find(int x) {
        parent.putIfAbsent(x, x);
        if (x != parent.get(x)) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    // Union two elements
    private static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            parent.put(px, py);
        }
    }

    public static List<Set<Integer>> mergeGroups(List<List<Integer>> groups) {
        for (List<Integer> group : groups) {
            for (int i = 1; i < group.size(); i++) {
                union(group.get(0), group.get(i));
            }
        }

        // Grouping by root
        Map<Integer, Set<Integer>> result = new HashMap<>();
        for (int x : parent.keySet()) {
            int root = find(x);
            result.computeIfAbsent(root, k -> new HashSet<>()).add(x);
        }

        return new ArrayList<>(result.values());
    }

    public static void main(String[] args) {
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(4, 5)
        );

        List<Set<Integer>> merged = mergeGroups(input);

        for (Set<Integer> group : merged) {
            System.out.println(group);
        }
    }*/


    public static void main(String[] args) {



        List<List<String>> accounts = new ArrayList<>();
        List<String> account1 = new ArrayList<>();
        account1.add("John");
        account1.add("johnsmith@mail.com");
        account1.add("john_newyork@mail.com");
        List<String> account2 = new ArrayList<>();
        account2.add("John");
        account2.add("johnsmith@mail.com");
        account2.add("john00@mail.com");
        accounts.add(account1);
        accounts.add(account2);
        List<String> account3 = new ArrayList<>();
        account3.add("Mary");
        account3.add("mary@mail.com");
        List<String> account4 = new ArrayList<>();
        account4.add("John");
        account4.add("johnnybravo@mail.com");
        accounts.add(account3);
        accounts.add(account4);
        System.out.println(accountsMerge(accounts));

    }


    //static List<Map<String, Map<String,String>>> list=new ArrayList<>();
    
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {


        HashMap<String, HashMap<String, String>> map=new HashMap<>();

        for (List<String> account : accounts) {
            String name=account.get(0);

            HashMap<String,String> accountMap;

            if(map.containsKey(name)){
                accountMap=map.get(name);
            }
            else{
                accountMap=new HashMap<>();
            }


            for(int i=1;i<account.size();i++) {
                union(account.get(1),account.get(i),accountMap);
            }

            map.put(name, accountMap);

        }



        List<List<String>> result=new ArrayList<>();


        for(Map.Entry<String,HashMap<String, String>> entry:map.entrySet()) {
            String name=entry.getKey();

            Map<String, Set<String>> res = new HashMap<>();
            for (String x : entry.getValue().keySet()) {
                String root = find(x,entry.getValue());
                res.computeIfAbsent(root, k -> new HashSet<>()).add(x);
            }



            //res.values().forEach(list::addAll);
            //list.sort(Comparator.comparing(String::length));

            for(Set<String> set:res.values()) {
                List<String> list=new ArrayList<>();
                list.add(name);
                list.addAll(set.stream().sorted().collect(Collectors.toList()));
                result.add(list);
            }


        }

        return result;

    }

    private static String find(String str, Map<String, String> map) {
        map.putIfAbsent(str,str);
        if (!Objects.equals(str, map.get(str))) {

            map.put(str,find(map.get(str), map));

        }
        return map.get(str);
    }

    // Union two elements
    private static void union(String x, String y, Map<String, String> map) {
        String px = find(x, map);
        String py = find(y, map);
        if (!Objects.equals(px, py)) {
            map.put(px, py);
        }
    }







    /*
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {

        HashMap<String, List<HashSet<String>>> map = new HashMap<>();


        List<String>[] array = accounts.toArray(new List[0]);

        loop: for(int i = 0; i < array.length; i++){

            //array[i] is a list which looks like: <"John","johnsmith@mail.com","john_newyork@mail.com">
            String name=array[i].get(0);


            if(map.containsKey(name)){

                for(int j=1; j<array[i].size(); j++){
                    for(HashSet set : map.get(name)){
                     //array[i].get(j) is something like "johnsmith@mail.com"
                        //set is something like <"john00@mail.com","john_newyork@mail.com","johnsmith@mail.com">
                        if(set.contains(array[i].get(j))){
                            for(int k=1; k<array[i].size(); k++){
                                set.add(array[i].get(k));
                            }
                            continue loop;
                        }
                    }
                }

                HashSet<String> set = new HashSet<>();
                for(int j=1; j<array[i].size(); j++){
                    set.add(array[i].get(j));
                }
                map.get(name).add(set);

            }
            else{

                HashSet<String> set = new HashSet<>();
                for(int j=1; j<array[i].size(); j++){
                    set.add(array[i].get(j));
                }
                ArrayList<HashSet<String>> sets = new ArrayList<>();
                sets.add(set);
                map.put(name,sets);
            }
        }









        List<List<String>> res = new ArrayList<>();
        for(String name : map.keySet()){

            for(HashSet<String> set : map.get(name)){
                List<String> list = new ArrayList<>();
                list.add(name);
                list.addAll(set.stream().sorted().collect(Collectors.toList()));
                res.add(list);
            }
        }

        return res;

    }*/




/*Note:
* Unknown: Union-Find
*
* To say: Union-find is so complex that it ought to be distributed into hard
*
* */
}
