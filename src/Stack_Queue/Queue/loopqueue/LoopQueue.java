package Stack_Queue.Queue.loopqueue;

import Stack_Queue.Queue.src.Queue;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;   // 有兴趣的同学，在完成这一章后，可以思考一下：
                        // LoopQueue中不声明size，如何完成所有的逻辑？
                        // 这个问题可能会比大家想象的要难一点点：）

    public LoopQueue(int capacity){/*这里+1是因为容量会比实际容量少一，所以用户想要capacity时还要+1*/
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public boolean isEmpty(){
        return front == tail;
    }

    @Override
    public int getSize(){
        return size;
    }

    // 下一小节再做具体实现
    @Override
    public void enqueue(E e){
        if((tail + 1) % data.length == front)
            resize(getCapacity() * 2);//队列满

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    // 下一小节再做具体实现
    @Override
    public E dequeue(){
        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        E ret = data[front];//取出队首元素
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);//解决动态扩容的问题
        return ret;
    }

    // 下一小节再做具体实现
    @Override
    public E getFront(){
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }

    private void resize(int newCapacity){

        E[] newData = (E[])new Object[newCapacity + 1];
        for(int i = 0 ; i < size ; i ++)
            newData[i] = data[(i + front) % data.length];
        /*for (int i = front; i != tail; i = (i + 1)%data.length)
            newData[i-front] = data[i];这是另一种写法*/

        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % data.length){//i不能取到tail,
            res.append(data[i]);
            if((i + 1) % data.length != tail)//当前不是最后一个元素
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args){

        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.print(queue);
            System.out.println();
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
