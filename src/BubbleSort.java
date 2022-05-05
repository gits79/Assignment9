import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class BubbleSort<T> {

    static int index(int n){
        int result = 1;

        for(int i=1;i<=n;i++)
            result *=2;
        return result;
    }

    public static Integer[] sort(Integer[] src){
        Integer[] dst = src.clone();
        for(int i=0;i< dst.length;i++){
            for(int j=0;j< dst.length-i-1;j++){
                if(dst[j]>dst[j+1]){
                    int temp = dst[j];
                    dst[j] = dst [j+1];
                    dst[j+1] = temp;
                }
            }
        }


        return dst;
    }

    // 오버로딩
    public float[] sort(float[] src){
        float[] dst = src.clone();
        for(int i=0;i< dst.length;i++){
            for(int j=0;j< dst.length-i-1;j++){
                if(dst[j]>dst[j+1]){
                    float temp = dst[j];
                    dst[j] = dst [j+1];
                    dst[j+1] = temp;
                }
            }
        }


        return dst;
    }
    // 외부에서 넣어주는 인터페이스 추가
    public T[] sort(T[] src, Comparator<T> comp){
        T[] dst = src.clone();

        for(int i=0;i< dst.length;i++){
            for(int j=0;j< dst.length-i-1;j++){
                if(comp.compare(dst[j],dst[j+1])>0){
                    T temp = dst[j];
                    dst[j] = dst [j+1];
                    dst[j+1] = temp;
                }
            }
        }

        return dst;
    }




    public static void main(String[] args) {


        int size = index(18);
        Integer[] arr = new Integer[size];

        Random rand = new Random();
        for(int i=0;i<size;i++){
            int random = rand.nextInt(99999)+1;
            arr[i] = random;
        }


        BubbleSort<Integer> sort = new BubbleSort<>();
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


//        for(int i=0;i< res.length;i++)
//            System.out.print(res[i]+" ");
//        System.out.println();



        long end = System.nanoTime();
        System.out.println("수행시간: " + (end - start) + " ns");





    }







}
