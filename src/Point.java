/**
 * 點類別
 */
public class Point {
    private double x; //座標X
    private double y; //座標Y

    /**
     * 建構子
     * @param x 中心點X
     * @param y 中心點Y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 取得x
     * @return 回傳x
     */
    public double getX() {
        return x;
    }

    /**
     * 取得y
     * @return 回傳y
     */
    public double getY() {
        return y;
    }
}
