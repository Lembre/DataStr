package heap_priqueue.extract_siftdown;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    // 返回堆中的元素个数
    public int size(){
        return data.getSize();
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index){
        if(index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return index * 2 + 2;
    }

    // 向堆中添加元素
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k){

        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0 ){
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    // 看堆中的最大元素
    public E findMax(){
        if(data.getSize() == 0)/*这个堆是空的*/
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }

    // 取出堆中最大元素
    public E extractMax(){

        E ret = findMax();/*暂存最大元素*/

        data.swap(0, data.getSize() - 1);
        data.removeLast();/*删除最大元素*/
        siftDown(0);

        return ret;/*返回最大元素*/
    }

    private void siftDown(int k){/*传入下沉索引*/

        while(leftChild(k) < data.getSize()){/*leftChild(k)返回的是（K * 2 + 1），表示这个节点已经没有子节点了
        为什么不用node.left?因为这是堆，不是二叉搜索树。*/
            int j = leftChild(k); // 在此轮循环中,data[k]和data[j]交换位置。保存左孩子节点的索引值
            if( j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0 )/*右孩子节点存在且右孩子节点值大于左孩子*/
                j ++;
            // data[j] 是 leftChild 和 rightChild 中的最大值

            if(data.get(k).compareTo(data.get(j)) >= 0 )/*下沉结束（这是由堆的性质决定的，上层父节点的值
            一定大于下层父节点的值，一旦大于下层节点的值，那么全部都大于了）*/
                break;

            data.swap(k, j);/*否则交换*/
            k = j;/*把j赋值给k,进行下一轮循环*/
        }
    }
}
