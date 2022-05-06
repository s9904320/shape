/**
 * 比較大小
 */
public class Bigger implements Comparator{
    @Override //覆寫 比較大小
    public boolean compare(double before, double after) {
        return before > after;
    }
}
