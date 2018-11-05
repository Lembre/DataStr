package trie.matchpattern;/// Leetcode 211. Add and Search Word - Data structure design
/// https://leetcode.com/problems/add-and-search-word-data-structure-design/description/

import java.util.TreeMap;

public class WordDictionary {

    private class Node{

        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {

        Node cur = root;
        for(int i = 0 ; i < word.length() ; i ++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int index){

        if(index == word.length())/*递归终结条件*/
            return node.isWord;/*匹配成功或者失败*/

        char c = word.charAt(index);

        if(c != '.'){/*这个不是.那么和之前的一样*/
            if(node.next.get(c) == null)
                return false;
            return match(node.next.get(c), word, index + 1);
        }
        else{/*否则的话*/
            for(char nextChar: node.next.keySet())/*这个键对应的所有比如a对应的集合(比如a,b,c)*/
                if(match(node.next.get(nextChar), word, index + 1))
                    return true;
            return false;/*都没有匹配成功*/
        }
    }
}
