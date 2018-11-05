package Arrays.dynamic;

public class Main {

    public static void main(String[] args) {

        Array<Integer> arr = new Array<>();//默认10个容量
        for(int i = 0 ; i < 10 ; i ++)
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1, 100);//此时添加元素，容量不够
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        /*arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);*/
    }
}
