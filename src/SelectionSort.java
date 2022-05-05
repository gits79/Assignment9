import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class SelectionSort<T> extends Sort<T> {


    @Override
    public T[] sort(T[] src, Comparator<T> comp) {
        T[] dst = src.clone();

        for(int i=0;i< dst.length;i++){
            T min = dst[i];
            int idx = i;
            for(int j=i;j< dst.length;j++){
                if(comp.compare(min,dst[j])>0){
                    min = dst[j];
                    idx = j;
                }
            }
            T temp = dst[i];
            dst[i] = dst[idx];
            dst[idx] = temp;
        }
        return dst;
    }

    public static Integer[] sort(Integer[] src) {
        Integer[] dst = src.clone();

        for(int i=0;i< dst.length;i++){
            int min = dst[i];
            int idx = i;
            for(int j=i;j< dst.length;j++){
                if(min>dst[j]){
                    min = dst[j];
                    idx = j;
                }
            }
            int temp = dst[i];
            dst[i] = dst[idx];
            dst[idx] = temp;
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



        int size = index(10);
        Integer[] arr = new Integer[size];

        Random rand = new Random();
        for(int i=0;i<size;i++){
            int random = rand.nextInt(99999)+1;
            arr[i] = random;
        }




        SelectionSort<Integer> sort = new SelectionSort<>();
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };



        // 배열 정렬
        Arrays.sort(arr);
        // 배열 역순으로 정렬
        Arrays.sort(arr, Collections.reverseOrder());

        long start = System.nanoTime();
        Integer[] res = sort(arr);

        long end = System.nanoTime();
        System.out.println("수행시간: " + (end - start) + " ns");

    }





}
