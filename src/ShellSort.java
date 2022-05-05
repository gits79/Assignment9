import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class ShellSort {

    static Integer[] sort(Integer[] src){
        Integer[] dst = src.clone();
        int gap = dst.length;

        for(int h = gap / 2; h > 0; h /= 2) {
            for(int i = h; i < gap; i++) {
                int j;
                int temp = dst[i];

                for(j = i - h; j >= 0 && dst[j] > temp; j -= h) {
                    dst[j + h] = dst[j];
                }
                dst[j + h] = temp;
            }
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


//        for(int i =0;i<res.length;i++)
//            System.out.print(res[i]+" ");

        long end = System.nanoTime();
        System.out.println("수행시간: " + (end - start) + " ns");

    }


}
