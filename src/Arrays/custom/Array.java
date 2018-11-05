package Arrays.custom;

/**
 * Created by Lembre on 2018.10.26
 */
public class Array {
    private int[] data;/*不需要设置容量是因为，data.length就是容量，这样就可以少维护一个变量*/
    private int size;/*为什么设置成private，不希望用户从外部直接获得size的信息，这样是危险的，用户可以在外部
    更改size，而实际上data.length比size小，这是危险的，破坏封装性，使用时产生Bug*/

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity){/*直接调用rray(int capacity)构造方法，并且参数由自己定义*/
        data = new int[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认数组的容量capacity=10
    public Array(){
        this(10);/*间接调用Array(int capacity)构造方法，并且参数是10*/
    }

    // 获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    // 获取数组中的元素个数
    public int getSize(){
        return size;
    }

    // 返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 向所有元素后添加一个新元素
    public void addLast(int e){
        if(size == data.length){
            throw new IllegalArgumentException("AddLast failed. Array is full.");
        }
        data[size] = e;
        size++;
    }

    // 在index索引的位置插入一个新元素e
    public void add(int index, int e){

        if(size == data.length)
            throw new IllegalArgumentException("Add failed. Array is full.");

        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        for(int i = size - 1; i >= index ; i --)
            data[i + 1] = data[i];

        data[index] = e;
        size ++;
    }

    // 在所有元素前添加一个新元素
    public void addFirst(int e){
        add(0, e);
    }

    // 获取index索引位置的元素
    public int get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int index, int e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }

    // 遍历查找数组中是包含元素e
    public boolean contains(int e){
        for(int i = 0 ; i < size ; i ++){
            if(data[i] == e)
                return true;
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(int e){
        for(int i = 0 ; i < size ; i ++){
            if(data[i] == e)
                return i;
        }
        return -1;
    }

    // 从数组中删除index位置的元素, 返回删除的元素(常见做法)
    public int remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        int ret = data[index];
        for(int i = index + 1 ; i < size ; i ++)
            data[i - 1] = data[i];
        size --;
        return ret;
    }

    // 从数组中删除元素e,如果有两个e呢？具体还需要设计更复杂的接口方法，find同理
    public void removeElement(int e){
        int index = find(e);
        if(index != -1)
            remove(index);
    }

    @Override/*使用@Override的好处是能够使得在方法名写错时报错，输出数组形式的报错*/
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
