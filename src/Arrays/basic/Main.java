package Arrays.basic;

/**
 * Created by Lembre on 2018.10.26
 */
public class Main {
    public static void main(String[] args) {

        int[] arr = new int[10];
        for(int i = 0 ; i < arr.length ; i ++)
            arr[i] = i;

        int[] scores = new int[]{100, 99, 66};
        for(int i = 0 ; i < scores.length ; i ++)
            System.out.print(scores[i]+" ");

        for(int score: scores)
            System.out.print(score+" ");

        scores[0] = 96;

        for(int i = 0 ; i < scores.length ; i ++)
            System.out.print(scores[i]+" ");
    }
}
