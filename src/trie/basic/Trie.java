package trie.basic;

import java.util.TreeMap;

public class Trie {

    private class Node{

            public boolean isWord;/*当前的节点是否访问到了一个单词*/
            public TreeMap<Character, Node> next;/*封装Node之后进行复用，屏蔽细节*/

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    private Node root;
    private int size;/*存储了多少单词*/

    public Trie(){
        root = new Node();
        size = 0;
    }

    // 获得Trie中存储的单词数量
    public int getSize(){
        return size;
    }

    // 向Trie中添加一个新的单词word
    public void add(String word){

        Node cur = root;
        for(int i = 0 ; i < word.length() ; i ++){
            char c = word.charAt(i);/*字符串拆成字符*/
            if(cur.next.get(c) == null)/*当前映射中未包含这个字符*/
                cur.next.put(c, new Node());/*新创建一个几点*/
            cur = cur.next.get(c);
        }

        if(!cur.isWord){/*以前并不表示一个单词*/
            cur.isWord = true;/*现在表示一个单词*/
            size ++;
        }
    }
}
