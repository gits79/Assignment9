import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class QuickSort {

    static void sort(Integer[] src,int start,int end){
        if (start>= end)
            return ;
        int pivot = start;
        int i = start+1;
        int j= end;
        int temp;
        while (i<=j){
            while (i<=end&& src[i] < src[pivot] ){
                i++;
            }
            while (j> start && src[j] >= src[pivot])
                j--;
            if(i>j){
                temp = src[j];
                src[j] = src[pivot];
                src[pivot] = temp;
            }
            else{
                temp = src[i];
                src[i] = src[j];
                src[j] = temp;
            }
        }
        sort(src,start,j-1);
        sort(src,j+1,end);
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


        sort(arr,0, arr.length-1);
//        for(int i=0;i< arr.length;i++)
//            System.out.print(arr[i]+ " ");

        long end = System.nanoTime();
        System.out.println("수행시간: " + (end - start) + " ns");

    }

}
