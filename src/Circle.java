/**
 * 圓形類別 繼承形狀
 */
public class Circle extends Shape {
    private double r; //半徑
    private static final double pi = 3.14;  //圓周率

    /**
     * 圓形建構子
     * @param r
     */
    public Circle(double r) {
        this.r = r;
    }

    /**
     * 面積
     * @return回傳面積
     */
    @Override
    public double area() {
        return r * r * pi;
    }

    /**
     * 周長
     * @return回傳周長
     */
    @Override
    public double perimeter() {
        return 2 * r * pi;
    }
}
