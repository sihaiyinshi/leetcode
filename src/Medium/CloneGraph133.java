package Medium; /**
 * Given a reference of a node in a connected undirected graph.
 *
 * Return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *
 *
 * Test case format:
 *
 * For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.
 *
 * An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.
 *
 * The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 * Explanation: There are 4 nodes in the graph.
 * 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * Example 2:
 *
 *
 * Input: adjList = [[]]
 * Output: [[]]
 * Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.
 * Example 3:
 *
 * Input: adjList = []
 * Output: []
 * Explanation: This an empty graph, it does not have any nodes.
 *
 *
 * Constraints:
 *
 * The number of nodes in the graph is in the range [0, 100].
 * 1 <= Node.val <= 100
 * Node.val is unique for each node.
 * There are no repeated edges and no self-loops in the graph.
 * The Graph is connected and all nodes can be visited starting from the given node.
 * */


import java.util.*;

public class CloneGraph133 {

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    public static void main(String[] args) {
        //System.out.println(cloneGraph(new Node()));
        //System.out.println(cloneGraph(new Node()));



        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        Node test=new Node(1);
        Node test2=new Node(2);
        test.neighbors.add(test2);
        test2.neighbors.add(test);

        printNode(test);
        printNode(n1);


        //printNode(n1);
        //System.out.println(n1);
        //System.out.println(cloneGraph(n1));

    }

    public static void printNode(Node node) {
       if(node == null){
           return;
       }

       printNode(node, new HashSet<Integer>());



    }

    public static void printNode(Node node, HashSet<Integer> visited) {
        if(node == null || visited.contains(node.val)){
            return;
        }
        visited.add(node.val);
        System.out.println("val:"+node.val);
        System.out.print("neighbors:");

        for(Node neighbor : node.neighbors){
            System.out.print(neighbor.val+" ");
        }

        System.out.println();

        for(Node neighbor : node.neighbors){
            printNode(neighbor, visited);
        }

    }



    public static Node cloneGraph(Node node){
        if(node == null){
            return null;
        }

        HashMap<Integer, Node>map = new HashMap<>();
        generateNode(node, map);
        addNeighbor(node, map, new HashSet<>());

        return map.get(node.val);

    }

    public static void generateNode(Node node, HashMap<Integer, Node> map){
        if(node == null || map.containsKey(node.val)){
            return;
        }

        map.put(node.val, new Node(node.val));
        for(Node neighbor : node.neighbors){
            generateNode(neighbor, map);
        }

    }

    public static void addNeighbor(Node node, HashMap<Integer, Node> map, HashSet<Integer> visited){
        if(node == null || visited.contains(node.val)){
            return;
        }

        visited.add(node.val);
        Node clone = map.get(node.val);
        for(Node neighbor : node.neighbors){
            clone.neighbors.add(map.get(neighbor.val));
            addNeighbor(neighbor, map, visited);
        }

    }


    /*Note:
     * Unknown:
     *
     * My opinion:
     * 1. like linked list, one pointer to read the origin
     * 2. two pointers generate new graph, one of them is faster and another is slower
     *
     * His opinion:
     * 1. use one hash map to read the origin and generate nodes separately
     * 2. use another hash set to memory the visited nodes, and adding neighbors via finding the generated nodes by their val
     *
     * Hint:
     * 1. hash map is a very useful tool to mark objects when regarding of their connection
     * 2. hash set is a useful tool for recording and avoids traveling twice
     * 3. when deep copying the objects, it would be better to generate them and connect them separately
     *
     * */




}
