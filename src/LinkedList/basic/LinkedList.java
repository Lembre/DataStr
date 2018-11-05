package LinkedList.basic;

public class LinkedList<E> {

    private class Node{/*用户不需要知道，内部实现机制是Node节点，它是需要知道链表可以干什么就可以*/
        public E e;
        public Node next;

        public Node(E e, Node next){/*用户传来的E和next赋给这个节点的e和next*/
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }
}
