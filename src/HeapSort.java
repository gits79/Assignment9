import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class HeapSort<T> {

    public static Integer[] sort(Integer[] src) {
        Integer[] dst = src.clone();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i=0;i< dst.length;i++){
            queue.add(dst[i]);
        }

        for (int i=0;i< dst.length;i++){
            dst[i] = queue.poll();
        }

        return dst;
    }



    static int index(int n){
        int result = 1;

        for(int i=1;i<=n;i++)
            result *=2;
        return result;
    }


    public static void main(String[] args) {



        int size = index(20);
        Integer[] arr = new Integer[size];

        Random rand = new Random();
        for(int i=0;i<size;i++){
            int random = rand.nextInt(99999)+1;
            arr[i] = random;
        }


        // 배열 정렬
        Arrays.sort(arr);
        // 배열 역순으로 정렬
        Arrays.sort(arr, Collections.reverseOrder());

        long start = System.nanoTime();
        Integer[] res = sort(arr);



//        for(int i=0;i< arr.length;i++)
//            System.out.print(arr[i]+" ");

        long end = System.nanoTime();
        System.out.println("수행시간: " + (end - start) + " ns");



    }

}
