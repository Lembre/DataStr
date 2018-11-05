package trie.trie_map;

import java.util.TreeMap;

public class MapSum {

    private class Node{

        public int value;
        public TreeMap<Character, Node> next;

        public Node(int value){
            this.value = value;
            next = new TreeMap<>();
        }

        public Node(){
            this(0);
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public MapSum() {

        root = new Node();
    }

    public void insert(String key, int val) {

        Node cur = root;
        for(int i = 0 ; i < key.length() ; i ++){
            char c = key.charAt(i);
            if(cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {

        Node cur = root;
        for(int i = 0 ; i < prefix.length() ; i ++){
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null)/*r如果根本不存在这个映射*/
                return 0;
            cur = cur.next.get(c);/*否则的话*/
        }

        /*跳出循环后，cur节点指向的就是前缀最后一个字母的节点*/
        return sum(cur);
    }

    private int sum(Node node){
       /* if(node.next.size()==0)
            return node.value;*/
        int res = node.value;
        for(char c: node.next.keySet())/*遍历查看他里面的所有映射，因为这个递归已经包含了递归终止的条件，所以不用写*/
            res += sum(node.next.get(c));
        return res;
    }
}
