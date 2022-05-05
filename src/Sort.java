import java.util.Comparator;

public abstract class Sort<T> {
    //몸통 없는 추상화 클래스
    public abstract T[] sort(T[] src, Comparator<T> comp);
    //일반 클래스,도 가능
    public void set(){   }
}
