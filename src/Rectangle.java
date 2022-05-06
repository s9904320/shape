/**
 * 長方形類別 繼承形狀
 */
public class Rectangle extends Shape {
    private double w;  //長
    private double h;  //寬

    /**
     * 建構子
     * @param w 長
     * @param h 寬
     */
    public Rectangle(double w, double h) {
        this.w = w;
        this.h = h;
    }

    /**
     * 面積
     * @return 回傳面積
     */
    @Override
    public double area() {
        return w * h;
    }

    /**
     * 周長
     * @return 回傳周長
     */
    @Override
    public double perimeter() {
        return (w + h) * 2;
    }
}
