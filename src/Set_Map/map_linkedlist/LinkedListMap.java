package Set_Map.map_linkedlist;

import java.util.ArrayList;

public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value){
            this(key, value, null);
        }

        public Node(){
            this(null, null, null);
        }

        @Override
        public String toString(){
            return key.toString() + " : " + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    private Node getNode(K key){
        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.key.equals(key))
                return cur;
            cur = cur.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key){
        return getNode(key) != null;
    }

    @Override
    public V get(K key){
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void add(K key, V value){
        Node node = getNode(key);
        if(node == null){
            dummyHead.next = new Node(key, value, dummyHead.next);
            size ++;
        }
        else
            node.value = value;/*设计管理，直接忽略重复元素（更新）或者抛出异常都可以*/
    }

    @Override
    public void set(K key, V newValue){
        Node node = getNode(key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");

        node.value = newValue;
    }

    @Override
    public V remove(K key){

        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.key.equals(key))/*是不是要删除的那个节点*/
                break;
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;/*维护size*/
            return delNode.value;
        }

        return null;/*找不到，不需要删除任何节点*/
    }

    public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            LinkedListMap<String, Integer> map = new LinkedListMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }
}
