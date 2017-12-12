public class MyPoint {
    public double x,y;
    public MyPoint(){
        x =  (double) (Math.random()*1000);
        y =  (double) (Math.random()*1000);
    }
    public MyPoint(double x, double y){
        this.x = x;
        this.y = y;
    }
    public void show(){
        System.out.println("("+x+","+y+")");
    }
    public static MyPoint getMiddle(MyPoint p1,MyPoint p2){
        MyPoint p = new MyPoint((p1.x+p2.x)/2,(p1.y+p2.y)/2);
        return p;
    }
    public static void main(String[] args) {
        int n = (int) (Math.random() * 1000);
        MyPoint[] points = new MyPoint[n];
        for (int i = 0; i <= n; i++) {
            points[i] = new MyPoint();
            points[i].show();
        }
    }
}
