/**
 * 形狀陣列
 */
public class ShapeArray {
    private Shape[] shapes; //形狀陣列
    private int shapeCount; //目前形狀數量
    private Point[] points; //中心點

    /**
     * 形狀陣列建構子
     *
     * @param shapes     形狀陣列
     * @param shapeCount 形狀數量
     */
    public ShapeArray(Shape[] shapes, int shapeCount, Point[] points) {
        this.shapes = shapes;
        this.shapeCount = shapeCount;
        this.points = points;
    }

    /**
     * 計算兩點中間中心點的形狀
     * @param p1 點1
     * @param p2 點2
     * @return 回傳shape陣列
     */
    public Shape[] showAllShapeByPointArea(Point p1, Point p2){
        Shape[] showShape = new Shape[shapeCount]; //創建陣列
        boolean haveData = false; //是否符合資訊
        for(int i = 0; i < shapeCount;i++){
            if(points[i].getX() >= p1.getX() && points[i].getX() <= p2.getX()
            && points[i].getY() >= p1.getY() && points[i].getY() <= p2.getY()){
                showShape[i] = shapes[i]; //判斷符合
                haveData = true;
            }
        }

        if(!haveData){
            return null; //無資料
        }else {
            return showShape;  //有資料
        }
    }

    /**
     * 計算兩點距離
     * @param point1 點1
     * @param point2 點2
     * @return 回完兩點距離
     */
    public double showDistance(int point1, int point2){
        if (shapeCount <= point1 || point1 < 0 || shapeCount <= point2 || point2 < 0){ //不符合長度
            return -1;
        }
        else {
            Point p1 = points[point1];
            Point p2 = points[point2];
            return distance(p1, p2);
        }
    }

    /**
     * 計算兩點距離
     * @param p1 點1
     * @param p2 點2
     * @return 回傳距離
     */
    private double distance(Point p1, Point p2) {
       return Math.sqrt((p1.getX() - p2.getX()) * (p1.getX() - p2.getX()) +
                (p1.getY() - p2.getY()) * (p1.getY() - p2.getY()));

    }

    /**
     * 透過周長排序的陣列
     * @return 回傳形狀陣列
     */
    public Shape[] showAllShapeByPerimeter() {
        Shape[] allShape = new Shape[shapeCount];
        if (shapeCount == 0) { //無資料;
            return null;
        } else {
            for (int i = 0; i < shapeCount; i++) { //回傳所有資料
                allShape[i] = shapes[i];
            }

            sortByPerimeter(new Bigger(), allShape); //經過排序
            return allShape;
        }
    }

    /**
     * 透過面積排序的陣列
     *
     * @return 回傳形狀陣列
     */
    public Shape[] showAllShapeByArea() {
        Shape[] allShape = new Shape[shapeCount];
        if (shapeCount == 0) { //無資料;
            return null;
        } else {
            for (int i = 0; i < shapeCount; i++) { //回傳所有資料
                allShape[i] = shapes[i];
            }

            sortByArea(new Bigger(), allShape); //經過排序
            return allShape;
        }
    }

    /**
     * 顯示所有陣列
     *
     * @return 回傳形狀陣列
     */
    public Shape[] showAllShape() {
        Shape[] allShape = new Shape[shapeCount];
        if (shapeCount == 0) { //無資料;
            return null;
        } else {
            for (int i = 0; i < shapeCount; i++) { //回傳所有資料
                allShape[i] = shapes[i];
            }
            return allShape;
        }
    }

    /**
     * 顯示指定位置的形狀
     *
     * @param point 位置
     * @return 回傳形狀
     */
    public Shape showShapeByPosition(int point) {
        point -= 1; //因陣列從0開始 故須-1
        if (shapeCount <= point || point < 0) { //不符合長度
            return null;
        } else {
            return shapes[point];
        }

    }

    /**
     * 新增形狀
     * @param shape 形狀
     * @param point 中心點
     */
    public void addShape(Shape shape, Point point) {
        if (shapeCount == shapes.length) { //判斷是否需要擴充
            shapes = doubleShapeArr(shapes);
            points = doublePointArr(points);
        }
        shapes[shapeCount] = shape; //新增形狀
        points[shapeCount] = point; //新增中心點
        shapeCount++; //形狀數量+1
    }

    /**
     * 擴充陣列空間
     *
     * @param shapes 形狀陣列
     * @return 回傳擴充完的陣列
     */
    public Shape[] doubleShapeArr(Shape[] shapes) {
        Shape[] newArr = new Shape[shapes.length * 2];
        for (int i = 0; i < shapes.length; i++) {
            newArr[i] = shapes[i];
        }
        return newArr;
    }

    /**
     * 擴充陣列空間
     *
     * @param points 中心點陣列
     * @return 回傳擴充完的陣列
     */
    public Point[] doublePointArr(Point[] points) {
        Point[] newArr = new Point[points.length * 2];
        for (int i = 0; i < points.length; i++) {
            newArr[i] = points[i];
        }
        return newArr;
    }

    /**
     * 泡沫排序法(周長)
     *
     * @param compare  比較器
     * @param allShape 排序完後的形狀
     */
    public void sortByPerimeter(Comparator compare, Shape[] allShape) {
        for (int i = 0; i < shapeCount - 1; i++) {
            for (int j = i + 1; j < shapeCount; j++) {
                if (compare.compare(allShape[i].perimeter(), allShape[j].perimeter())) {
                    swap(allShape, i, j); //排序
                }
            }
        }
    }

    /**
     * 泡沫排序法(面積)
     *
     * @param compare  比較器
     * @param allShape 排序完後的形狀
     */
    public void sortByArea(Comparator compare, Shape[] allShape) {
        for (int i = 0; i < shapeCount - 1; i++) {
            for (int j = i + 1; j < shapeCount; j++) {
                if (compare.compare(allShape[i].area(), allShape[j].area())) {
                    swap(allShape, i, j); //排序
                }
            }
        }
    }

    /**
     * 交換
     *
     * @param before 前一個數值
     * @param after  後一個數值
     */
    public void swap(Shape[] tmpShape, int before, int after) {
        Shape tmp = tmpShape[before];
        tmpShape[before] = tmpShape[after];
        tmpShape[after] = tmp;
    }
}
