import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class InsertionSort {

//    public static int[] sort(int[] src){
//        int[] dst = src.clone();
//        for(int i=1;i<dst.length;i++){
//            int current = dst[i];
//            int j= i-1;
//
//                while(j>=0 && dst[j]>current){
//                    dst[j+1] = dst[j];
//                    j = j-1;
//                }
//            dst[j+1] = current;
//            }
//        return dst;
//        }



    public static Integer[] sort(Integer[] src){
        Integer[] dst = src.clone();
        for(int i=1;i<dst.length;i++){
            int current = dst[i];
            int j= i-1;

            while(j>=0 && dst[j]>current){
                dst[j+1] = dst[j];
                j = j-1;
            }
            dst[j+1] = current;
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


        int size = index(18);
        Integer[] arr = new Integer[size];

        Random rand = new Random();
        for(int i=0;i<size;i++){
            int random = rand.nextInt(99999)+1;
            arr[i] = random;
        }

//        Comparator<Integer> comp = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
//            }
//        };

        // 배열 정렬
        Arrays.sort(arr);
        // 배열 역순으로 정렬
        Arrays.sort(arr, Collections.reverseOrder());

        long start = System.nanoTime();
        Integer[] res = sort(arr);

//        for(int i=0;i< res.length;i++)
//            System.out.print(res[i]+" ");

        long end = System.nanoTime();
        System.out.println("수행시간: " + (end - start) + " ns");

    }


}
