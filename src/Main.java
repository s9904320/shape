import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShapeArray shapeArray = new ShapeArray(new Shape[1], 0, new Point[1]); //創建陣列
        boolean isContinue = true; //判斷程式進行

        while (isContinue) {
            showOption(); //介面顯示
            int option = sc.nextInt(); //使用者動作
            sc.nextLine();
            switch (option) {
                case 1:
                    addShape(sc, shapeArray); //新增一個形狀
                    break;
                case 2:
                    showShapeByPosition(sc, shapeArray);//列出指定位置的形狀
                    break;
                case 3:
                    showAllShapeByArea(shapeArray);//依面積大小排序
                    break;
                case 4:
                    showAllShapeByPerimeter(shapeArray);//依周長大小排序
                    break;
                case 5:
                    showAllShape(shapeArray);//依序列出所有形狀
                    break;
                case 6:
                    showDistance(sc, shapeArray);//計算陣列中形狀的中心點兩點距離
                    break;
                case 7:
                    showShapeByPointArea(sc, shapeArray); //印出中心點在此座標範圍內的形狀
                    break;
                case 8:
                    isContinue = false; //結束程式
                    break;
            }
        }
    }

    /**
     * 印出中心點在此座標範圍內的形狀
     *
     * @param sc         輸入
     * @param shapeArray 形狀陣列
     */
    private static void showShapeByPointArea(Scanner sc, ShapeArray shapeArray) {
        System.out.println("請輸入第一點:");
        System.out.println("第一點x");
        double position1_X = sc.nextDouble();
        System.out.println("第一點y");
        double position1_Y = sc.nextDouble();
        Point p1 = new Point(position1_X, position1_Y);
        System.out.println("請輸入第二點:");
        System.out.println("第二點x");
        double position2_X = sc.nextDouble();
        System.out.println("第二點y");
        double position2_Y = sc.nextDouble();
        Point p2 = new Point(position2_X, position2_Y);
        Shape[] showShapes = shapeArray.showAllShapeByPointArea(p1, p2);//取出兩點中包含的中心點的形狀
        if (showShapes == null) {  //不符合資訊
            System.out.println("無符合資訊");
        } else {
            for (int i = 0; i < showShapes.length; i++) { //顯示所有形狀
                if (showShapes[i] instanceof Circle) { //判斷圓形
                    System.out.println("圓形=> 面積:" + showShapes[i].area() + " 周長:" + showShapes[i].perimeter());
                } else if (showShapes[i] instanceof Rectangle) { //判斷長方形
                    System.out.println("長方形=> 面積:" + showShapes[i].area() + " 周長:" + showShapes[i].perimeter());
                }
            }
        }
    }

    /**
     * 顯示兩點距離
     *
     * @param sc         輸入
     * @param shapeArray 形狀陣列
     */
    private static void showDistance(Scanner sc, ShapeArray shapeArray) {
        System.out.println("輸入第一個陣列中的形狀位置");
        int position1 = sc.nextInt();
        System.out.println("輸入第二個陣列中的形狀位置");
        int position2 = sc.nextInt();

        double distance = shapeArray.showDistance(position1, position2); //計算兩點距離
        if (distance == -1) {
            System.out.println("無資料");
        } else {
            System.out.println("兩者距離為" + distance);
        }
    }

    /**
     * 依周長大小排序
     *
     * @param shapeArray 形狀陣列
     */
    private static void showAllShapeByPerimeter(ShapeArray shapeArray) {
        Shape[] showShapes = shapeArray.showAllShapeByPerimeter(); //抓出所有形狀
        if (showShapes == null) {  //不符合資訊
            System.out.println("無符合資訊");
        } else {
            for (int i = 0; i < showShapes.length; i++) { //顯示所有形狀
                if (showShapes[i] instanceof Circle) { //判斷圓形
                    System.out.println("圓形=> 面積:" + showShapes[i].area() + " 周長:" + showShapes[i].perimeter());
                } else if (showShapes[i] instanceof Rectangle) { //判斷長方形
                    System.out.println("長方形=> 面積:" + showShapes[i].area() + " 周長:" + showShapes[i].perimeter());
                }
            }
        }
    }

    /**
     * 依面積大小排序
     *
     * @param shapeArray 形狀陣列
     */
    private static void showAllShapeByArea(ShapeArray shapeArray) {
        Shape[] showShapes = shapeArray.showAllShapeByArea(); //抓出所有形狀
        if (showShapes == null) {  //不符合資訊
            System.out.println("無符合資訊");
        } else {
            for (int i = 0; i < showShapes.length; i++) { //顯示所有形狀
                if (showShapes[i] instanceof Circle) { //判斷圓形
                    System.out.println("圓形=> 面積:" + showShapes[i].area() + " 周長:" + showShapes[i].perimeter());
                } else if (showShapes[i] instanceof Rectangle) { //判斷長方形
                    System.out.println("長方形=> 面積:" + showShapes[i].area() + " 周長:" + showShapes[i].perimeter());
                }
            }
        }
    }

    /**
     * 依序列出所有形狀
     *
     * @param shapeArray 形狀陣列
     */
    private static void showAllShape(ShapeArray shapeArray) {
        Shape[] showShapes = shapeArray.showAllShape(); //抓出所有形狀
        if (showShapes == null) {  //不符合資訊
            System.out.println("無符合資訊");
        } else {
            for (int i = 0; i < showShapes.length; i++) { //顯示所有形狀
                if (showShapes[i] instanceof Circle) { //判斷圓形
                    System.out.println("圓形=> 面積:" + showShapes[i].area() + " 周長:" + showShapes[i].perimeter());
                } else if (showShapes[i] instanceof Rectangle) { //判斷長方形
                    System.out.println("長方形=> 面積:" + showShapes[i].area() + " 周長:" + showShapes[i].perimeter());
                }
            }
        }
    }

    /**
     * 列出指定位置的形狀
     *
     * @param sc         輸入
     * @param shapeArray 形狀陣列
     */
    private static void showShapeByPosition(Scanner sc, ShapeArray shapeArray) {
        System.out.println("選擇指定位置");
        int position = sc.nextInt();
        Shape showShape = shapeArray.showShapeByPosition(position); //搜尋指定位置形狀

        if (showShape == null) {  //不符合資訊
            System.out.println("無符合資訊");
        } else { //顯示形狀
            if (showShape instanceof Circle) { //判斷圓形
                System.out.println("圓形=> 面積:" + showShape.area() + " 周長:" + showShape.perimeter());
            } else if (showShape instanceof Rectangle) { //判斷長方形
                System.out.println("長方形=> 面積:" + showShape.area() + " 周長:" + showShape.perimeter());
            }
        }
    }

    /**
     * 新增形狀
     *
     * @param sc         輸入
     * @param shapeArray 形狀陣列
     */
    public static void addShape(Scanner sc, ShapeArray shapeArray) {
        System.out.println("請輸入形狀中心點:");
        System.out.println("中心點x");
        double position_X = sc.nextDouble();
        System.out.println("中心點y");
        double position_Y = sc.nextDouble();
        Point point = new Point(position_X, position_Y);
        System.out.println("選擇形狀:1.圓形 2.長方形 3.正方形");
        int shapeSelect = sc.nextInt();
        switch (shapeSelect) {
            case 1: //圓形
                System.out.println("請輸入半徑");
                double r = sc.nextDouble();
                Shape circle = new Circle(r); //創建圓形
                shapeArray.addShape(circle, point); //新增形狀
                break;
            case 2: //長方形
                System.out.println("請輸入長");
                double w = sc.nextDouble();
                System.out.println("請輸入寬");
                double h = sc.nextDouble();
                Shape rectangle = new Rectangle(w, h); //創建長方形
                shapeArray.addShape(rectangle, point);//新增形狀
                break;
            case 3: //正方形
                System.out.println("請輸入寬");
                double s = sc.nextDouble();
                Shape Square = new Square(s); //創建正方形
                shapeArray.addShape(Square, point);//新增形狀
                break;
        }
    }

    /**
     * 顯示使用者介面
     */
    public static void showOption() {
        System.out.println("請選擇功能:");
        System.out.println("1.新增一個形狀");
        System.out.println("2.列出指定位置的形狀");
        System.out.println("3.依面積大小排序");
        System.out.println("4.依周長大小排序");
        System.out.println("5.依序列出所有形狀");
        System.out.println("6.計算陣列中形狀的中心點兩點距離");
        System.out.println("7.印出中心點在此座標範圍內的形狀");
        System.out.println("8.結束程式");
    }
}
